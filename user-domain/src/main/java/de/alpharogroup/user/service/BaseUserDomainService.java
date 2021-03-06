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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import de.alpharogroup.service.domain.AbstractDomainService;
import de.alpharogroup.user.domain.Role;
import de.alpharogroup.user.domain.User;
import de.alpharogroup.user.entities.Roles;
import de.alpharogroup.user.entities.Users;
import de.alpharogroup.user.mapper.UsersMapper;
import de.alpharogroup.user.repositories.UsersDao;
import de.alpharogroup.user.service.api.BaseUserService;
import de.alpharogroup.user.service.api.BaseUsersService;
import lombok.Getter;
import lombok.Setter;

/**
 * The class {@link BaseUserDomainService}.
 */
@Transactional
@Service("baseUserDomainService")
public class BaseUserDomainService
	extends
		AbstractDomainService<Integer, User, Users, UsersDao, UsersMapper>
	implements
		BaseUserService
{

	/** The {@link BaseUsersService}. */
	@Autowired
	@Getter
	@Setter
	private BaseUsersService usersService;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean existsUserWithUsername(final String username)
	{
		return usersService.existsUserWithUsername(username);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Role> findRolesFromUser(final User user)
	{
		final Users users = getMapper().toEntity(user);
		final List<Roles> roles = usersService.findRolesFromUser(users);
		final List<Role> roless = getMapper().map(roles, Role.class);
		return roless;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public User findUserWithUsername(final String username)
	{
		final Users users = usersService.findUserWithUsername(username);
		final User user = getMapper().toDomainObject(users);
		return user;
	}

	/**
	 * {@inheritDoc}
	 */
	// @Override
	// public List<Address> findAddressesFromUser(final User user) {
	// final Users users = getMapper().toEntity(user);
	// final List<Addresses> addresses = usersService.findAddressesFromUser(users);
	// final List<Address> addresss = getMapper().map(addresses, Address.class);
	// return addresss;
	// }

	/**
	 * {@inheritDoc}
	 */
	// @Override
	// public Address findAddressFromUser(final User user) {
	// final Users users = getMapper().toEntity(user);
	// final Addresses addresses = usersService.findAddressFromUser(users);
	// final Address addresss = getMapper().map(addresses, Address.class);
	// return addresss;
	// }

	/**
	 * Sets the specific {@link UsersDao}.
	 *
	 * @param usersDao
	 *            the new {@link UsersDao}.
	 */
	@Autowired
	public void setUsersDao(final UsersDao usersDao)
	{
		setDao(usersDao);
	}

	/**
	 * {@inheritDoc}
	 */
	// @Override
	// public User findUserWithEmail(final String email) {
	// final Users users = usersService.findUserWithEmail(email);
	// final User user = getMapper().toDomainObject(users);
	// return user;
	// }

	/**
	 * Sets the specific {@link UsersMapper}.
	 *
	 * @param mapper
	 *            the new {@link UsersMapper}.
	 */
	@Autowired
	public void setUsersMapper(final UsersMapper mapper)
	{
		setMapper(mapper);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean userIsInRole(final User user, final Role role)
	{
		final Users users = getMapper().toEntity(user);
		final Roles roles = getMapper().map(role, Roles.class);
		return usersService.userIsInRole(users, roles);
	}
	//
	// /**
	// * {@inheritDoc}
	// */
	// @Override
	// public List<User> findUsers(final Integer from, final GenderType searchGender, final Integer
	// until) {
	// final List<Users> users = usersService.findUsers(from, searchGender, until);
	// final List<User> userss = getMapper().map(users, User.class);
	// return userss;
	// }
	//
	// /**
	// * {@inheritDoc}
	// */
	// @Override
	// public List<User> findUsers(final Integer from, final GenderType searchGender, final Integer
	// until, final String geohash) {
	// final List<Users> users = usersService.findUsers(from, searchGender, until, geohash);
	// final List<User> userss = getMapper().map(users, User.class);
	// return userss;
	// }

}
