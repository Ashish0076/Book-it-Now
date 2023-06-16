package com.masai.ui;

import java.util.Scanner;

import com.masai.entity.ServiceProvider;
import com.masai.exception.NoRecordFoundException;
import com.masai.exception.SomeThingWentWrongException;
import com.masai.service.CustomerService;
import com.masai.service.CustomerServiceImpl;
import com.masai.service.ServiceProviderService;
import com.masai.service.ServiceProviderServiceImpl;

public class ServiceProviderUI {

	static void handleServiceProviderActions(Scanner sc) {
		int serviceProviderChoice;
		boolean loggedIn = false;

		do {
			System.out.println("===============================");
			System.out.println("    Appointment Scheduling");
			System.out.println("===============================");
			System.out.println();
			System.out.println("1. Register");
			System.out.println("2. Login");
			System.out.println("0. Exit");
			System.out.println();
			System.out.print("Please enter your choice: ");
			serviceProviderChoice = sc.nextInt();

			switch (serviceProviderChoice) {
			case 1:
				serviceProviderRegistration(sc);
				break;
			case 2:
				serviceProviderLogIn(sc);
				loggedIn = true;
				break;
			case 0:
				// Exit logic
				System.out.println("Exiting service provider menu...");
				break;
			default:
				System.out.println("Invalid choice. Please try again.");
				break;
			}

			if (loggedIn) {
				handleLoggedInServiceProviderActions(sc);
				loggedIn = false;
			}

		} while (serviceProviderChoice != 0);
	}

	private static void handleLoggedInServiceProviderActions(Scanner sc) {
		int serviceProviderLoggedInChoice;

		do {
			System.out.println("===============================");
			System.out.println("    Appointment Scheduling");
			System.out.println("===============================");
			System.out.println();
			System.out.println("1. Set up Availability");
			System.out.println("2. View Appointment Details");
			System.out.println("3. Open Appointment Slots");
			System.out.println("0. Logout");
			System.out.println();
			System.out.print("Please enter your choice: ");
			serviceProviderLoggedInChoice = sc.nextInt();

			switch (serviceProviderLoggedInChoice) {
			case 1:
				// Set up availability logic
				System.out.println("Setting up availability...");
				break;
			case 2:
				// View appointment details logic
				System.out.println("Viewing appointment details...");
				break;
			case 3:
				// Open appointment slots logic
				System.out.println("Opening appointment slots...");
				break;
			case 0:
				// Logout logic
				System.out.println("Logging out as a service provider...");
				break;
			default:
				System.out.println("Invalid choice. Please try again.");
				break;
			}

		} while (serviceProviderLoggedInChoice != 0);
	}

	// ------------------------------------------------------------------------------

	static void serviceProviderRegistration(Scanner sc) {
		System.out.print("Enter name ");
		String name = sc.next();
		System.out.print("Enter username ");
		String username = sc.next();
		System.out.print("Enter password ");
		String password = sc.next();
		System.out.print("Enter phone no. ");
		String phone = sc.next();
		System.out.print("Enter address ");
		String address = sc.next();
		System.out.print("Enter Decription ");
		String desc = sc.next();

		ServiceProvider sp = new ServiceProvider(username, password, name, phone, address, desc);

		try {
			ServiceProviderService sps = new ServiceProviderServiceImpl();
			sps.addServiceProvider(sp);
			System.out.println("Service Provider added successfully");
		} catch (SomeThingWentWrongException ex) {
			System.out.println(ex.getMessage());
		}
	}

	static void serviceProviderLogIn(Scanner sc) {
		System.out.println("Enter Username");
		String username = sc.next();
		System.out.println("Enter Password");
		String password = sc.next();

		try {
			ServiceProviderService sps = new ServiceProviderServiceImpl();
			sps.loginServiceProvider(username, password);
			System.out.println("Login successfully");
		} catch (NoRecordFoundException | SomeThingWentWrongException ex) {
			System.out.println(ex.getMessage());
		}
	}

}
