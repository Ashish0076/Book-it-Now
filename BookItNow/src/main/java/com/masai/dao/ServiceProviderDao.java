package com.masai.dao;

import java.util.List;

import com.masai.entity.ServiceProvider;
import com.masai.exception.NoRecordFoundException;
import com.masai.exception.SomeThingWentWrongException;

public interface ServiceProviderDao {

	void addServiceProvider(ServiceProvider sp) throws SomeThingWentWrongException;

	void loginServiceProvider(String username, String password) throws NoRecordFoundException, SomeThingWentWrongException;

	List<ServiceProvider> viewAllSeviceProvider() throws NoRecordFoundException, SomeThingWentWrongException;

}



//    void create(ServiceProvider serviceProvider);
//    ServiceProvider getById(int serviceProviderId);
//    List<ServiceProvider> getAll();
//    void update(ServiceProvider serviceProvider);
//    void delete(ServiceProvider serviceProvider);

