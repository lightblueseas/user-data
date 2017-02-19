package de.alpharogroup.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import de.alpharogroup.auth.models.AuthenticationErrors;
import de.alpharogroup.auth.models.AuthenticationResult;
import de.alpharogroup.user.domain.User;
import de.alpharogroup.user.entities.Users;
import de.alpharogroup.user.mapper.UsersMapper;
import de.alpharogroup.user.service.api.BaseAuthenticationService;
import de.alpharogroup.user.service.api.BaseAuthenticationsService;
import lombok.Getter;
import lombok.Setter;

@Transactional
@Service("baseAuthenticationDomainService")
public class BaseAuthenticationDomainService implements BaseAuthenticationService {


	/** The {@link BaseAuthenticationsService}. */
	@Autowired
	@Getter
	@Setter
	private BaseAuthenticationsService baseAuthenticationsService;

	private final UsersMapper mapper = new UsersMapper();

	@Override
	public AuthenticationResult<User, AuthenticationErrors> authenticate(final String emailOrUsername, final String password) {
		final AuthenticationResult<Users, AuthenticationErrors> originalAuthenticationResult = baseAuthenticationsService.authenticate(emailOrUsername, password);
		final AuthenticationResult<User, AuthenticationErrors> authenticationResult =
				AuthenticationResult.<User, AuthenticationErrors>builder()
				.validationErrors(originalAuthenticationResult.getValidationErrors())
				.user(mapper.toDomainObject(originalAuthenticationResult.getUser()))
				.build();
		return authenticationResult;
	}

	@Override
	public String newAuthenticationToken(final String username) {
		return baseAuthenticationsService.newAuthenticationToken(username);
	}

}
