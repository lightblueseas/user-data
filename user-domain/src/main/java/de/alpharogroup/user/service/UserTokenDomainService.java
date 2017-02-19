package de.alpharogroup.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import de.alpharogroup.service.domain.AbstractDomainService;
import de.alpharogroup.user.domain.UserToken;
import de.alpharogroup.user.entities.UserTokens;
import de.alpharogroup.user.mapper.UserTokensMapper;
import de.alpharogroup.user.repositories.UserTokensDao;
import de.alpharogroup.user.service.api.UserTokenService;
import de.alpharogroup.user.service.api.UserTokensService;
import lombok.Getter;
import lombok.Setter;

/**
 * The class {@link UserTokenDomainService}.
 */
@Transactional
@Service("userTokenDomainService")
public class UserTokenDomainService extends AbstractDomainService<Integer, UserToken, UserTokens, UserTokensDao, UserTokensMapper>
		implements UserTokenService {

	/** The {@link UserTokensService}. */
	@Autowired
	@Getter
	@Setter
	private UserTokensService userTokensService;

	/**
	 * Sets the specific {@link UserTokensDao}.
	 *
	 * @param usersDao
	 *            the new {@link UserTokensDao}.
	 */
	@Autowired
	public void setUserTokensDao(final UserTokensDao usersDao) {
		setDao(usersDao);
	}

	/**
	 * Sets the specific {@link UserTokensMapper}.
	 *
	 * @param mapper
	 *            the new {@link UserTokensMapper}.
	 */
	@Autowired
	public void setUserTokensMapper(final UserTokensMapper mapper) {
		setMapper(mapper);
	}

	@Override
	public String getAutheticationToken(final String username)
	{
		return userTokensService.getAutheticationToken(username);
	}

	@Override
	public boolean isValid(final String token)
	{
		return userTokensService.isValid(token);
	}

	@Override
	public UserToken find(final String username)
	{
		return getMapper().toDomainObject(userTokensService.find(username));
	}

	@Override
	public List<UserToken> findAll(final String username)
	{
		return getMapper().toDomainObjects(userTokensService.findAll(username));
	}

}
