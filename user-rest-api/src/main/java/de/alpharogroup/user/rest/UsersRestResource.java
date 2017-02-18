package de.alpharogroup.user.rest;

import java.util.List;

import de.alpharogroup.collections.pairs.KeyValuePair;
import de.alpharogroup.service.rs.AbstractRestfulResource;
import de.alpharogroup.user.domain.Role;
import de.alpharogroup.user.domain.User;
import de.alpharogroup.user.service.api.UserService;
import de.alpharogroup.user.rest.api.UsersResource;

public class UsersRestResource
	extends
 AbstractRestfulResource<Integer, User, UserService>
	implements
		UsersResource
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
