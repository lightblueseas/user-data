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
package de.alpharogroup.user.rest.api;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import de.alpharogroup.collections.pairs.KeyValuePair;
import de.alpharogroup.service.rs.RestfulResource;
import de.alpharogroup.user.domain.ResetPassword;
import de.alpharogroup.user.domain.User;

/**
 * The interface {@link ResetPasswordsResource} provides methods for reset passwords from user
 * objects.
 */
@Path("/reset/passwords/")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public interface ResetPasswordsResource extends RestfulResource<Integer, ResetPassword>
{

	/**
	 * Find the entry from the given {@link User} and the given generated password(hashed).
	 *
	 * @param userAndGenPw
	 *            The key is the user and the value the generated password(hashed) is the
	 *            confirmationCode from the url query string.
	 * @return the entry of the found {@link ResetPassword} or null if not found
	 */
	@POST
	@Path("/find/by/gpw")
	ResetPassword findResetPassword(final KeyValuePair<User, String> userAndGenPw);

	/**
	 * Finds the {@link ResetPassword} object from the given {@link User} object.
	 *
	 * @param user
	 *            the user
	 * @return the entry of the found {@link ResetPassword} or null if not found
	 */
	@POST
	@Path("/find")
	ResetPassword findResetPassword(User user);
}
