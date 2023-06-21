package com.masai.ui;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Scanner;

import com.masai.entity.Appointment;
import com.masai.entity.Feedback;
import com.masai.entity.LoggedInServiceProvider;
import com.masai.entity.ServiceProvider;
import com.masai.exception.NoRecordFoundException;
import com.masai.exception.SomeThingWentWrongException;
import com.masai.service.AppointmentService;
import com.masai.service.AppointmentServiceImpl;
import com.masai.service.FeedbackService;
import com.masai.service.FeedbackServiceImpl;
import com.masai.service.ServiceProviderService;
import com.masai.service.ServiceProviderServiceImpl;

public class ServiceProviderUI {

	static void handleServiceProviderActions(Scanner sc) {
		int choice;
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
			choice = sc.nextInt();

			switch (choice) {
			case 1:
				serviceProviderRegistration(sc);
				break;
			case 2:
				serviceProviderLogIn(sc);
				loggedIn = true;
				break;
			case 0:
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

		} while (choice != 0);
	}

	private static void handleLoggedInServiceProviderActions(Scanner sc) {
		int choice;

		do {
			System.out.println("===============================");
			System.out.println("    Appointment Scheduling");
			System.out.println("===============================");
			System.out.println();
			System.out.println("1. Open Appointment Slot");
			System.out.println("2. View Appointment Details");
			System.out.println("3. Update Appointment Slot");
			System.out.println("4. Delete Appointment Slot");
			System.out.println("5. View Booked Appointment Slot");
			System.out.println("6. View Feedback and Ratings");
			System.out.println("0. Logout");
			System.out.println();
			System.out.print("Please enter your choice: ");
			choice = sc.nextInt();

			switch (choice) {
			case 1:
				openAppointmentSlot(sc);
				break;
			case 2:
				viewAppointmentSlot();
				break;
			case 3:
				updateAppointmentSlot(sc);
				break;
			case 4:
				deleteAppointmentSlot(sc);
				break;
			case 5:
				viewBookedAppointment();
				break;
			case 6:
				veiwFeedback();
				break;
			case 0:
				LoggedInServiceProvider.loggedInServiceProvoderId = -1;
				System.out.println("Logged out Successful");
				break;
			default:
				System.out.println("Invalid choice. Please try again.");
				break;
			}

		} while (choice != 0);
	}

	// ------------------------------------------------------------------------------

	static void serviceProviderRegistration(Scanner sc) {

		System.out.print("Enter username ");
		String username = sc.next();
		System.out.print("Enter password ");
		String password = sc.next();
		System.out.print("Enter phone no. ");
		String phone = sc.next();
		sc.nextLine();
		System.out.print("Enter Service name ");
		String serviceName = sc.nextLine();
		System.out.print("Enter Decription ");
		String desc = sc.nextLine();

		ServiceProvider sp = new ServiceProvider(serviceName, username, password, phone, desc);

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

	static void openAppointmentSlot(Scanner sc) {
		System.out.println("Enter Appointment Date(yyyy-MM-dd)");
		LocalDate date = LocalDate.parse(sc.next());
		System.out.println("Enter Slot Start Time(24hrs[HH:mm])");
		LocalTime startTime = LocalTime.parse(sc.next());
		System.out.println("Enter Slot End Time(24hrs[HH:mm])");
		LocalTime endTime = LocalTime.parse(sc.next());
		System.out.println("Enter the appointment price");
		int price = sc.nextInt();

		try {
			Appointment appointment = new Appointment(date, startTime, endTime, price, true);

			AppointmentService appSer = new AppointmentServiceImpl();
			appSer.openAppointmentSlot(appointment);
			System.out.println("Slot Opened Successfully");
		} catch (SomeThingWentWrongException ex) {
			System.out.println(ex.getMessage());
		}
	}

	static void viewAppointmentSlot() {
		try {
			AppointmentService appSer = new AppointmentServiceImpl();
			List<Appointment> appList = appSer.viewAppointmentSlots();
			for (Appointment a : appList) {
				System.out.println("Appointment ID: " + a.getAppointmentId() + ", price: " + a.getPrice() + ", Date: "
						+ a.getAppointmentDate() + ", Starts at " + a.getStartTime() + " and Ends at "
						+ a.getEndTime());
			}
		} catch (SomeThingWentWrongException | NoRecordFoundException ex) {
			System.out.println(ex.getMessage());
		}
	}

	static void updateAppointmentSlot(Scanner sc) {
		AppointmentService appSer = new AppointmentServiceImpl();
		boolean isIdExist = false;
		System.out.println("Select from the given Appointments:");
		try {
			// print appointment lists
			List<Appointment> appList = appSer.viewAppointmentSlots();
			for (Appointment a : appList) {
				System.out.println("Appointment ID: " + a.getAppointmentId() + ", price: " + a.getPrice() + ", Date: " + a.getAppointmentDate()
						+ ", Starts at " + a.getStartTime() + " and Ends at " + a.getEndTime());
			}

			// update slot
			System.out.println("Enter Appointment Id ");
			Long appId = sc.nextLong();
			isIdExist = appSer.checkForAppointment(appId);

			if (isIdExist) {
				System.out.println("Enter updated Appointment Date(yyyy-MM-dd)");
				LocalDate date = LocalDate.parse(sc.next());
				System.out.println("Enter updated Slot Start Time(24hrs[HH:mm:ss])");
				LocalTime startTime = LocalTime.parse(sc.next());
				System.out.println("Enter updated Slot End Time(24hrs[HH:mm:ss])");
				LocalTime endTime = LocalTime.parse(sc.next());

				try {
					appSer.updateAppointSlot(appId, date, startTime, endTime);
					System.out.println("Slot Updated Successfully");
				} catch (SomeThingWentWrongException | NoRecordFoundException ex) {
					System.out.println(ex.getMessage());
				}
			} else {
				System.out.println("No Appointment slot found with the given id " + appId);
			}
		} catch (SomeThingWentWrongException | NoRecordFoundException ex) {
			System.out.println(ex.getMessage());
		}
	}

	static void deleteAppointmentSlot(Scanner sc) {
		AppointmentService appSer = new AppointmentServiceImpl();
		System.out.println("Select from the given Appointments:");
		try {
			// print appointment lists
			List<Appointment> appList = appSer.viewAppointmentSlots();
			for (Appointment a : appList) {
				System.out.println("Appointment ID: " + a.getAppointmentId() + ", price: " + a.getPrice() + ", Date: " + a.getAppointmentDate()
						+ ", Starts at " + a.getStartTime() + " and Ends at " + a.getEndTime());
			}

			// delete
			System.out.println("Enter Appointment Id ");
			Long appId = sc.nextLong();
			appSer.deleteAppointmentSlot(appId);
			System.out.println("Slot Deleted Successfully");
		} catch (SomeThingWentWrongException | NoRecordFoundException ex) {
			System.out.println(ex.getMessage());
		}
	}
	
	static void viewBookedAppointment() {
		AppointmentService appSer = new AppointmentServiceImpl();
		System.out.println("List of Booked Appointments:");
		
		try {
			// print appointment lists
			List<Appointment> appList = appSer.viewAppointmentSlots();
			for (Appointment a : appList) {
				if(!a.isAvaliable()) {
					System.out.println("Appointment ID: " + a.getAppointmentId() + ", price: " + a.getPrice() + ", Date: " + a.getAppointmentDate()
					+ ", Starts at " + a.getStartTime() + " and Ends at " + a.getEndTime());
				}				
			}
		} catch (SomeThingWentWrongException | NoRecordFoundException ex) {
			System.out.println(ex.getMessage());
		}
	}
	
	static void veiwFeedback() {
		System.out.println("Here are the list on feedback");
		try {
			FeedbackService fbSer = new FeedbackServiceImpl();
			List<Feedback> fbList = fbSer.viewFeedback();
			for(Feedback f: fbList) {
				System.err.println(f.toString());
			}
		}catch(SomeThingWentWrongException | NoRecordFoundException ex) {
			System.out.println(ex.getMessage());
		}
	}

}