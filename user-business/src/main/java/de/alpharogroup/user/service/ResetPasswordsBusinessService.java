package de.alpharogroup.user.service;

import java.util.Date;
import java.util.List;

import javax.persistence.Query;

import de.alpharogroup.collections.ListExtensions;
import de.alpharogroup.db.service.jpa.AbstractBusinessService;
import de.alpharogroup.user.management.daos.ResetPasswordsDao;
import de.alpharogroup.user.management.entities.ResetPasswords;
import de.alpharogroup.user.management.entities.Users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import de.alpharogroup.user.service.util.HqlStringCreator;
import de.alpharogroup.user.service.api.ResetPasswordsService;

@Transactional
@Service("resetPasswordsService")
public class ResetPasswordsBusinessService extends AbstractBusinessService<ResetPasswords, Integer, ResetPasswordsDao> implements ResetPasswordsService {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	@Autowired
	public void setResetPasswordsDao(final ResetPasswordsDao resetPasswordsDao) {
		setDao(resetPasswordsDao);
	}


	/**
	 * {@inheritDoc}
	 */
	@Override
	public ResetPasswords findResetPassword(final Users user) {
		return ListExtensions.getFirst(find(user, null, null, null));
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ResetPasswords findResetPassword(final Users user,
			final String generatedPassword) {
		return ListExtensions.getFirst(find(user, generatedPassword, null, null));
	}


	@SuppressWarnings("unchecked")
	public List<ResetPasswords> find(final Users user, final String generatedPassword, final Date expiryDate, final Date starttime) {
		final String hqlString = HqlStringCreator.forResetPasswords(user, generatedPassword, expiryDate, starttime);
		final Query query = getQuery(hqlString);
		if(user != null){
			query.setParameter("user", user);
		}
		if(generatedPassword != null) {
			query.setParameter("generatedPassword", generatedPassword);
		}
		if(expiryDate != null){
			query.setParameter("expiryDate", expiryDate);
		}
		if(starttime != null){
			query.setParameter("starttime", starttime);
		}
		final List<ResetPasswords> resetPasswords = query.getResultList();
		return resetPasswords;
	}

}