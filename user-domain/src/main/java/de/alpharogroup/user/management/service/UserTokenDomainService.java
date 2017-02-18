package de.alpharogroup.user.management.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import de.alpharogroup.service.domain.AbstractDomainService;
import de.alpharogroup.user.management.daos.UserTokensDao;
import de.alpharogroup.user.management.domain.UserToken;
import de.alpharogroup.user.management.entities.UserTokens;
import de.alpharogroup.user.management.mapper.UserTokensMapper;
import de.alpharogroup.user.management.service.api.UserTokenService;
import de.alpharogroup.user.service.api.UserTokensService;
import lombok.Getter;
import lombok.Setter;

/**
 * The class {@link UserTokenDomainService}.
 */
@Transactional
@Service("userDomainService")
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

}
