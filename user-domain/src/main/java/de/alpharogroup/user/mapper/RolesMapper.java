package de.alpharogroup.user.mapper;

import org.springframework.stereotype.Component;

import de.alpharogroup.db.entitymapper.AbstractEntityDOMapper;
import de.alpharogroup.user.domain.Role;
import de.alpharogroup.user.entities.Roles;

/**
 * The class {@link RolesMapper}.
 */
@Component
public class RolesMapper extends AbstractEntityDOMapper<Roles, Role> {

}
