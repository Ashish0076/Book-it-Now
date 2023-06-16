package com.masai.dao;

import com.masai.entity.ServiceProvider;
import com.masai.exception.NoRecordFoundException;
import com.masai.exception.SomeThingWentWrongException;

public interface ServiceProviderDao {

	void addServiceProvider(ServiceProvider sp) throws SomeThingWentWrongException;

	void loginServiceProvider(String username, String password) throws NoRecordFoundException, SomeThingWentWrongException;

}
