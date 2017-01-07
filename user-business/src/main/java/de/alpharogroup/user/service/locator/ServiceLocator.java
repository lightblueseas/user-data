package de.alpharogroup.user.service.locator;

import de.alpharogroup.user.management.service.api.PermissionsService;
import de.alpharogroup.user.management.service.api.RelationPermissionsService;
import de.alpharogroup.user.management.service.api.ResetPasswordsService;
import de.alpharogroup.user.management.service.api.RolesService;
import de.alpharogroup.user.management.service.api.UsersService;

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
	UsersService getUsersService();

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
	void setUsersService(UsersService usersService);

}
