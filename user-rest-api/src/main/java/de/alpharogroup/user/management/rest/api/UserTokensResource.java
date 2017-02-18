package de.alpharogroup.user.management.rest.api;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import de.alpharogroup.service.rs.RestfulResource;
import de.alpharogroup.user.management.domain.UserToken;

/**
 * The interface {@link UserTokensResource} provides methods for resolve users.
 */
@Path("/user/")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public interface UserTokensResource extends RestfulResource<Integer, UserToken>
{

	/**
	 * Find all token from the given user name.
	 *
	 * @param username the username
	 * @return the found {@link UserTokens} or null if no result.
	 */
	UserToken find(final String username);

	/**
	 * Find all token from the given user name.
	 *
	 * @param username the username
	 * @return the list
	 */
	List<UserToken> findAll(final String username);

	/**
	 * Gets the authetication token from the given user name.
	 *
	 * @param username the username
	 * @return the authetication token or null if no result.
	 */
	String getAutheticationToken(final String username);

	/**
	 * Checks if the given token is valid.
	 *
	 * @param token the token to validate
	 * @return true, if the given token is valid otherwise false
	 */
	boolean isValid(String token);

}
