package de.alpharogroup.user.rest;

import java.util.List;
import java.util.Set;

import de.alpharogroup.collections.pairs.KeyValuePair;
import de.alpharogroup.collections.pairs.Triple;
import de.alpharogroup.service.rs.AbstractRestfulResource;
import de.alpharogroup.user.domain.Permission;
import de.alpharogroup.user.domain.Role;
import de.alpharogroup.user.service.api.RoleService;
import de.alpharogroup.user.rest.api.RolesResource;

public class RolesRestResource
	extends
 AbstractRestfulResource<Integer, Role, RoleService>
	implements
		RolesResource
{

	@Override
	public List<Permission> findAllPermissions(final Role role) {
		return getDomainService().findAllPermissions(role);
	}

	@Override
	public Role findRole(final String rolename) {
		return getDomainService().findRole(rolename);
	}

	@Override
	public List<Role> findRoles(final String rolename) {
		return getDomainService().findRoles(rolename);
	}

	@Override
	public boolean exists(final String rolename) {
		return getDomainService().exists(rolename);
	}

	@Override
	public Role createAndSaveRole(final KeyValuePair<String, String> newRole) {
		return getDomainService().createAndSaveRole(newRole.getKey(), newRole.getValue());
	}

	@Override
	public Role createAndSaveRole(final Triple<String, String, Set<Permission>> roleToCreate) {
		return getDomainService().createAndSaveRole(
				roleToCreate.getLeft(), roleToCreate.getMiddle(), roleToCreate.getRight());
	}

}
