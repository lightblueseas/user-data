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
