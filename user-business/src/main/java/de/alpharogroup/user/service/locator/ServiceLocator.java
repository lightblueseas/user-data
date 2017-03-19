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
package de.alpharogroup.user.service.locator;

import de.alpharogroup.user.service.api.PermissionsService;
import de.alpharogroup.user.service.api.RelationPermissionsService;
import de.alpharogroup.user.service.api.ResetPasswordsService;
import de.alpharogroup.user.service.api.RolesService;
import de.alpharogroup.user.service.api.BaseUsersService;

public interface ServiceLocator {


	/**
	 * Gets the permission service.
	 * 
	 * @return the permission service
	 */
	PermissionsService getPermissionsService();

	/**
	 * Gets the RelationPermissionsService.
	 * 
	 * @return the RelationPermissionsService.
	 */
	RelationPermissionsService getRelationPermissionsService();

	/**
	 * Gets the reset passwords service.
	 * 
	 * @return the reset passwords service
	 */
	ResetPasswordsService getResetPasswordsService();

	/**
	 * Gets the roles service.
	 * 
	 * @return the roles service
	 */
	RolesService getRolesService();

	/**
	 * Gets the users service.
	 * 
	 * @return the users service
	 */
	BaseUsersService getUsersService();

	/**
	 * Sets the permission business service.
	 * 
	 * @param permissionService
	 *            the new permission business service
	 */
	void setPermissionsService(PermissionsService permissionService);

	/**
	 * Sets the RelationPermissionsService.
	 *
	 * @param relationPermissionsService
	 *            the new RelationPermissionsService
	 */
	void setRelationPermissionsService(
			RelationPermissionsService relationPermissionsService);

	/**
	 * Sets the reset passwords business service.
	 * 
	 * @param resetPasswordsService
	 *            the new reset passwords business service
	 */
	void setResetPasswordsService(ResetPasswordsService resetPasswordsService);

	/**
	 * Sets the roles service.
	 * 
	 * @param rolesService
	 *            the new roles service
	 */
	void setRolesService(RolesService rolesService);

	/**
	 * Sets the users business service.
	 * 
	 * @param usersService
	 *            the new users business service
	 */
	void setUsersService(BaseUsersService usersService);

}
