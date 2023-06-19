package com.masai.service;

import com.masai.dao.ServiceProviderDao;
import com.masai.dao.ServiceProviderDaoImpl;
import com.masai.entity.ServiceProvider;
import com.masai.exception.NoRecordFoundException;
import com.masai.exception.SomeThingWentWrongException;

public class ServiceProviderServiceImpl implements ServiceProviderService{

	@Override
	public void addServiceProvider(ServiceProvider sp) throws SomeThingWentWrongException {
		ServiceProviderDao spd = new ServiceProviderDaoImpl();
		spd.addServiceProvider(sp);
	}

	@Override
	public void loginServiceProvider(String username, String password)
			throws NoRecordFoundException, SomeThingWentWrongException {
		ServiceProviderDao spd = new ServiceProviderDaoImpl();
		spd.loginServiceProvider(username, password);
		
	}

}
