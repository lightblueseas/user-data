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