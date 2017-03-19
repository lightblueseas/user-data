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

import de.alpharogroup.service.domain.DomainService;
import de.alpharogroup.user.domain.ResetPassword;
import de.alpharogroup.user.domain.User;

/**
 * The interface {@link ResetPasswordService}.
 */
public interface ResetPasswordService extends DomainService<Integer, ResetPassword> {

	/**
	 * Find the entry from the given {@link User} and the given generated password(hashed).
	 *
	 * @param user the user
	 * @param generatedPassword the generated password(hashed) is the confirmationCode from the url query string
	 * @return the entry of the found {@link ResetPassword} or null if not found
	 */
	ResetPassword findResetPassword(User user, String generatedPassword);

	/**
	 * Finds the {@link ResetPassword} object from the given {@link User} object.
	 *
	 * @param user the user
	 * @return the entry of the found {@link ResetPassword} or null if not found
	 */
	ResetPassword findResetPassword(User user);
}
