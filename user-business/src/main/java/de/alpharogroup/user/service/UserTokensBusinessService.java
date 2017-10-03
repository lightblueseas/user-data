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
package de.alpharogroup.user.service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.torpedoquery.jpa.Torpedo;

import de.alpharogroup.collections.list.ListExtensions;
import de.alpharogroup.db.service.jpa.AbstractBusinessService;
import de.alpharogroup.random.RandomExtensions;
import de.alpharogroup.user.entities.UserTokens;
import de.alpharogroup.user.repositories.UserTokensDao;
import de.alpharogroup.user.service.api.UserTokensService;

@Transactional
@Service("userTokensService")
public class UserTokensBusinessService
	extends
		AbstractBusinessService<UserTokens, Integer, UserTokensDao>
	implements
		UserTokensService
{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	@Override
	public UserTokens find(String username)
	{
		return ListExtensions.getFirst(findAll(username));
	}

	@Override
	public List<UserTokens> findAll(String username)
	{
		List<UserTokens> userTokens = null;
		final UserTokens from = Torpedo.from(UserTokens.class);
		Torpedo.where(from.getUsername()).eq(username);
		final org.torpedoquery.jpa.Query<UserTokens> select = Torpedo.select(from);
		userTokens = select.list(getDao().getEntityManager());
		return userTokens;
	}

	@Override
	public String getAutheticationToken(String username)
	{
		final UserTokens token = find(username);
		if (token != null)
		{
			return token.getToken();
		}
		return null;
	}

	@Override
	public boolean isValid(String token)
	{
		List<UserTokens> userTokens = null;
		final UserTokens from = Torpedo.from(UserTokens.class);
		Torpedo.where(from.getToken()).eq(token);
		final org.torpedoquery.jpa.Query<UserTokens> select = Torpedo.select(from);
		userTokens = select.list(getDao().getEntityManager());
		final boolean valid = CollectionUtils.isNotEmpty(userTokens);
		return valid;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String newAuthenticationToken(String username)
	{
		UserTokens userTokens = find(username);
		if (userTokens == null)
		{
			userTokens = merge(newUserTokens(username));
		}
		// check if expired
		final Date now = Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant());
		if (userTokens.getExpiry().before(now))
		{
			// expires in one year
			final Date expiry = Date.from(
				LocalDateTime.now().plusMonths(12).atZone(ZoneId.systemDefault()).toInstant());
			// create a token
			final String token = RandomExtensions.randomToken();
			userTokens.setExpiry(expiry);
			userTokens.setToken(token);
			userTokens = merge(userTokens);
		}
		return userTokens.getToken();
	}


	/**
	 * New user tokens.
	 *
	 * @param username
	 *            the username
	 * @return the user tokens
	 */
	private UserTokens newUserTokens(String username)
	{
		UserTokens userTokens;
		// expires in one year
		final Date expiry = Date
			.from(LocalDateTime.now().plusMonths(12).atZone(ZoneId.systemDefault()).toInstant());
		// create a token
		final String token = RandomExtensions.randomToken();
		userTokens = UserTokens.builder().expiry(expiry).username(username).token(token).build();
		return userTokens;
	}

	@Autowired
	public void setUserTokensDao(UserTokensDao userTokensDao)
	{
		setDao(userTokensDao);
	}

}