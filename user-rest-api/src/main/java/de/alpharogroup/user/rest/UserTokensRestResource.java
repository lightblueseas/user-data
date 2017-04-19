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

import java.util.List;

import de.alpharogroup.service.rs.AbstractRestfulResource;
import de.alpharogroup.user.domain.UserToken;
import de.alpharogroup.user.rest.api.UserTokensResource;
import de.alpharogroup.user.service.api.UserTokenService;

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
