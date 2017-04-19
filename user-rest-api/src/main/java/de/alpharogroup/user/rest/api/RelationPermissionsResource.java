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
package de.alpharogroup.user.rest.api;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import de.alpharogroup.collections.pairs.KeyValuePair;
import de.alpharogroup.collections.pairs.Triple;
import de.alpharogroup.service.rs.RestfulResource;
import de.alpharogroup.user.domain.Permission;
import de.alpharogroup.user.domain.RelationPermission;
import de.alpharogroup.user.domain.User;

/**
 * The interface {@link RelationPermissionsResource} provides methods for resolving relations of
 * permissions from user objects.
 */
@Path("/relation/permission/")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public interface RelationPermissionsResource extends RestfulResource<Integer, RelationPermission>
{

	/**
	 * Adds the given permission for the given subscriber provided from the provider. The left is
	 * the provider the middle is the subscriber and right is the permission.
	 *
	 * @param providerToSubscriberOfPerms
	 *            The left is the provider the middle is the subscriber and right is the permission.
	 */
	@POST
	@Path("/add/perm")
	void addPermission(final Triple<User, User, Permission> providerToSubscriberOfPerms);

	/**
	 * Find a list of RelationPermissions that the given provider granted to the subscriber.
	 *
	 * @param providerToSubscriber
	 *            The key is the provider and the value the subscriber.
	 * @return all found relation-permissions as list
	 */
	@POST
	@Path("/find")
	List<RelationPermission> find(final KeyValuePair<User, User> providerToSubscriber);

	/**
	 * Find a list of RelationPermissions from the given provider and to the subscriber and the
	 * given permission if the provider granted this permission to the subscriber. The left is the
	 * provider the middle is the subscriber and right is the permission.
	 *
	 * @param providerToSubscriberOfPerms
	 *            The left is the provider the middle is the subscriber and right is the permission.
	 * 
	 * @return all found relation-permissions as list
	 */
	@POST
	@Path("/find/by/perm")
	List<RelationPermission> find(final Triple<User, User, Permission> providerToSubscriberOfPerms);

	/**
	 * Find all given permissions that the given provider granted to the subscriber.
	 *
	 * @param providerToSubscriber
	 *            The key is the provider and the value the subscriber.
	 * @return the found relation permission
	 */
	@POST
	@Path("/find/all")
	RelationPermission findRelationPermissions(final KeyValuePair<User, User> providerToSubscriber);

	/**
	 * Finds the RelationPermissions object from the given permissions the given provider and the
	 * subscriber.
	 *
	 * @param providerToSubscriberOfPerms
	 *            The left is the provider the middle is the subscriber and right is the permission.
	 * @return the relation permission
	 */
	@POST
	@Path("/find/rel/perm")
	RelationPermission findRelationPermissions(
		final Triple<User, User, Permission> providerToSubscriberOfPerms);

	/**
	 * Removes all permissions that are given for both users. The key is the provider and the value
	 * the subscriber.
	 *
	 * @param providerToSubscriber
	 *            The key is the provider and the value the subscriber.
	 */
	@POST
	@Path("/remove/all")
	void removeAllPermissions(final KeyValuePair<User, User> providerToSubscriber);

	/**
	 * Removes the given permission for the given subscriber provided from the provider.
	 *
	 * @param providerToSubscriberOfPerms
	 *            The left is the provider the middle is the subscriber and right is the permission.
	 */
	@POST
	@Path("/remove/perm")
	void removePermission(final Triple<User, User, Permission> providerToSubscriberOfPerms);
}
