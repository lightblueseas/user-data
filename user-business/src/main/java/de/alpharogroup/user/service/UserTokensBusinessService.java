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

import de.alpharogroup.collections.ListExtensions;
import de.alpharogroup.db.service.jpa.AbstractBusinessService;
import de.alpharogroup.random.RandomExtensions;
import de.alpharogroup.user.entities.UserTokens;
import de.alpharogroup.user.repositories.UserTokensDao;
import de.alpharogroup.user.service.api.UserTokensService;

@Transactional
@Service("userTokensService")
public class UserTokensBusinessService extends AbstractBusinessService<UserTokens, Integer, UserTokensDao> implements UserTokensService {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	@Autowired
	public void setUserTokensDao(UserTokensDao userTokensDao) {
		setDao(userTokensDao);
	}

	@Override
	public UserTokens find(String username) {
		return ListExtensions.getFirst(findAll(username));
	}

	@Override
	public List<UserTokens> findAll(String username) {
		List<UserTokens> userTokens = null;
		UserTokens from = Torpedo.from(UserTokens.class);
		Torpedo.where(from.getUsername()).eq(username);
		org.torpedoquery.jpa.Query<UserTokens> select = Torpedo.select(from);
		userTokens = select.list(getDao().getEntityManager());
		return userTokens;
	}

	@Override
	public String getAutheticationToken(String username) {
		UserTokens token = find(username);
		if (token != null) {
			return token.getToken();
		}
		return null;
	}

	@Override
	public boolean isValid(String token) {
		List<UserTokens> userTokens = null;
		UserTokens from = Torpedo.from(UserTokens.class);
		Torpedo.where(from.getToken()).eq(token);
		org.torpedoquery.jpa.Query<UserTokens> select = Torpedo.select(from);
		userTokens = select.list(getDao().getEntityManager());
		boolean valid = CollectionUtils.isNotEmpty(userTokens);
		return valid;
	}
	

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String newAuthenticationToken(String username) {
		UserTokens userTokens = find(username);
		if (userTokens == null) {
			userTokens = merge(newUserTokens(username));
		}
		// check if expired
		Date now = Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant());
		if (userTokens.getExpiry().before(now)) {
			// expires in one year
			Date expiry = Date.from(LocalDateTime.now().plusMonths(12).atZone(ZoneId.systemDefault()).toInstant());
			// create a token
			String token = RandomExtensions.randomToken();
			userTokens.setExpiry(expiry);
			userTokens.setToken(token);
			userTokens = merge(userTokens);
		}
		return userTokens.getToken();
	}

	/**
	 * New user tokens.
	 *
	 * @param username the username
	 * @return the user tokens
	 */
	private UserTokens newUserTokens(String username) {
		UserTokens userTokens;
		// expires in one year
		Date expiry = Date.from(LocalDateTime.now().plusMonths(12).atZone(ZoneId.systemDefault()).toInstant());
		// create a token
		String token = RandomExtensions.randomToken();
		userTokens = UserTokens.builder().expiry(expiry).username(username).token(token).build();
		return userTokens;
	}

}