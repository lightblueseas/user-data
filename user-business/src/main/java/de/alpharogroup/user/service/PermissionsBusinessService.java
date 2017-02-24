package de.alpharogroup.user.service;

import java.util.List;

import javax.persistence.Query;

import de.alpharogroup.collections.ListExtensions;
import de.alpharogroup.db.service.jpa.AbstractBusinessService;
import de.alpharogroup.user.entities.Permissions;
import de.alpharogroup.user.factories.UserManagementFactory;
import de.alpharogroup.user.repositories.PermissionsDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import de.alpharogroup.user.service.util.HqlStringCreator;
import de.alpharogroup.user.service.api.PermissionsService;

@Transactional
@Service("permissionsService")
public class PermissionsBusinessService extends
		AbstractBusinessService<Permissions, Integer, PermissionsDao> implements
		PermissionsService {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	@Autowired
	public void setPermissionsDao(final PermissionsDao permissionsDao) {
		setDao(permissionsDao);
	}

	@Override
	public Permissions createAndSavePermissions(final String name, final String description) {
		return createAndSavePermissions(name, description, null);
	}

	@Override
	public Permissions createAndSavePermissions(final String name,
			final String description, final String shortcut) {
		Permissions permissions = UserManagementFactory.getInstance()
				.newPermissions(name, description, shortcut);
		permissions = merge(permissions);
		return permissions;
	}

	@Override
	public Permissions findByShortcut(final String shortcut) {
		return ListExtensions.getFirst(find(null, null, shortcut));
	}

	@Override
	public Permissions findByName(final String name) {
		return ListExtensions.getFirst(find(null, name, null));
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Permissions> find(final String description, final String permissionName, final String shortcut) {
		final String hqlString = HqlStringCreator.forPermissions(description, permissionName, shortcut);
		final Query query = getQuery(hqlString);
		if(description != null){
			query.setParameter("description", description);
		}
		if(permissionName != null){
			query.setParameter("permissionName", permissionName);
		}
		if(shortcut != null){
			query.setParameter("shortcut", shortcut);
		}
		final List<Permissions> permissions = query.getResultList();
		return permissions;
	}

}