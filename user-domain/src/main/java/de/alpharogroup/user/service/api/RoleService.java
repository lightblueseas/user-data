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
import java.util.Set;

import de.alpharogroup.service.domain.DomainService;
import de.alpharogroup.user.domain.Permission;
import de.alpharogroup.user.domain.Role;

/**
 * The interface {@link RoleService}.
 */
public interface RoleService extends DomainService<Integer, Role>
{

	/**
	 * Creates a new {@link Role} object with the given arguments and save it. If it does exists it
	 * will return the existing.
	 *
	 * @param rolename
	 *            the role name.
	 * @param description
	 *            the description of the role.
	 * @return the created or existing {@link Role} object.
	 */
	Role createAndSaveRole(String rolename, String description);

	/**
	 * Creates a new {@link Role} object with the given arguments and save it. If it does exists it
	 * will return the existing.
	 *
	 * @param rolename
	 *            the role name.
	 * @param description
	 *            the description of the role.
	 * @param permissions
	 *            the permissions to set for the role.
	 * @return the created or existing {@link Role} object.
	 */
	Role createAndSaveRole(String rolename, String description, Set<Permission> permissions);

	/**
	 * Checks if a role exists with the given role name.
	 *
	 * @param rolename
	 *            the role name
	 * @return true, if successful
	 */
	boolean exists(final String rolename);

	/**
	 * Find all {@link Permission} objects from the given {@link Role} object.
	 *
	 * @param role
	 *            the given {@link Role} object
	 * @return 's a list with all {@link Permission} objects from the given {@link Role} object.
	 */
	List<Permission> findAllPermissions(Role role);

	/**
	 * Find the {@link Role} object with the given role name. If it does'nt exists it returns null.
	 *
	 * @param rolename
	 *            the role name
	 * @return the found {@link Role} object or if it does'nt exists it returns null.
	 */
	Role findRole(final String rolename);

	/**
	 * Find the {@link Role} objects with the given role name.
	 *
	 * @param rolename
	 *            the rolename
	 * @return the found {@link Role} objects
	 */
	List<Role> findRoles(final String rolename);
}
