package de.alpharogroup.user.service;

import java.util.List;

import javax.persistence.Query;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import de.alpharogroup.collections.ListExtensions;
import de.alpharogroup.db.service.jpa.AbstractBusinessService;
import de.alpharogroup.user.entities.Roles;
import de.alpharogroup.user.entities.Users;
import de.alpharogroup.user.repositories.UsersDao;
import de.alpharogroup.user.service.api.BaseUsersService;

@Transactional
@Service("baseUsersService")
public class BaseUserBusinessService extends AbstractBusinessService<Users, Integer, UsersDao>
	implements
		BaseUsersService
{

	/** The Constant LOGGER. */
	private final static Logger LOGGER = Logger.getLogger(BaseUserBusinessService.class.getName());
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	@Autowired
	public void setUsersDao(final UsersDao usersDao)
	{
		setDao(usersDao);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
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
	@Override
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
	@Override
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
	@Override
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