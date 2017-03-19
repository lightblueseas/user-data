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
package de.alpharogroup.user.service.api;

import java.util.List;

import de.alpharogroup.service.domain.DomainService;
import de.alpharogroup.user.domain.Permission;

/**
 * The interface {@link PermissionService}.
 */
public interface PermissionService extends DomainService<Integer, Permission> {

	/**
	 * Factory method to create and save a new {@link Permission} object.
	 *
	 * @param name the name
	 * @param description the description
	 * @return the new {@link Permission} object.
	 */
	Permission createAndSavePermissions(String name, String description);

	/**
	 * Factory method to create and save a new {@link Permission} object.
	 *
	 * @param name the name
	 * @param description the description
	 * @param shortcut the shortcut
	 * @return the new {@link Permission} object.
	 */
	Permission createAndSavePermissions(String name, String description,
			String shortcut);
	
	/**
	 * Find the {@link Permission} object by the given shortcut.
	 *
	 * @param shortcut the shortcut
	 * @return the found {@link Permission} object or null if not.
	 */
	Permission findByShortcut(String shortcut);
	
	/**
	 * Find the {@link Permission} object by the given name.
	 *
	 * @param name the name
	 * @return the found {@link Permission} object or null if not.
	 */
	Permission findByName(String name);

	/**
	 * Find all {@link Permission} objects by the given parameters.
	 *
	 * @param description the description
	 * @param permissionName the permission name
	 * @param shortcut the shortcut
	 * @return the list of the found {@link Permission} objects.
	 */
	List<Permission> find(String description, String permissionName,
			String shortcut);
}
