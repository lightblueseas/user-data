package de.alpharogroup.user.rest;

import java.util.List;

import de.alpharogroup.service.rs.AbstractRestfulResource;
import de.alpharogroup.user.domain.UserToken;
import de.alpharogroup.user.service.api.UserTokenService;
import de.alpharogroup.user.rest.api.UserTokensResource;

/**
 * The class {@link UserTokensRestResource}.
 */
public class UserTokensRestResource
	extends
 AbstractRestfulResource<Integer, UserToken, UserTokenService>
	implements
	UserTokensResource
{

	/**
	 * {@inheritDoc}
	 */
	@Override
	public UserToken find(final String username)
	{
		return getDomainService().find(username);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<UserToken> findAll(final String username)
	{
		return getDomainService().findAll(username);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getAutheticationToken(final String username)
	{
		return getDomainService().getAutheticationToken(username);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isValid(final String token)
	{
		return getDomainService().isValid(token);
	}


}
