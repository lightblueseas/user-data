package de.alpharogroup.user.management.rest;

import java.util.List;

import de.alpharogroup.collections.pairs.KeyValuePair;
import de.alpharogroup.service.rs.AbstractRestfulResource;
import de.alpharogroup.user.management.domain.Role;
import de.alpharogroup.user.management.domain.User;
import de.alpharogroup.user.management.rest.api.UsersResource;
import de.alpharogroup.user.management.service.api.UserService;

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
