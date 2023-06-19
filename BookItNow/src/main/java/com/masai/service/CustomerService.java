package com.masai.service;

import com.masai.entity.Customer;
import com.masai.exception.NoRecordFoundException;
import com.masai.exception.SomeThingWentWrongException;

public interface CustomerService {

	void addCustomer(Customer customer) throws SomeThingWentWrongException;

	void login(String username, String password) throws SomeThingWentWrongException, NoRecordFoundException;

}
