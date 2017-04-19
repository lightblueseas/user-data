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

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import de.alpharogroup.collections.ListExtensions;
import de.alpharogroup.db.service.jpa.AbstractBusinessService;
import de.alpharogroup.user.entities.Roles;
import de.alpharogroup.user.entities.Users;
import de.alpharogroup.user.repositories.UsersDao;
import de.alpharogroup.user.service.api.BaseUsersService;

@Transactional
@Service("baseUsersService")
public class BaseUserBusinessService extends AbstractBusinessService<Users, Integer, UsersDao>
	implements
		BaseUsersService
{

	/** The Constant LOGGER. */
	protected final static Logger LOGGER = Logger
		.getLogger(BaseUserBusinessService.class.getName());
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean existsUserWithUsername(final String username)
	{
		final Users users = findUserWithUsername(username);
		if (users != null)
		{
			return true;
		}
		return false;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<Roles> findRolesFromUser(final Users user)
	{
		final String hqlString = "select u.roles from Users u " + "where u=:user";
		final Query query = getQuery(hqlString);
		query.setParameter("user", user);
		final List<Roles> roles = query.getResultList();
		return roles;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	@SuppressWarnings("unchecked")
	public Users findUserWithUsername(final String username)
	{
		final String hqlString = "select u from Users u " + "where u.username=:username";
		final Query query = getQuery(hqlString);
		query.setParameter("username", username);
		final List<Users> users = query.getResultList();
		return ListExtensions.getFirst(users);
	}

	@Autowired
	public void setUsersDao(final UsersDao usersDao)
	{
		setDao(usersDao);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean userIsInRole(final Users user, final Roles role)
	{
		final List<Roles> roles = findRolesFromUser(user);
		if (null != roles && (!roles.isEmpty()))
		{
			if (roles.contains(role))
			{
				return true;
			}
		}
		return false;
	}

}