package com.masai.service;

import com.masai.dao.CustomerDao;
import com.masai.dao.CustomerDaoImpl;
import com.masai.entity.Customer;
import com.masai.exception.NoRecordFoundException;
import com.masai.exception.SomeThingWentWrongException;

public class CustomerServiceImpl implements CustomerService {

	@Override
	public void addCustomer(Customer customer) throws SomeThingWentWrongException {
		CustomerDao cd = new CustomerDaoImpl();
		cd.addCustomer(customer);
		
	}

	@Override
	public void login(String username, String password) throws SomeThingWentWrongException, NoRecordFoundException {
		CustomerDao cd = new CustomerDaoImpl();
		cd.login(username, password);
	}

}
