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
import de.alpharogroup.user.entities.Roles;
import de.alpharogroup.user.entities.Users;

/**
 * The interface {@link BaseUsersService}.
 */
public interface BaseUsersService extends BusinessService<Users, Integer>
{

	/**
	 * Checks if a user exists with the given user name.
	 * 
	 * @param username
	 *            the user name
	 * @return true, if successful
	 */
	boolean existsUserWithUsername(String username);

	/**
	 * Find roles from the given {@link Users}.
	 * 
	 * @param user
	 *            the user
	 * @return the list of found {@link Roles} from the given {@link Users}.
	 */
	List<Roles> findRolesFromUser(final Users user);

	/**
	 * Find {@link Users} object from the given user name.
	 * 
	 * @param username
	 *            the user name
	 * @return the found {@link Users} object
	 */
	Users findUserWithUsername(final String username);

	/**
	 * Checks if the given {@link Users} object is in the given {@link Roles} object.
	 * 
	 * @param user
	 *            the user
	 * @param role
	 *            the role
	 * @return true, if successful
	 */
	boolean userIsInRole(final Users user, final Roles role);

}