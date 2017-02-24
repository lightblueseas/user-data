package de.alpharogroup.user.mapper;

import org.springframework.stereotype.Component;

import de.alpharogroup.db.entitymapper.AbstractEntityDOMapper;
import de.alpharogroup.user.domain.Permission;
import de.alpharogroup.user.entities.Permissions;

/**
 * The class {@link PermissionsMapper}.
 */
@Component
public class PermissionsMapper extends AbstractEntityDOMapper<Permissions, Permission> {
}
