package de.alpharogroup.user.service;

import java.util.List;
import java.util.Set;

import javax.persistence.Query;

import de.alpharogroup.collections.ListExtensions;
import de.alpharogroup.db.service.jpa.AbstractBusinessService;
import de.alpharogroup.user.entities.Roles;
import de.alpharogroup.user.entities.Permissions;
import de.alpharogroup.user.factories.UserManagementFactory;
import de.alpharogroup.user.repositories.RolesDao;
import de.alpharogroup.user.service.api.RolesService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service("rolesService")
public class RolesBusinessService extends
		AbstractBusinessService<Roles, Integer, RolesDao> implements
		RolesService {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	@Autowired
	public void setRolesDao(final RolesDao rolesDao) {
		setDao(rolesDao);
	}

	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Permissions> findAllPermissions(final Roles role) {
		final String hqlString = "select rp.permission from RolePermissions rp where rp.role=:role";
		final Query query = getQuery(hqlString);
		query.setParameter("role", role);
		final List<Permissions> permissions = query.getResultList();
		return permissions;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Roles createAndSaveRole(final String rolename, final String description) {
		return createAndSaveRole(rolename, description, null);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Roles createAndSaveRole(final String rolename, final String description,
			final Set<Permissions> permissions) {
		Roles role = findRole(rolename);
		if (role == null) {
			role = UserManagementFactory.getInstance().newRoles(rolename,
					description, permissions);
			role = merge(role);
		}
		return role;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Roles findRole(final String rolename) {
		return ListExtensions.getFirst(findRoles(rolename));
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Roles> findRoles(final String rolename) {
		final String hqlString = "select r from Roles r where r.rolename=:rolename";
		final Query query = getQuery(hqlString);
		query.setParameter("rolename", rolename);
		final List<Roles> roles = query.getResultList();
		return roles;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean exists(final String rolename) {
		return findRole(rolename) != null;
	}

}