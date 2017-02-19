package de.alpharogroup.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import de.alpharogroup.user.service.api.BaseAuthenticationsService;
import de.alpharogroup.user.service.api.UserTokensService;
import de.alpharogroup.user.service.api.BaseUsersService;
import lombok.Getter;
import lombok.Setter;

/**
 * The class {@link BaseAuthenticationsBusinessService} provides authentication methods.
 */
@Transactional
@Service("baseAuthenticationsService")
public class BaseAuthenticationsBusinessService implements BaseAuthenticationsService {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The user tokens business service. */
	@Autowired
	@Getter
	@Setter
	private UserTokensService userTokensService;

	/** The user tokens business service. */
	@Autowired
	@Getter
	@Setter
	private BaseUsersService usersService;

	@Override
	public String newAuthenticationToken(final String username) {
		return userTokensService.newAuthenticationToken(username);
	}

}
