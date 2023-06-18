package com.masai.ui;

import java.util.List;
import java.util.Scanner;
import java.util.Set;

import com.masai.entity.Appointment;
import com.masai.entity.Customer;
import com.masai.entity.ServiceProvider;
import com.masai.exception.NoRecordFoundException;
import com.masai.exception.SomeThingWentWrongException;
import com.masai.service.AppointmentService;
import com.masai.service.AppointmentServiceImpl;
import com.masai.service.CustomerService;
import com.masai.service.CustomerServiceImpl;
import com.masai.service.ServiceProviderService;
import com.masai.service.ServiceProviderServiceImpl;

public class CustomerUI {

	static void handleCustomerActions(Scanner sc) {
		int customerChoice;
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
			customerChoice = sc.nextInt();

			switch (customerChoice) {
			case 1:
				customerRegistration(sc);
				break;
			case 2:
				customerLogIn(sc);
				loggedIn = true;
				break;
			case 0:
				System.out.println("Exiting customer menu...");
				break;
			default:
				System.out.println("Invalid choice. Please try again.");
				break;
			}

			if (loggedIn) {
				handleLoggedInCustomerActions(sc);
				loggedIn = false;
			}

		} while (customerChoice != 0);
	}

	private static void handleLoggedInCustomerActions(Scanner sc) {
		int customerLoggedInChoice;

		do {
			System.out.println("===============================");
			System.out.println("    Appointment Scheduling");
			System.out.println("===============================");
			System.out.println();
			System.out.println("1. View Service Provider Profiles");
			System.out.println("2. Book Appointment");
			System.out.println("3. Cancel Appointment");
			System.out.println("4. Provide Feedback and Ratings");
			System.out.println("0. Logout");
			System.out.println();
			System.out.print("Please enter your choice: ");
			customerLoggedInChoice = sc.nextInt();

			switch (customerLoggedInChoice) {
			case 1:
				viewAllSeviceProvider();
				break;
			case 2:
				bookAppointment(sc);
				break;
			case 3:
				cancelAppointment(sc);
				break;
			case 4:
				// Provide feedback and ratings logic
				System.out.println("Providing feedback and ratings...");
				break;
			case 0:
				// Logout logic
				System.out.println("Logging out as a customer...");
				break;
			default:
				System.out.println("Invalid choice. Please try again.");
				break;
			}

		} while (customerLoggedInChoice != 0);
	}

	// "----------------------------------------------------------------------"

	static void customerRegistration(Scanner sc) {
		System.out.print("Enter name ");
		String name = sc.next();
		System.out.print("Enter useranme ");
		String username = sc.next();
		System.out.print("Enter password ");
		String password = sc.next();
		System.out.print("Enter phone no. ");
		String phone = sc.next();
		System.out.print("Enter address ");
		String address = sc.next();

		Customer customer = new Customer(name, username, password, phone, address);

		try {
			CustomerService customerService = new CustomerServiceImpl();
			customerService.addCustomer(customer);
			System.out.println("Customer added successfully");
		} catch (SomeThingWentWrongException ex) {
			System.out.println(ex.getMessage());
		}
	}

	static void customerLogIn(Scanner sc) {
		System.out.println("Enter Username");
		String useranme = sc.next();
		System.out.println("Enter Password");
		String password = sc.next();

		try {
			CustomerService customerService = new CustomerServiceImpl();
			customerService.login(useranme, password);
			System.out.println("Log In successfully");
		} catch (NoRecordFoundException | SomeThingWentWrongException ex) {
			System.out.println(ex.getMessage());
		}
	}

	static void viewAllSeviceProvider() {
		try {
			ServiceProviderService spService = new ServiceProviderServiceImpl();

			List<ServiceProvider> spList = spService.viewAllSeviceProvider();

			for (int i = 0; i < spList.size(); i++) {
				ServiceProvider serviceProvider = spList.get(i);

				System.out.println("ServiceProvider name=" + serviceProvider.getName() + ", phoneNumber="
						+ serviceProvider.getPhoneNumber() + ", address=" + serviceProvider.getAddress());

				Set<Appointment> appSet = serviceProvider.getAppointments();
				for (Appointment appointment : appSet) {
					if (appointment.isAvaliable()) {
						System.out.println("Available appointment id: " + appointment.getAppointmentId() + " Date: "
								+ appointment.getAppointmentDate() + ", Starts at " + appointment.getStartTime()
								+ " and Ends at " + appointment.getEndTime());
					}
				}
				System.out.println();
			}
		} catch (SomeThingWentWrongException | NoRecordFoundException ex) {
			System.out.println(ex.getMessage());
		}
	}

	static void bookAppointment(Scanner sc) {
		viewAllSeviceProvider();
		System.out.println("Enter the appointment id to book");
		try {
			AppointmentService appSer = new AppointmentServiceImpl();
			 Long appId = sc.nextLong();
			 appSer.bookAppointment(appId);
             System.out.println("Appointment booked Successfully");
		}catch (SomeThingWentWrongException ex) {
	        System.out.println(ex.getMessage());
	    }
	}
	
	static void cancelAppointment() {
		
	}

}
