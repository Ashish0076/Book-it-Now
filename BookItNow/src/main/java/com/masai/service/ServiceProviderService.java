package com.masai.service;

import java.util.List;

import com.masai.entity.ServiceProvider;
import com.masai.exception.NoRecordFoundException;
import com.masai.exception.SomeThingWentWrongException;

public interface ServiceProviderService {

	void addServiceProvider(ServiceProvider sp) throws SomeThingWentWrongException;

	void loginServiceProvider(String username, String password) throws NoRecordFoundException, SomeThingWentWrongException;

	List<ServiceProvider> viewAllSeviceProvider() throws NoRecordFoundException, SomeThingWentWrongException;

}
