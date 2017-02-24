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
