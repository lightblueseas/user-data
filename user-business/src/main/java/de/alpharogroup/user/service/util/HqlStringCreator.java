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
package de.alpharogroup.user.service.util;

import java.util.Date;

import de.alpharogroup.user.entities.Permissions;
import de.alpharogroup.user.entities.RelationPermissions;
import de.alpharogroup.user.entities.ResetPasswords;
import de.alpharogroup.user.entities.Users;

public class HqlStringCreator
{


	public static String forPermissions(final String description, final String permissionName,
		final String shortcut)
	{
		final StringBuilder sb = new StringBuilder();
		sb.append("select p from " + Permissions.class.getSimpleName() + " p");
		final boolean descriptionIsNotNull = description != null && !description.isEmpty();
		if (descriptionIsNotNull)
		{
			sb.append(" ");
			sb.append("where p.description=:description");
		}
		final boolean permissionNameIsNotNull = permissionName != null && !permissionName.isEmpty();
		if (permissionNameIsNotNull)
		{
			sb.append(" ");
			if (descriptionIsNotNull)
			{
				sb.append("and p.permissionName=:permissionName");
			}
			else
			{
				sb.append("where p.permissionName=:permissionName");
			}
		}
		final boolean shortcutIsNotNull = shortcut != null && !shortcut.isEmpty();
		if (shortcutIsNotNull)
		{
			sb.append(" ");
			if (!descriptionIsNotNull && !permissionNameIsNotNull)
			{
				sb.append("where p.shortcut=:shortcut");
			}
			else
			{
				sb.append("and p.shortcut=:shortcut");
			}
		}
		return sb.toString();
	}

	public static String forRelationPermissions(final Users provider, final Users subscriber,
		final Permissions permission)
	{
		final StringBuilder sb = new StringBuilder();
		sb.append("select rp from " + RelationPermissions.class.getSimpleName() + " rp");
		final boolean providerIsNotNull = provider != null;
		if (providerIsNotNull)
		{
			sb.append(" ");
			sb.append("where rp.provider=:provider");
		}
		final boolean subscriberIsNotNull = subscriber != null;
		if (subscriberIsNotNull)
		{
			sb.append(" ");
			if (providerIsNotNull)
			{
				sb.append("and rp.subscriber=:subscriber");
			}
			else
			{
				sb.append("where rp.subscriber=:subscriber");
			}
		}
		final boolean permissionIsNotNull = permission != null;
		if (permissionIsNotNull)
		{
			sb.append(" ");
			if (!providerIsNotNull && !subscriberIsNotNull)
			{
				sb.append("where :permission in elements(rp.permissions)");
			}
			else
			{
				sb.append("and :permission in elements(rp.permissions)");
			}

		}
		return sb.toString();
	}

	public static String forResetPasswords(final Users user, final String generatedPassword,
		final Date expiryDate, final Date starttime)
	{
		final StringBuilder sb = new StringBuilder();
		sb.append("select r from " + ResetPasswords.class.getSimpleName() + " r");
		final boolean userIsNotNull = user != null;
		if (userIsNotNull)
		{
			sb.append(" ");
			sb.append("where r.user=:user");
		}
		final boolean generatedPasswordIsNotNull = generatedPassword != null
			&& !generatedPassword.isEmpty();
		if (generatedPasswordIsNotNull)
		{
			sb.append(" ");
			if (userIsNotNull)
			{
				sb.append("and r.generatedPassword=:generatedPassword");
			}
			else
			{
				sb.append("where r.generatedPassword=:generatedPassword");
			}
		}
		final boolean expiryDateIsNotNull = expiryDate != null;
		if (expiryDateIsNotNull)
		{
			sb.append(" ");
			if (!userIsNotNull && !generatedPasswordIsNotNull)
			{
				sb.append("where r.expiryDate=:expiryDate");
			}
			else
			{
				sb.append("and r.expiryDate=:expiryDate");
			}
		}

		final boolean starttimeIsNotNull = starttime != null;
		if (starttimeIsNotNull)
		{
			sb.append(" ");
			if (!userIsNotNull && !generatedPasswordIsNotNull && !expiryDateIsNotNull)
			{
				sb.append("where rv.starttime=:starttime");
			}
			else
			{
				sb.append("and rv.starttime=:starttime");
			}
		}
		return sb.toString();
	}
}
