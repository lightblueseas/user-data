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

import de.alpharogroup.service.domain.AbstractDomainService;
import de.alpharogroup.user.domain.ResetPassword;
import de.alpharogroup.user.domain.User;
import de.alpharogroup.user.entities.ResetPasswords;
import de.alpharogroup.user.entities.Users;
import de.alpharogroup.user.mapper.ResetPasswordsMapper;
import de.alpharogroup.user.repositories.ResetPasswordsDao;
import de.alpharogroup.user.service.api.ResetPasswordService;
import de.alpharogroup.user.service.api.ResetPasswordsService;
import lombok.Getter;
import lombok.Setter;

/**
 * The class {@link ResetPasswordDomainService}.
 */
@Transactional
@Service("resetPasswordDomainService")
public class ResetPasswordDomainService extends
		AbstractDomainService<Integer, ResetPassword, ResetPasswords, ResetPasswordsDao, ResetPasswordsMapper>
		implements ResetPasswordService {

	/** The {@link ResetPasswordsService}. */
	@Autowired
	@Getter
	@Setter
	private ResetPasswordsService resetPasswordsService;

	/**
	 * Sets the specific {@link ResetPasswordsDao}.
	 *
	 * @param resetPasswordsDao
	 *            the new {@link ResetPasswordsDao}.
	 */
	@Autowired
	public void setResetPasswordsDao(final ResetPasswordsDao resetPasswordsDao) {
		setDao(resetPasswordsDao);
	}

	/**
	 * Sets the specific {@link ResetPasswordsMapper}.
	 *
	 * @param mapper
	 *            the new {@link ResetPasswordsMapper}.
	 */
	@Autowired
	public void setResetPasswordsMapper(final ResetPasswordsMapper mapper) {
		setMapper(mapper);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ResetPassword findResetPassword(final User user, final String generatedPassword) {
		final Users users = getMapper().map(user, Users.class);
		final ResetPasswords resetPasswords = resetPasswordsService.findResetPassword(users, generatedPassword);
		final ResetPassword resetPassword = getMapper().toDomainObject(resetPasswords);
		return resetPassword;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ResetPassword findResetPassword(final User user) {
		final Users users = getMapper().map(user, Users.class);
		final ResetPasswords resetPasswords = resetPasswordsService.findResetPassword(users);
		final ResetPassword resetPassword = getMapper().toDomainObject(resetPasswords);
		return resetPassword;
	}
}
