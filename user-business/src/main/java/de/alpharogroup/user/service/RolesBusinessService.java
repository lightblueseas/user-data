/**
 * The MIT License
 *
 * Copyright (C) 2015 Asterios Raptis
 *
 * Permission is hereby granted, free of charge, to any person obtaining
 * a copy of this software and associated documentation files (the
 * "Software"), to deal in the Software without restriction, including
 * without limitation the rights to use, copy, modify, merge, publish,
 * distribute, sublicense, and/or sell copies of the Software, and to
 * permit persons to whom the Software is furnished to do so, subject to
 * the following conditions:
 *  *
 * The above copyright notice and this permission notice shall be
 * included in all copies or substantial portions of the Software.
 *  *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 * MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE
 * LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION
 * OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION
 * WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
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