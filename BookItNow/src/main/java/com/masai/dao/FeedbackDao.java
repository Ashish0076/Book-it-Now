package com.masai.dao;

import java.util.List;

import com.masai.entity.Feedback;
import com.masai.exception.NoRecordFoundException;
import com.masai.exception.SomeThingWentWrongException;

public interface FeedbackDao {

	void giveFeedback(Long appId, int rating, String cmt) throws SomeThingWentWrongException, NullPointerException;

	List<Feedback> viewFeedback() throws SomeThingWentWrongException, NoRecordFoundException;

}


