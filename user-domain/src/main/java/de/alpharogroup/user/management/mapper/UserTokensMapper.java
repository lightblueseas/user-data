package de.alpharogroup.user.management.mapper;

import org.springframework.stereotype.Component;

import de.alpharogroup.db.entitymapper.AbstractEntityDOMapper;
import de.alpharogroup.user.management.domain.UserToken;
import de.alpharogroup.user.management.entities.UserTokens;

/**
 * The class {@link UserTokensMapper}.
 */
@Component
public class UserTokensMapper extends AbstractEntityDOMapper<UserTokens, UserToken> {

}
