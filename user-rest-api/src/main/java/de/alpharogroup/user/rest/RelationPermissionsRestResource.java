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
package de.alpharogroup.user.rest;

import java.util.List;

import de.alpharogroup.collections.pairs.KeyValuePair;
import de.alpharogroup.collections.pairs.Triple;
import de.alpharogroup.service.rs.AbstractRestfulResource;
import de.alpharogroup.user.domain.Permission;
import de.alpharogroup.user.domain.RelationPermission;
import de.alpharogroup.user.domain.User;
import de.alpharogroup.user.rest.api.RelationPermissionsResource;
import de.alpharogroup.user.service.api.RelationPermissionService;

public class RelationPermissionsRestResource
	extends
		AbstractRestfulResource<Integer, RelationPermission, RelationPermissionService>
	implements
		RelationPermissionsResource
{

	@Override
	public void addPermission(final Triple<User, User, Permission> providerToSubscriberOfPerms)
	{
		getDomainService().addPermission(providerToSubscriberOfPerms.getLeft(),
			providerToSubscriberOfPerms.getMiddle(), providerToSubscriberOfPerms.getRight());
	}

	@Override
	public List<RelationPermission> find(final KeyValuePair<User, User> providerToSubscriber)
	{
		return getDomainService().find(providerToSubscriber.getKey(),
			providerToSubscriber.getValue());
	}

	@Override
	public List<RelationPermission> find(
		final Triple<User, User, Permission> providerToSubscriberOfPerms)
	{
		return getDomainService().find(providerToSubscriberOfPerms.getLeft(),
			providerToSubscriberOfPerms.getMiddle(), providerToSubscriberOfPerms.getRight());
	}

	@Override
	public RelationPermission findRelationPermissions(
		final KeyValuePair<User, User> providerToSubscriber)
	{
		return getDomainService().findRelationPermissions(providerToSubscriber.getKey(),
			providerToSubscriber.getValue());
	}

	@Override
	public RelationPermission findRelationPermissions(
		final Triple<User, User, Permission> providerToSubscriberOfPerms)
	{
		return getDomainService().findRelationPermissions(providerToSubscriberOfPerms.getLeft(),
			providerToSubscriberOfPerms.getMiddle(), providerToSubscriberOfPerms.getRight());
	}

	@Override
	public void removeAllPermissions(final KeyValuePair<User, User> providerToSubscriber)
	{
		getDomainService().removeAllPermissions(providerToSubscriber.getKey(),
			providerToSubscriber.getValue());
	}

	@Override
	public void removePermission(final Triple<User, User, Permission> providerToSubscriberOfPerms)
	{
		getDomainService().removePermission(providerToSubscriberOfPerms.getLeft(),
			providerToSubscriberOfPerms.getMiddle(), providerToSubscriberOfPerms.getRight());
	}

}
