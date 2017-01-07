package de.alpharogroup.user.management.service;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.persistence.Query;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import de.alpharogroup.collections.ListExtensions;
import de.alpharogroup.date.CalculateDateExtensions;
import de.alpharogroup.db.service.jpa.AbstractBusinessService;

import de.alpharogroup.user.management.daos.UsersDao;
import de.alpharogroup.user.management.entities.Roles;
import de.alpharogroup.user.management.entities.Users;
import de.alpharogroup.user.management.service.api.UsersService;

@Transactional
@Service("usersService")
public class UsersBusinessService extends AbstractBusinessService<Users, Integer, UsersDao>
	implements
		UsersService
{

	/** The Constant LOGGER. */
	private final static Logger LOGGER = Logger.getLogger(UsersBusinessService.class.getName());
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Autowired
	public void setUsersDao(UsersDao usersDao)
	{
		setDao(usersDao);
	}

	/**
	 * {@inheritDoc}
	 */
	public boolean existsUserWithUsername(final String username)
	{
		final Users users = findUserWithUsername(username);
		if (users != null)
		{
			return true;
		}
		return false;
	}

	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("unchecked")
	public List<Roles> findRolesFromUser(final Users user)
	{
		final String hqlString = "select u.roles from Users u " + "where u=:user";
		final Query query = getQuery(hqlString);
		query.setParameter("user", user);
		final List<Roles> roles = query.getResultList();
		return roles;
	}

	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("unchecked")
	public Users findUserWithUsername(final String username)
	{
		final String hqlString = "select u from Users u " + "where u.username=:username";
		final Query query = getQuery(hqlString);
		query.setParameter("username", username);
		final List<Users> users = query.getResultList();
		return ListExtensions.getFirst(users);
	}

	/**
	 * {@inheritDoc}
	 */
	public boolean userIsInRole(final Users user, final Roles role)
	{
		final List<Roles> roles = findRolesFromUser(user);
		if (null != roles && (!roles.isEmpty()))
		{
			if (roles.contains(role))
			{
				return true;
			}
		}
		return false;
	}

}