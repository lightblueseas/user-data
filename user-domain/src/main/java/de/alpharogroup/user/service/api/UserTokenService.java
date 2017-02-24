package de.alpharogroup.user.service.api;

import java.util.List;

import de.alpharogroup.service.domain.DomainService;
import de.alpharogroup.user.domain.UserToken;
import de.alpharogroup.user.entities.UserTokens;

/**
 * The interface {@link UserTokenService}.
 */
public interface UserTokenService extends DomainService<Integer, UserToken> {


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
