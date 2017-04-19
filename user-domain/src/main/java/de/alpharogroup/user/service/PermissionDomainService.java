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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import de.alpharogroup.service.domain.AbstractDomainService;
import de.alpharogroup.user.domain.Permission;
import de.alpharogroup.user.entities.Permissions;
import de.alpharogroup.user.mapper.PermissionsMapper;
import de.alpharogroup.user.repositories.PermissionsDao;
import de.alpharogroup.user.service.api.PermissionService;
import de.alpharogroup.user.service.api.PermissionsService;
import lombok.Getter;
import lombok.Setter;

/**
 * The class {@link PermissionDomainService}.
 */
@Transactional
@Service("permissionDomainService")
public class PermissionDomainService
	extends
		AbstractDomainService<Integer, Permission, Permissions, PermissionsDao, PermissionsMapper>
	implements
		PermissionService
{

	/** The {@link PermissionsService}. */
	@Autowired
	@Getter
	@Setter
	private PermissionsService permissionsService;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Permission createAndSavePermissions(final String name, final String description)
	{
		return getMapper()
			.toDomainObject(permissionsService.createAndSavePermissions(name, description));
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Permission createAndSavePermissions(final String name, final String description,
		final String shortcut)
	{
		return getMapper().toDomainObject(
			permissionsService.createAndSavePermissions(name, description, shortcut));
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Permission> find(final String description, final String permissionName,
		final String shortcut)
	{
		return getMapper()
			.toDomainObjects(permissionsService.find(description, permissionName, shortcut));
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Permission findByName(final String name)
	{
		return getMapper().toDomainObject(permissionsService.findByName(name));
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Permission findByShortcut(final String shortcut)
	{
		return getMapper().toDomainObject(permissionsService.findByShortcut(shortcut));
	}

	/**
	 * Sets the specific {@link PermissionsDao}.
	 *
	 * @param permissionsDao
	 *            the new {@link PermissionsDao}.
	 */
	@Autowired
	public void setPermissionsDao(final PermissionsDao permissionsDao)
	{
		setDao(permissionsDao);
	}

	/**
	 * Sets the specific {@link PermissionsMapper}.
	 *
	 * @param mapper
	 *            the new {@link PermissionsMapper}.
	 */
	@Autowired
	public void setPermissionsMapper(final PermissionsMapper mapper)
	{
		setMapper(mapper);
	}

}
