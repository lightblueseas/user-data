package de.alpharogroup.user.rest;

import javax.ws.rs.core.Response;

import org.apache.commons.collections4.CollectionUtils;

import de.alpharogroup.auth.Credentials;
import de.alpharogroup.auth.models.AuthenticationErrors;
import de.alpharogroup.auth.models.AuthenticationResult;
import de.alpharogroup.auth.token.AuthToken;
import de.alpharogroup.user.domain.User;
import de.alpharogroup.user.rest.api.AuthenticationsResource;
import de.alpharogroup.user.service.api.AuthenticationService;
import lombok.Getter;
import lombok.Setter;


/**
 * The class {@link AuthenticationsRestResource} provides an implementation of the inteface {@link AuthenticationsResource}.
 */
public class AuthenticationsRestResource implements AuthenticationsResource {

	/** The authentication service. */
	@Getter
	@Setter
	private AuthenticationService authenticationService;

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
		final AuthenticationResult<User, AuthenticationErrors> result = authenticationService.authenticate(username, password);
        if (CollectionUtils.isNotEmpty(result.getValidationErrors())) {
            return Response.status(Response.Status.UNAUTHORIZED)
            		.header("Access-Control-Allow-Origin", "*")// allow cors...
            		.build();
		}
        final String authenticationToken = authenticationService.newAuthenticationToken(username);
        final AuthToken authToken = AuthToken.builder().value(authenticationToken).build();
        // Set the auth token in the response
		return Response.ok(authToken.getValue())
				.header("Access-Control-Allow-Origin", "*")// allow cors...
				.build();
	}

}
