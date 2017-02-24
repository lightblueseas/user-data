package de.alpharogroup.user.mapper;

import org.springframework.stereotype.Component;

import de.alpharogroup.db.entitymapper.AbstractEntityDOMapper;
import de.alpharogroup.user.domain.UserToken;
import de.alpharogroup.user.entities.UserTokens;

/**
 * The class {@link UserTokensMapper}.
 */
@Component
public class UserTokensMapper extends AbstractEntityDOMapper<UserTokens, UserToken> {

}
