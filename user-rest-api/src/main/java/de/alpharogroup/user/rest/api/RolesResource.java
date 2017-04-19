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
import java.util.Set;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import de.alpharogroup.collections.pairs.KeyValuePair;
import de.alpharogroup.collections.pairs.Triple;
import de.alpharogroup.service.rs.RestfulResource;
import de.alpharogroup.user.domain.Permission;
import de.alpharogroup.user.domain.Role;

/**
 * The interface {@link RolesResource} provides methods for resolve roles of users.
 */
@Path("/roles/")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public interface RolesResource extends RestfulResource<Integer, Role>
{

	/**
	 * Creates a new {@link Role} object with the given arguments and save it. If it does exists it
	 * will return the existing.
	 *
	 * @param newRole
	 *            a {@link KeyValuePair} object where the key is the role name and value the
	 *            description of the role.
	 * @return the created or existing {@link Role} object.
	 */
	@POST
	@Path("/new")
	Role createAndSaveRole(KeyValuePair<String, String> newRole);

	/**
	 * Creates a new {@link Role} object with the given arguments and save it. If it does exists it
	 * will return the existing.
	 *
	 * @param roleToCreate
	 *            the role to create. The left is the role name the middle is the description and
	 *            right is the permissions to set for the role.
	 * @return the new created or existing {@link Role} object.
	 */
	@POST
	@Path("/new/with/perms")
	Role createAndSaveRole(final Triple<String, String, Set<Permission>> roleToCreate);

	/**
	 * Checks if a role exists with the given role name.
	 *
	 * @param rolename
	 *            the role name
	 * @return true, if successful
	 */
	@POST
	@Path("/exists")
	boolean exists(final String rolename);

	/**
	 * Find all {@link Permission} objects from the given {@link Role} object.
	 *
	 * @param role
	 *            the given {@link Role} object
	 * @return 's a list with all {@link Permission} objects from the given {@link Role} object.
	 */
	@POST
	@Path("/find/all/perms")
	List<Permission> findAllPermissions(Role role);

	/**
	 * Find the {@link Role} object with the given role name. If it does'nt exists it returns null.
	 *
	 * @param rolename
	 *            the role name
	 * @return the found {@link Role} object or if it does'nt exists it returns null.
	 */
	@POST
	@Path("/find")
	Role findRole(final String rolename);

	/**
	 * Find the {@link Role} objects with the given role name.
	 *
	 * @param rolename
	 *            the rolename
	 * @return the found {@link Role} objects
	 */
	@POST
	@Path("/find/by/name")
	List<Role> findRoles(final String rolename);
}
