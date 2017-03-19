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
package de.alpharogroup.user.rest;

import javax.ws.rs.core.Response;

import org.apache.commons.collections4.CollectionUtils;

import de.alpharogroup.auth.Credentials;
import de.alpharogroup.auth.models.AuthenticationErrors;
import de.alpharogroup.auth.models.AuthenticationResult;
import de.alpharogroup.auth.token.AuthToken;
import de.alpharogroup.user.domain.User;
import de.alpharogroup.user.rest.api.BaseAuthenticationsResource;
import de.alpharogroup.user.service.api.BaseAuthenticationService;
import lombok.Getter;
import lombok.Setter;


/**
 * The class {@link BaseAuthenticationsRestResource} provides an implementation of the inteface {@link BaseAuthenticationsResource}.
 */
public class BaseAuthenticationsRestResource implements BaseAuthenticationsResource {

	/** The authentication service. */
	@Getter
	@Setter
	private BaseAuthenticationService baseAuthenticationService;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Response authenticate(final Credentials credentials) {
        final String username = credentials.getUsername();
        final String password = credentials.getPassword();
        return authenticate(username, password);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Response authenticate(final String username, final String password) {
		final AuthenticationResult<User, AuthenticationErrors> result = baseAuthenticationService.authenticate(username, password);
        if (CollectionUtils.isNotEmpty(result.getValidationErrors())) {
            return Response.status(Response.Status.UNAUTHORIZED)
            		.header("Access-Control-Allow-Origin", "*")// allow cors...
            		.build();
		}
        final String authenticationToken = baseAuthenticationService.newAuthenticationToken(username);
        final AuthToken authToken = AuthToken.builder().value(authenticationToken).build();
        // Set the auth token in the response
		return Response.ok(authToken.getValue())
				.header("Access-Control-Allow-Origin", "*")// allow cors...
				.build();
	}

}
