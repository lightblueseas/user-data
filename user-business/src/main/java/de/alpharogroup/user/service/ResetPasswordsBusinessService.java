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
package de.alpharogroup.user.service;

import java.util.Date;
import java.util.List;

import javax.persistence.Query;

import de.alpharogroup.collections.ListExtensions;
import de.alpharogroup.db.service.jpa.AbstractBusinessService;
import de.alpharogroup.user.entities.ResetPasswords;
import de.alpharogroup.user.entities.Users;
import de.alpharogroup.user.repositories.ResetPasswordsDao;

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