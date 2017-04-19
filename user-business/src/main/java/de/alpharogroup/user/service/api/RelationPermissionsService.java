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
package de.alpharogroup.user.service.api;

import java.util.List;

import de.alpharogroup.db.service.api.BusinessService;
import de.alpharogroup.user.entities.Permissions;
import de.alpharogroup.user.entities.RelationPermissions;
import de.alpharogroup.user.entities.Users;

/**
 * The interface {@link RelationPermissionsService}.
 */
public interface RelationPermissionsService extends BusinessService<RelationPermissions, Integer>
{

	/**
	 * Adds the given permission for the given subscriber provided from the provider.
	 *
	 * @param provider
	 *            the provider
	 * @param subscriber
	 *            the subscriber
	 * @param permission
	 *            the permission
	 */
	void addPermission(Users provider, Users subscriber, Permissions permission);

	/**
	 * Find a list of RelationPermissions that the given provider granted to the subscriber.
	 * 
	 * @param provider
	 *            the provider
	 * @param subscriber
	 *            the subscriber
	 * @return the list
	 */
	List<RelationPermissions> find(final Users provider, final Users subscriber);

	/**
	 * Find a list of RelationPermissions from the given provider and to the subscriber and the
	 * given permission if the provider granted this permission to the subscriber.
	 * 
	 * @param provider
	 *            the provider
	 * @param subscriber
	 *            the subscriber
	 * @param permission
	 *            the permission
	 * @return the list
	 */
	List<RelationPermissions> find(final Users provider, final Users subscriber,
		Permissions permission);

	/**
	 * Find all given permissions that the given provider granted to the subscriber.
	 * 
	 * @param provider
	 *            the provider
	 * @param subscriber
	 *            the subscriber
	 * @return the list
	 */
	RelationPermissions findRelationPermissions(final Users provider, final Users subscriber);

	/**
	 * Finds the RelationPermissions object from the given permissions the given provider and the
	 * subscriber.
	 * 
	 * @param provider
	 *            the provider
	 * @param subscriber
	 *            the subscriber
	 * @param permission
	 *            the permission
	 * @return the relation permissions
	 */
	RelationPermissions findRelationPermissions(final Users provider, final Users subscriber,
		Permissions permission);

	/**
	 * Removes all permissions that are given for both users.
	 *
	 * @param provider
	 *            the provider
	 * @param subscriber
	 *            the subscriber
	 */
	void removeAllPermissions(Users provider, Users subscriber);

	/**
	 * Removes the given permission for the given subscriber provided from the provider.
	 *
	 * @param provider
	 *            the provider
	 * @param subscriber
	 *            the subscriber
	 * @param permission
	 *            the permission
	 */
	void removePermission(Users provider, Users subscriber, Permissions permission);

}