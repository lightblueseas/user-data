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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import de.alpharogroup.collections.list.ListExtensions;
import de.alpharogroup.db.service.jpa.AbstractBusinessService;
import de.alpharogroup.user.entities.Permissions;
import de.alpharogroup.user.entities.RelationPermissions;
import de.alpharogroup.user.entities.Users;
import de.alpharogroup.user.factories.UserManagementFactory;
import de.alpharogroup.user.repositories.RelationPermissionsDao;
import de.alpharogroup.user.service.api.RelationPermissionsService;
import de.alpharogroup.user.service.util.HqlStringCreator;

@Transactional
@Service("relationPermissionsService")
public class RelationPermissionsBusinessService
	extends
		AbstractBusinessService<RelationPermissions, Integer, RelationPermissionsDao>
	implements
		RelationPermissionsService
{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	@Override
	public void addPermission(final Users provider, final Users subscriber,
		final Permissions permission)
	{
		RelationPermissions rp = findRelationPermissions(provider, subscriber, permission);
		if (rp == null)
		{
			rp = findRelationPermissions(provider, subscriber);
			if (rp == null)
			{
				rp = UserManagementFactory.getInstance().newRelationPermissions(provider,
					subscriber);
			}
			rp.getPermissions().add(permission);
			merge(rp);
		}
	}

	@Override
	public List<RelationPermissions> find(final Users provider, final Users subscriber)
	{
		return find(provider, subscriber, null);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<RelationPermissions> find(final Users provider, final Users subscriber,
		final Permissions permission)
	{
		final String hqlString = HqlStringCreator.forRelationPermissions(provider, subscriber,
			permission);
		final Query query = getQuery(hqlString);
		if (provider != null)
		{
			query.setParameter("provider", provider);
		}
		if (subscriber != null)
		{
			query.setParameter("subscriber", subscriber);
		}
		if (permission != null)
		{
			query.setParameter("permission", permission);
		}
		final List<RelationPermissions> list = query.getResultList();
		return list;
	}

	@Override
	public RelationPermissions findRelationPermissions(final Users provider, final Users subscriber)
	{
		return ListExtensions.getFirst(find(provider, subscriber));
	}

	@Override
	public RelationPermissions findRelationPermissions(final Users provider, final Users subscriber,
		final Permissions permission)
	{
		return ListExtensions.getFirst(find(provider, subscriber, permission));
	}


	@Override
	public void removeAllPermissions(final Users provider, final Users subscriber)
	{
		// delete all permissions that are given for both users
		RelationPermissions relationPermissions = findRelationPermissions(provider, subscriber);
		if (relationPermissions != null)
		{
			relationPermissions.setProvider(null);
			relationPermissions.setSubscriber(null);
			relationPermissions = merge(relationPermissions);
			delete(relationPermissions);
		}
		relationPermissions = findRelationPermissions(subscriber, provider);
		if (relationPermissions != null)
		{
			relationPermissions.setProvider(null);
			relationPermissions.setSubscriber(null);
			relationPermissions = merge(relationPermissions);
			delete(relationPermissions);
		}
	}


	@Override
	public void removePermission(final Users provider, final Users subscriber,
		final Permissions permission)
	{
		final RelationPermissions rp = findRelationPermissions(provider, subscriber, permission);
		if (rp != null)
		{
			rp.getPermissions().remove(permission);
			merge(rp);
		}
	}


	@Autowired
	public void setRelationPermissionsDao(final RelationPermissionsDao relationPermissionsDao)
	{
		setDao(relationPermissionsDao);
	}
}