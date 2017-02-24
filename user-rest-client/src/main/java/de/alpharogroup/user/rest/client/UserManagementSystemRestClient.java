package de.alpharogroup.user.rest.client;

import de.alpharogroup.cxf.rest.client.AbstractRestClient;
import de.alpharogroup.user.rest.api.BaseAuthenticationsResource;
import de.alpharogroup.user.rest.api.PermissionsResource;
import de.alpharogroup.user.rest.api.RelationPermissionsResource;
import de.alpharogroup.user.rest.api.ResetPasswordsResource;
import de.alpharogroup.user.rest.api.RolesResource;
import de.alpharogroup.user.rest.api.UserTokensResource;
import de.alpharogroup.user.rest.api.BaseUsersResource;
import lombok.Getter;

/**
 * The class {@link UserManagementSystemRestClient} is a rest client for the
 * dating-system that are persists in the database.
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
