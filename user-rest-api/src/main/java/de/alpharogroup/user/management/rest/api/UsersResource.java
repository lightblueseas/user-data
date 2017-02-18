package de.alpharogroup.user.management.rest.api;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import de.alpharogroup.collections.pairs.KeyValuePair;
import de.alpharogroup.service.rs.RestfulResource;
import de.alpharogroup.user.management.domain.Role;
import de.alpharogroup.user.management.domain.User;

/**
 * The interface {@link UsersResource} provides methods for resolve users.
 */
@Path("/user/")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public interface UsersResource extends RestfulResource<Integer, User>
{

	@GET
	@Path("/findall/")
	List<User> findAll();


	/**
	 * Checks if a user exists with the given user name.
	 *
	 * @param username
	 *            the user name
	 * @return true, if successful
	 */
	@GET
	@Path("/exists/user/with/username/{username}")
	boolean existsUserWithUsername(@PathParam("username")String username);

	/**
	 * Find roles from the given {@link User}.
	 *
	 * @param user
	 *            the user
	 * @return the list of found {@link Role} from the given {@link User}.
	 */
	@POST
	@Path("/find/roles")
	List<Role> findRolesFromUser(final User user);

	/**
	 * Find {@link User} object from the given user name.
	 *
	 * @param username
	 *            the user name
	 * @return the found {@link User} object
	 */
	@GET
	@Path("/find/by/username/{username}")
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
	@POST
	@Path("/user/is/in/role")
	boolean userIsInRole(final KeyValuePair<User, Role> user);

}
