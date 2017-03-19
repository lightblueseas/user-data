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
package de.alpharogroup.user.rest.api;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import de.alpharogroup.service.rs.RestfulResource;
import de.alpharogroup.user.domain.Permission;

/**
 * The interface {@link PermissionsResource} provides methods for resolving permissions objects.
 */
@Path("/permission/")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public interface PermissionsResource extends RestfulResource<Integer, Permission>
{

	/**
	 * Factory method to create and save a new {@link Permission} object.
	 *
	 * @param name the name
	 * @param description the description
	 * @return the new {@link Permission} object.
	 */
	@GET
	@Path("/new/perm/{name}/{description}/")
	Permission createAndSavePermissions(@PathParam("name") String name, @PathParam("description")String description);

	/**
	 * Factory method to create and save a new {@link Permission} object.
	 *
	 * @param name the name
	 * @param description the description
	 * @param shortcut the shortcut
	 * @return the new {@link Permission} object.
	 */
	@GET
	@Path("/new/perm/{name}/{description}/{shortcut}/")
	Permission createAndSavePermissions(@PathParam("name")String name, @PathParam("description")String description,
			@PathParam("shortcut")String shortcut);

	/**
	 * Find the {@link Permission} object by the given shortcut.
	 *
	 * @param shortcut the shortcut
	 * @return the found {@link Permission} object or null if not.
	 */
	@GET
	@Path("/find/by/shortcut/{shortcut}/")
	Permission findByShortcut(@PathParam("shortcut")String shortcut);

	/**
	 * Find the {@link Permission} object by the given name.
	 *
	 * @param name the name
	 * @return the found {@link Permission} object or null if not.
	 */
	@GET
	@Path("/find/by/name/{name}/")
	Permission findByName(@PathParam("name")String name);

	/**
	 * Find all {@link Permission} objects by the given parameters.
	 *
	 * @param description the description
	 * @param name the permission name
	 * @param shortcut the shortcut
	 * @return the list of the found {@link Permission} objects.
	 */
	@GET
	@Path("/find/by/description/{description}/{name}/{shortcut}/")
	List<Permission> find(@PathParam("description")String description, @PathParam("name")String name,
			@PathParam("shortcut")String shortcut);
}
