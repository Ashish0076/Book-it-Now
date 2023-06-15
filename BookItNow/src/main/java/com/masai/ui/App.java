package com.masai.ui;

import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
    	int choice = 0;
    	do {
    		System.out.println("1. Customer Login");
    		System.out.println("2. Service Provider Login");
    		System.out.println("3. Customer Registration");
    		System.out.println("4. Service Provider Registration");
    		System.out.println("0. Exit");
    		System.out.print("Enter Selection ");
    		choice = sc.nextInt();
    		switch(choice) {
    			case 1:
    				CustomerUI.customerLogIn(sc);
    				break;
    			case 2:
    				//CustomerUI.userLogin(sc);
    				break;
    			case 3:
    				CustomerUI.customerRegistration(sc);
    				break;
    			case 4:
    				//.customerRegistration(sc);
    				break;
    			case 0:
    				System.out.println("Thanks for using the services");
    				break;
    			default:
    				System.out.println("Invalid Selection, try again");
    		}
    	}while(choice != 0);
    	sc.close();

	}

}
