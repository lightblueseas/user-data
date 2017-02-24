package de.alpharogroup.user.mapper;

import org.springframework.stereotype.Component;

import de.alpharogroup.db.entitymapper.AbstractEntityDOMapper;
import de.alpharogroup.user.domain.ResetPassword;
import de.alpharogroup.user.entities.ResetPasswords;

/**
 * The class {@link ResetPasswordsMapper}.
 */
@Component
public class ResetPasswordsMapper extends AbstractEntityDOMapper<ResetPasswords, ResetPassword> {

}
