package com.masai.service;

import java.util.List;

import com.masai.entity.Feedback;
import com.masai.exception.NoRecordFoundException;
import com.masai.exception.SomeThingWentWrongException;

public interface FeedbackService {

	void giveFeedback(Long appId, int rating, String cmt) throws SomeThingWentWrongException, NoRecordFoundException;

	List<Feedback> viewFeedback() throws SomeThingWentWrongException, NoRecordFoundException;

}
