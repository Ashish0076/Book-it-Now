package com.masai.dao;

import java.util.List;

import com.masai.entity.Appointment;
import com.masai.entity.Feedback;
import com.masai.entity.LoggedInServiceProvider;
import com.masai.exception.NoRecordFoundException;
import com.masai.exception.SomeThingWentWrongException;
import com.masai.utility.EMUtils;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.PersistenceException;
import jakarta.persistence.Query;


public class FeedbackDaoImpl implements FeedbackDao {

	@Override
	public void giveFeedback(Long appId, int rating, String cmt)
			throws SomeThingWentWrongException, NullPointerException {
		EntityManager em = null;
		EntityTransaction et = null;

		try {
			em = EMUtils.getEntityManager();
			Appointment ap = em.find(Appointment.class, appId);
			Feedback fb = new Feedback(ap, rating, cmt);
			
			et = em.getTransaction();
			et.begin();
			em.persist(fb);
			et.commit();
		} catch (PersistenceException ex) {
			et.rollback();
			throw new SomeThingWentWrongException("Unable to process request, try again later");
		} finally {
			em.close();
		}
		
	}

	@Override
	public List<Feedback> viewFeedback() throws SomeThingWentWrongException, NoRecordFoundException {
		EntityManager em = null;
		List<Feedback> fbList=null;
		try {
			em = EMUtils.getEntityManager();
			Query query =em.createQuery("SELECT f FROM Feedback f WHERE f.appointment.serviceProvider.providerId =:id");
			query.setParameter("id", LoggedInServiceProvider.loggedInServiceProvoderId);
			fbList = (List<Feedback>) query.getResultList();
			if(fbList.size()==0) {
				throw new NoRecordFoundException("No record found");
			}
		} catch (PersistenceException ex) {
			throw new SomeThingWentWrongException("Unable to process request, try again later");
		} finally {
			em.close();
		}
		return fbList;
	}

}
