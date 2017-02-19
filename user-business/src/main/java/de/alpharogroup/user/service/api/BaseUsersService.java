package de.alpharogroup.user.service.api;

import java.util.List;

import de.alpharogroup.db.service.api.BusinessService;
import de.alpharogroup.user.entities.Roles;
import de.alpharogroup.user.entities.Users;

/**
 * The interface {@link BaseUsersService}.
 */
public interface BaseUsersService extends BusinessService<Users, Integer> {

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
	 * Checks if the given {@link Users} object is in the given {@link Roles}
	 * object.
	 * 
	 * @param user
	 *            the user
	 * @param role
	 *            the role
	 * @return true, if successful
	 */
	boolean userIsInRole(final Users user, final Roles role);

}