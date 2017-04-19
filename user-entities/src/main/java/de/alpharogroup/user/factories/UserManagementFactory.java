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
package de.alpharogroup.user.factories;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import de.alpharogroup.user.entities.Permissions;
import de.alpharogroup.user.entities.RelationPermissions;
import de.alpharogroup.user.entities.ResetPasswords;
import de.alpharogroup.user.entities.Roles;
import de.alpharogroup.user.entities.Users;

/**
 * A factory for creating Domain objects for the user management.
 */
public class UserManagementFactory implements Serializable
{

	/** The Constant instance. */
	private static final UserManagementFactory instance = new UserManagementFactory();

	/**
	 * The serialVersionUID.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Gets the single instance of UserManagementFactory.
	 *
	 * @return single instance of UserManagementFactory
	 */
	public static UserManagementFactory getInstance()
	{
		return instance;
	}

	/**
	 * Instantiates a new UserManagementFactory object.
	 */
	private UserManagementFactory()
	{
	}

	/**
	 * Factory method for create an Permissions object.
	 *
	 * @param id
	 *            the id
	 * @param permission
	 *            the permission
	 * @param description
	 *            the description
	 * @param shortcut
	 *            the shortcut
	 * @return Permissions A Permissions object
	 */
	public Permissions newPermissions(final Integer id, final String permission,
		final String description, final String shortcut)
	{
		final Permissions permissions = new Permissions();

		permissions.setDescription(description);
		permissions.setId(id);
		permissions.setPermissionName(permission);
		permissions.setShortcut(shortcut);

		return permissions;
	}

	/**
	 * Gets the permissions.
	 *
	 * @param permission
	 *            the permission
	 * @param description
	 *            the description
	 * @return the permissions
	 */
	public Permissions newPermissions(final String permission, final String description)
	{
		return newPermissions(null, permission, description, null);
	}

	/**
	 * Gets the permissions.
	 *
	 * @param permission
	 *            the permission
	 * @param description
	 *            the description
	 * @param shortcut
	 *            the shortcut
	 * @return the permissions
	 */
	public Permissions newPermissions(final String permission, final String description,
		final String shortcut)
	{
		return newPermissions(null, permission, description, shortcut);
	}

	/**
	 * Gets the relation permissions.
	 *
	 * @param id
	 *            the id
	 * @param provider
	 *            the provider
	 * @param subscriber
	 *            the subscriber
	 * @param permissions
	 *            the permissions
	 * @return the relation permissions
	 */
	public RelationPermissions newRelationPermissions(final Integer id, final Users provider,
		final Users subscriber, final Set<Permissions> permissions)
	{
		final RelationPermissions relationPermissions = new RelationPermissions();
		relationPermissions.setId(id);
		relationPermissions.setProvider(provider);
		relationPermissions.setSubscriber(subscriber);
		relationPermissions.setPermissions(permissions);
		return relationPermissions;
	}

	/**
	 * Gets the relation permissions.
	 *
	 * @param provider
	 *            the provider
	 * @param subscriber
	 *            the subscriber
	 * @return the relation permissions
	 */
	public RelationPermissions newRelationPermissions(final Users provider, final Users subscriber)
	{
		return newRelationPermissions(provider, subscriber, new HashSet<Permissions>());
	}

	/**
	 * Gets the relation permissions.
	 *
	 * @param provider
	 *            the provider
	 * @param subscriber
	 *            the subscriber
	 * @param permissions
	 *            the permissions
	 * @return the relation permissions
	 */
	public RelationPermissions newRelationPermissions(final Users provider, final Users subscriber,
		final Set<Permissions> permissions)
	{
		return newRelationPermissions(null, provider, subscriber, permissions);
	}

	/**
	 * Data pool factory for ResetPasswords.
	 *
	 * @param expiryDate
	 *            the expiry date
	 * @param generatedPassword
	 *            the generated password
	 * @param starttime
	 *            the starttime
	 * @param user
	 *            the user
	 * @return the reset passwords
	 */
	public ResetPasswords newResetPasswords(final Date expiryDate, final String generatedPassword,
		final Date starttime, final Users user)
	{
		return newResetPasswords(null, expiryDate, generatedPassword, starttime, user);
	}

	/**
	 * Data pool factory for ResetPasswords.
	 *
	 * @param id
	 *            the id
	 * @param expiryDate
	 *            the expiry date
	 * @param generatedPassword
	 *            the generated password
	 * @param starttime
	 *            the starttime
	 * @param user
	 *            the user
	 * @return the reset passwords
	 */
	public ResetPasswords newResetPasswords(final Integer id, final Date expiryDate,
		final String generatedPassword, final Date starttime, final Users user)
	{
		final ResetPasswords resetPasswords = new ResetPasswords();
		resetPasswords.setExpiryDate(expiryDate);
		resetPasswords.setGeneratedPassword(generatedPassword);
		resetPasswords.setId(id);
		resetPasswords.setStarttime(starttime);
		resetPasswords.setUser(user);

		return resetPasswords;
	}

	/**
	 * Factory method for create an Roles object.
	 *
	 * @param id
	 *            the id
	 * @param rolename
	 *            the rolename
	 * @param description
	 *            the description
	 * @param permissions
	 *            the permissions
	 * @return Roles A Roles object
	 */
	public Roles newRoles(final Integer id, final String rolename, final String description,
		final Set<Permissions> permissions)
	{
		final Roles roles = new Roles();

		roles.setDescription(description);
		roles.setId(id);
		roles.setRolename(rolename);
		if (permissions != null)
		{
			roles.setPermissions(permissions);
		}
		return roles;
	}

	/**
	 * Gets the roles.
	 *
	 * @param rolename
	 *            the rolename
	 * @param description
	 *            the description
	 * @return the roles
	 */
	public Roles newRoles(final String rolename, final String description)
	{
		return newRoles(rolename, description, null);
	}

	/**
	 * Gets the roles.
	 *
	 * @param rolename
	 *            the rolename
	 * @param description
	 *            the description
	 * @param permissions
	 *            the permissions
	 * @return the roles
	 */
	public Roles newRoles(final String rolename, final String description,
		final Set<Permissions> permissions)
	{
		return newRoles(null, rolename, description, permissions);
	}

	/**
	 * Gets the users.
	 *
	 * @param active
	 *            the active
	 * @param pw
	 *            the pw
	 * @param salt
	 *            the salt
	 * @param username
	 *            the username
	 * @param locked
	 *            the locked
	 * @param roles
	 *            the roles
	 * @return the users
	 */
	public Users newUsers(final Boolean active, final String pw, final String salt,
		final String username, final Boolean locked, final Set<Roles> roles)
	{
		return newUsers(null, active, pw, salt, username, locked, roles);
	}

	/**
	 * Factory method for create an Users object.
	 *
	 * @param id
	 *            the id
	 * @param active
	 *            the active
	 * @param pw
	 *            the pw
	 * @param salt
	 *            the salt
	 * @param username
	 *            the username
	 * @param locked
	 *            the locked
	 * @param roles
	 *            the roles
	 * @return Users A Users object
	 */
	public Users newUsers(final Integer id, final Boolean active, final String pw,
		final String salt, final String username, final Boolean locked, final Set<Roles> roles)
	{
		final Users users = new Users();
		users.setActive(active);
		users.setLocked(locked);
		users.setId(id);
		users.setPw(pw);
		users.setSalt(salt);
		users.setUsername(username);
		if (roles != null)
		{
			users.setRoles(roles);
		}
		return users;
	}

}
