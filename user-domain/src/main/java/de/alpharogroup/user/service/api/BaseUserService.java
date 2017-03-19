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

import de.alpharogroup.service.domain.DomainService;
import de.alpharogroup.user.domain.Role;
import de.alpharogroup.user.domain.User;

/**
 * The interface {@link BaseUserService}.
 */
public interface BaseUserService extends DomainService<Integer, User> {

	/**
	 * Checks if a user exists with the given user name.
	 *
	 * @param username
	 *            the user name
	 * @return true, if successful
	 */
	boolean existsUserWithUsername(String username);

	/**
	 * Find roles from the given {@link User}.
	 *
	 * @param user
	 *            the user
	 * @return the list of found {@link Role} from the given {@link User}.
	 */
	List<Role> findRolesFromUser(final User user);

	/**
	 * Find {@link User} object from the given user name.
	 *
	 * @param username
	 *            the user name
	 * @return the found {@link User} object
	 */
	User findUserWithUsername(final String username);

	/**
	 * Checks if the given {@link User} object is in the given {@link Role}
	 * object.
	 *
	 * @param user
	 *            the user
	 * @param role
	 *            the role
	 * @return true, if successful
	 */
	boolean userIsInRole(final User user, final Role role);

}
