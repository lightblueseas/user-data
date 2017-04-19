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
package de.alpharogroup.user.rest.client;

import de.alpharogroup.cxf.rest.client.AbstractRestClient;
import de.alpharogroup.user.rest.api.BaseAuthenticationsResource;
import de.alpharogroup.user.rest.api.BaseUsersResource;
import de.alpharogroup.user.rest.api.PermissionsResource;
import de.alpharogroup.user.rest.api.RelationPermissionsResource;
import de.alpharogroup.user.rest.api.ResetPasswordsResource;
import de.alpharogroup.user.rest.api.RolesResource;
import de.alpharogroup.user.rest.api.UserTokensResource;
import lombok.Getter;

/**
 * The class {@link UserManagementSystemRestClient} is a rest client for the dating-system that are
 * persists in the database.
 */
public class UserManagementSystemRestClient extends AbstractRestClient
{

	/**
	 * The {@link BaseAuthenticationsResource}.
	 */
	@Getter
	private final BaseAuthenticationsResource authenticationsResource;

	/**
	 * The {@link PermissionsResource}.
	 */
	@Getter
	private final PermissionsResource permissionsResource;

	/**
	 * The {@link RelationPermissionsResource}.
	 */
	@Getter
	private final RelationPermissionsResource relationPermissionsResource;

	/**
	 * The {@link ResetPasswordsResource}.
	 */
	@Getter
	private final ResetPasswordsResource resetPasswordsResource;

	/**
	 * The {@link RolesResource}.
	 */
	@Getter
	private final RolesResource rolesResource;

	/**
	 * The {@link BaseUsersResource}.
	 */
	@Getter
	private final BaseUsersResource usersResource;


	/**
	 * The {@link BaseUsersResource}.
	 */
	@Getter
	private final UserTokensResource userTokensResource;

	/**
	 * Instantiates a new {@link UserManagementSystemRestClient} with the default base url.
	 */
	public UserManagementSystemRestClient()
	{
		this(DEFAULT_BASE_HTTP_URL);
	}

	/**
	 * Instantiates a new {@link UserManagementSystemRestClient}.
	 *
	 * @param baseUrl
	 *            the base url
	 */
	public UserManagementSystemRestClient(final String baseUrl)
	{
		super(baseUrl);
		authenticationsResource = newResource(BaseAuthenticationsResource.class);
		permissionsResource = newResource(PermissionsResource.class);
		relationPermissionsResource = newResource(RelationPermissionsResource.class);
		resetPasswordsResource = newResource(ResetPasswordsResource.class);
		rolesResource = newResource(RolesResource.class);
		usersResource = newResource(BaseUsersResource.class);
		userTokensResource = newResource(UserTokensResource.class);
	}

}
