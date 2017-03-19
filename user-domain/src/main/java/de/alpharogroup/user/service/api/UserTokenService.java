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
