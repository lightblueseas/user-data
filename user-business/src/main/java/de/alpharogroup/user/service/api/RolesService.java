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

import de.alpharogroup.db.service.api.BusinessService;
import de.alpharogroup.user.entities.Roles;
import de.alpharogroup.user.entities.Permissions;

/**
 * The interface {@link RolesService}.
 */
public interface RolesService extends BusinessService<Roles, Integer>{

	/**
	 * Find all {@link Permissions} objects from the given {@link Roles} object.
	 * 
	 * @param role
	 *            the given {@link Roles} object
	 * @return 's a list with all {@link Permissions} objects from the given {@link Roles} object.
	 */
	List<Permissions> findAllPermissions(Roles role);
	
	/**
	 * Find the {@link Roles} object with the given role name. If it does'nt exists it returns null.
	 *
	 * @param rolename the role name
	 * @return the found {@link Roles} object or if it does'nt exists it returns null.
	 */
	Roles findRole(final String rolename);
	
	/**
	 * Find the {@link Roles} objects with the given role name.
	 *
	 * @param rolename the rolename
	 * @return the found {@link Roles} objects
	 */
	List<Roles> findRoles(final String rolename);
	
	/**
	 * Checks if a role exists with the given role name.
	 *
	 * @param rolename the role name
	 * @return true, if successful
	 */
	boolean exists(final String rolename);
	
	/**
	 * Creates a new {@link Roles} object with the given arguments and save it. If it does exists it will return the existing.
	 *
	 * @param rolename the role name.
	 * @param description the description of the role.
	 * @return the created or existing {@link Roles} object.
	 */
	Roles createAndSaveRole(String rolename, String description);
	
	/**
	 * Creates a new {@link Roles} object with the given arguments and save it. If it does exists it will return the existing.
	 *
	 * @param rolename the role name.
	 * @param description the description of the role.
	 * @param permissions the permissions to set for the role.
	 * @return the created or existing {@link Roles} object.
	 */
	Roles createAndSaveRole(String rolename, String description, Set<Permissions> permissions);

}