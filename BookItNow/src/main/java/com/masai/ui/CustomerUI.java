package com.masai.ui;

import java.util.Scanner;

import com.masai.exception.SomeThingWentWrongException;
import com.masai.service.CustomerService;
import com.masai.service.CustomerServiceImpl;
import com.masai.utility.Customer;
import com.masai.utility.LoggedInCustomerId;

public class CustomerUI {
	
	static void customerRegistration(Scanner sc) {
		System.out.print("Enter name ");
		String name = sc.next();
		System.out.print("Enter useranme ");
		String useranme = sc.next();
		System.out.print("Enter password ");
		String password = sc.next();
		System.out.print("Enter phone no. ");
		String phone = sc.next();
		System.out.print("Enter address ");
		String address = sc.next();
		
		Customer customer = new Customer(name, useranme, password, phone, address);
		
		try {
			CustomerService customerService = new CustomerServiceImpl();
			customerService.addCustomer(customer);
			System.out.println("Customer added successfully");		
		}catch(SomeThingWentWrongException ex) {
			System.out.println(ex.getMessage());
		}
	}

	static void customerLogIn(Scanner sc) {
		System.out.println("Enter Username");
		String useranme = sc.next();
		System.out.println("Enter Password");
		String password = sc.next();
		
//		try {
//			customerMenu(sc);
//		}catch(NoRecordFoundException | SomeThingWentWrongException ex) {
//			System.out.println(ex.getMessage());
//		}
	}
	
	static void customerMenu(Scanner sc) {
		int choice;
		do {
			System.out.println("1: View All Service Provider");
			System.out.println("2: Book Appointment");
			System.out.println("3: Cancel Appointment");
			System.out.println("4: Give feedback");
			System.out.println("5. Change Password");
			System.out.println("6. Delete Account");
			System.out.println("0: Log Out");
			System.out.println("Enter Selection");
			choice = sc.nextInt();
			
			switch(choice) {
			      case 1:
			    	  break;
			      case 2:
			    	  break;
			      case 3:
			    	  break;
			      case 4:
			    	  break;
			      case 5:
			    	  break;
			      case 6:
			    	  break;
			      case 0:
			    	  LoggedInCustomerId.loggedInUserId = -1;
			    	  System.out.println("Bye Bye User");
			    	  break;
			      default:
			    	  System.out.println("Invalid Selection, try again");
			}
		}while(choice!=0);
		sc.close();
	}
}
