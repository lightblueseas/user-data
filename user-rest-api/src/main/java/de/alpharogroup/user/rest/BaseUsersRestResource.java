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
import de.alpharogroup.service.rs.AbstractRestfulResource;
import de.alpharogroup.user.domain.Role;
import de.alpharogroup.user.domain.User;
import de.alpharogroup.user.service.api.BaseUserService;
import de.alpharogroup.user.rest.api.BaseUsersResource;

public class BaseUsersRestResource
	extends
 AbstractRestfulResource<Integer, User, BaseUserService>
	implements
		BaseUsersResource
{

	@Override
	public List<User> findAll() {
		return getDomainService().findAll();
	}

	@Override
	public boolean existsUserWithUsername(final String username) {
		return getDomainService().existsUserWithUsername(username);
	}

	@Override
	public List<Role> findRolesFromUser(final User user) {
		return getDomainService().findRolesFromUser(user);
	}

	@Override
	public User findUserWithUsername(final String username) {
		return getDomainService().findUserWithUsername(username);
	}

	@Override
	public boolean userIsInRole(final KeyValuePair<User, Role> user) {
		return getDomainService().userIsInRole(user.getKey(), user.getValue());
	}

}
