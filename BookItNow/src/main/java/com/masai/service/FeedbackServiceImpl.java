package com.masai.service;

import java.util.List;

import com.masai.dao.FeedbackDao;
import com.masai.dao.FeedbackDaoImpl;
import com.masai.entity.Feedback;
import com.masai.exception.NoRecordFoundException;
import com.masai.exception.SomeThingWentWrongException;

public class FeedbackServiceImpl implements FeedbackService {

	@Override
	public void giveFeedback(Long appId, int rating, String cmt)
			throws SomeThingWentWrongException, NoRecordFoundException {
		FeedbackDao fbDao = new FeedbackDaoImpl();
		fbDao.giveFeedback( appId,  rating,  cmt);
	}

	@Override
	public List<Feedback> viewFeedback() throws SomeThingWentWrongException, NoRecordFoundException {
		FeedbackDao fbDao = new FeedbackDaoImpl();
		return fbDao.viewFeedback();
	}

}
