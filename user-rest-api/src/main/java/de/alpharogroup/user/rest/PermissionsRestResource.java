package de.alpharogroup.user.rest;


import java.util.List;

import de.alpharogroup.service.rs.AbstractRestfulResource;
import de.alpharogroup.user.domain.Permission;
import de.alpharogroup.user.rest.api.PermissionsResource;
import de.alpharogroup.user.service.api.PermissionService;

/**
 * The class {@link PermissionsRestResource} .
 */
public class PermissionsRestResource
	extends
		AbstractRestfulResource<Integer, Permission, PermissionService>
	implements
		PermissionsResource
{

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Permission createAndSavePermissions(final String name, final String description) {
		return getDomainService().createAndSavePermissions(name, description);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Permission createAndSavePermissions(final String name, final String description, final String shortcut) {
		return getDomainService().createAndSavePermissions(name, description, shortcut);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Permission findByShortcut(final String shortcut) {
		return getDomainService().findByShortcut(shortcut);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Permission findByName(final String name) {
		return getDomainService().findByName(name);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Permission> find(final String description, final String name, final String shortcut) {
		return getDomainService().find(description, name, shortcut);
	}

}
