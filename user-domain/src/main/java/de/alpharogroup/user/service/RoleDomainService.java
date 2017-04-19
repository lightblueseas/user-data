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

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import de.alpharogroup.service.domain.AbstractDomainService;
import de.alpharogroup.user.domain.Permission;
import de.alpharogroup.user.domain.Role;
import de.alpharogroup.user.entities.Permissions;
import de.alpharogroup.user.entities.Roles;
import de.alpharogroup.user.mapper.RolesMapper;
import de.alpharogroup.user.repositories.RolesDao;
import de.alpharogroup.user.service.api.RoleService;
import de.alpharogroup.user.service.api.RolesService;
import lombok.Getter;
import lombok.Setter;

/**
 * The class {@link RoleDomainService}.
 */
@Transactional
@Service("roleDomainService")
public class RoleDomainService
	extends
		AbstractDomainService<Integer, Role, Roles, RolesDao, RolesMapper>
	implements
		RoleService
{

	/** The {@link RolesService}. */
	@Autowired
	@Getter
	@Setter
	private RolesService rolesService;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Role createAndSaveRole(final String rolename, final String description)
	{
		return getMapper().toDomainObject(rolesService.createAndSaveRole(rolename, description));
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Role createAndSaveRole(final String rolename, final String description,
		final Set<Permission> permissions)
	{
		final List<Permissions> perms = getMapper().map(permissions, Permissions.class);
		final Roles roles = rolesService.createAndSaveRole(rolename, description,
			new HashSet<>(perms));
		return getMapper().toDomainObject(roles);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean exists(final String rolename)
	{
		return rolesService.exists(rolename);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Permission> findAllPermissions(final Role role)
	{
		final Roles roles = getMapper().toEntity(role);
		final List<Permissions> permissions = rolesService.findAllPermissions(roles);
		final List<Permission> perms = getMapper().map(permissions, Permission.class);
		return perms;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Role findRole(final String rolename)
	{
		return getMapper().toDomainObject(rolesService.findRole(rolename));
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Role> findRoles(final String rolename)
	{
		return getMapper().toDomainObjects(rolesService.findRoles(rolename));
	}

	/**
	 * Sets the specific {@link RolesDao}.
	 *
	 * @param rolesDao
	 *            the new {@link RolesDao}.
	 */
	@Autowired
	public void setRolesDao(final RolesDao rolesDao)
	{
		setDao(rolesDao);
	}

	/**
	 * Sets the specific {@link RolesMapper}.
	 *
	 * @param mapper
	 *            the new {@link RolesMapper}.
	 */
	@Autowired
	public void setRolesMapper(final RolesMapper mapper)
	{
		setMapper(mapper);
	}

}
