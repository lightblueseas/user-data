package de.alpharogroup.user.rest;

import de.alpharogroup.collections.pairs.KeyValuePair;
import de.alpharogroup.service.rs.AbstractRestfulResource;
import de.alpharogroup.user.domain.ResetPassword;
import de.alpharogroup.user.domain.User;
import de.alpharogroup.user.service.api.ResetPasswordService;
import de.alpharogroup.user.rest.api.ResetPasswordsResource;

public class ResetPasswordsRestResource
	extends
		AbstractRestfulResource<Integer, ResetPassword, ResetPasswordService>
	implements
		ResetPasswordsResource
{

	@Override
	public ResetPassword findResetPassword(final KeyValuePair<User, String> userAndGenPw) {
		return getDomainService().findResetPassword(userAndGenPw.getKey(), userAndGenPw.getValue());
	}

	@Override
	public ResetPassword findResetPassword(final User user) {
		return getDomainService().findResetPassword(user);
	}

}
