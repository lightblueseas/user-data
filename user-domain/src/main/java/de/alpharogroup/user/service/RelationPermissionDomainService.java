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
import de.alpharogroup.user.domain.RelationPermission;
import de.alpharogroup.user.domain.User;
import de.alpharogroup.user.entities.Permissions;
import de.alpharogroup.user.entities.RelationPermissions;
import de.alpharogroup.user.entities.Users;
import de.alpharogroup.user.mapper.RelationPermissionsMapper;
import de.alpharogroup.user.repositories.RelationPermissionsDao;
import de.alpharogroup.user.service.api.RelationPermissionService;
import de.alpharogroup.user.service.api.RelationPermissionsService;
import lombok.Getter;
import lombok.Setter;

/**
 * The class {@link RelationPermissionDomainService}.
 */
@Transactional
@Service("relationPermissionDomainService")
public class RelationPermissionDomainService
	extends
		AbstractDomainService<Integer, RelationPermission, RelationPermissions, RelationPermissionsDao, RelationPermissionsMapper>
	implements
		RelationPermissionService
{

	/** The {@link RelationPermissionsService}. */
	@Autowired
	@Getter
	@Setter
	private RelationPermissionsService relationPermissionsService;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void addPermission(final User provider, final User subscriber,
		final Permission permission)
	{
		final Users providers = getMapper().map(provider, Users.class);
		final Users subscribers = getMapper().map(subscriber, Users.class);
		final Permissions permissions = getMapper().map(permission, Permissions.class);
		relationPermissionsService.addPermission(providers, subscribers, permissions);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<RelationPermission> find(final User provider, final User subscriber)
	{
		final Users providers = getMapper().map(provider, Users.class);
		final Users subscribers = getMapper().map(subscriber, Users.class);
		final List<RelationPermission> relationPermissions = getMapper()
			.toDomainObjects(relationPermissionsService.find(providers, subscribers));
		return relationPermissions;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<RelationPermission> find(final User provider, final User subscriber,
		final Permission permission)
	{
		final Users providers = getMapper().map(provider, Users.class);
		final Users subscribers = getMapper().map(subscriber, Users.class);
		final Permissions permissions = getMapper().map(permission, Permissions.class);
		final List<RelationPermission> relationPermissions = getMapper()
			.toDomainObjects(relationPermissionsService.find(providers, subscribers, permissions));
		return relationPermissions;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public RelationPermission findRelationPermissions(final User provider, final User subscriber)
	{
		final Users providers = getMapper().map(provider, Users.class);
		final Users subscribers = getMapper().map(subscriber, Users.class);
		final RelationPermission relationPermission = getMapper().toDomainObject(
			relationPermissionsService.findRelationPermissions(providers, subscribers));
		return relationPermission;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public RelationPermission findRelationPermissions(final User provider, final User subscriber,
		final Permission permission)
	{
		final Users providers = getMapper().map(provider, Users.class);
		final Users subscribers = getMapper().map(subscriber, Users.class);
		final Permissions permissions = getMapper().map(permission, Permissions.class);
		final RelationPermission relationPermission = getMapper()
			.toDomainObject(relationPermissionsService.findRelationPermissions(providers,
				subscribers, permissions));
		return relationPermission;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void removeAllPermissions(final User provider, final User subscriber)
	{
		final Users providers = getMapper().map(provider, Users.class);
		final Users subscribers = getMapper().map(subscriber, Users.class);
		relationPermissionsService.removeAllPermissions(providers, subscribers);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void removePermission(final User provider, final User subscriber,
		final Permission permission)
	{
		final Users providers = getMapper().map(provider, Users.class);
		final Users subscribers = getMapper().map(subscriber, Users.class);
		final Permissions permissions = getMapper().map(permission, Permissions.class);
		relationPermissionsService.removePermission(providers, subscribers, permissions);
	}

	/**
	 * Sets the specific {@link RelationPermissionsDao}.
	 *
	 * @param relationPermissionsDao
	 *            the new {@link RelationPermissionsDao}.
	 */
	@Autowired
	public void setRelationPermissionsDao(final RelationPermissionsDao relationPermissionsDao)
	{
		setDao(relationPermissionsDao);
	}

	/**
	 * Sets the specific {@link RelationPermissionsMapper}.
	 *
	 * @param mapper
	 *            the new {@link RelationPermissionsMapper}.
	 */
	@Autowired
	public void setRelationPermissionsMapper(final RelationPermissionsMapper mapper)
	{
		setMapper(mapper);
	}

}
