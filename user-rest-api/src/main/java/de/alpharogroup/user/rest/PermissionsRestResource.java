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
