package com.masai.dao;

import java.util.List;

import com.masai.entity.LoggedInCustomerId;
import com.masai.entity.ServiceProvider;
import com.masai.exception.NoRecordFoundException;
import com.masai.exception.SomeThingWentWrongException;
import com.masai.utility.EMUtils;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.PersistenceException;
import jakarta.persistence.Query;

public class ServiceProviderDaoImpl implements ServiceProviderDao {

	@Override
	public void addServiceProvider(ServiceProvider sp) throws SomeThingWentWrongException {
		EntityManager em = null;
		EntityTransaction et = null;

		try {
			em = EMUtils.getEntityManager();

			// checking if company with same username exists
			String q = "SELECT count(s) FROM ServiceProvider s WHERE username =:username";
			Query query = em.createQuery(q);
			query.setParameter("username", sp.getUsername());
			if ((Long) query.getSingleResult() > 0) {
				throw new SomeThingWentWrongException(
						"Customer already exists with name " + sp.getName() + ", try with different username");
			}

			et = em.getTransaction();
			et.begin();
			em.persist(sp);
			et.commit();
		} catch (PersistenceException ex) {
			et.rollback();
			throw new SomeThingWentWrongException("Unable to process request, try again later");
		} finally {
			em.close();
		}
		
	}

	@Override
	public void loginServiceProvider(String username, String password)
			throws NoRecordFoundException, SomeThingWentWrongException {
EntityManager em = null;
		
		try {
			em = EMUtils.getEntityManager();
			Query query = em.createQuery("SELECT s.providerId FROM ServiceProvider s WHERE username = :username AND password = :password");
			query.setParameter("username", username);
			query.setParameter("password", password);
			List<Long> listInt = (List<Long>)query.getResultList();
			if(listInt.size() == 0) {
				throw new SomeThingWentWrongException("The username or password is incorrect");
			}
			LoggedInCustomerId.loggedInUserId = listInt.get(0);
		}catch(PersistenceException ex) {
			throw new SomeThingWentWrongException("Unable to process request, try again later");
		}finally {
			em.close();
		}
		
	}

}
