package com.fssa.hnm.day19.practice;

//importing scanner to get the inputs from the user

import java.util.Scanner;

public class ValidatorDemoMVN {

	public static void main(String[] args) {

//	creating new scanner object to get input from the user

		Scanner s2 = new Scanner(System.in);

//	creating new object in the instance of class userDetails
//	the user will have user id, user name, email id, password

		UserDetails user = new UserDetails();

//	getting the inputs from the user
//	by trimming the start and end white spaces

//	user id
		System.out.print("Enter your Id(eg: 121,321): ");
		int id = s2.nextInt();
		s2.nextLine();

//	name
		System.out.print("Enter your name(eg: Vijay): ");
		String name = s2.next();
		s2.nextLine();

//	email id
		System.out.print("Enter your email id(eg: example@gmail.com): ");
		String emailId = s2.next();
		s2.nextLine();

//	password
		System.out.print("Enter your password: ");
		String password = s2.next();
		s2.nextLine();

//	setting the values to the attributes of the user details

		user.setId(id);
		user.setName(name.trim());
		user.setEmail(emailId.trim());
		user.setPassword(password.trim());

		try {

//		calling the validate method to validate the user object details
//		if all the details are good 
//		then the method will return true

			boolean isValid = UserValidator.validate(user);

//		if the isValid holds true then print the below pirnt statement

			if (isValid) {

				System.out.println("all are good");
			}

		} catch (IllegalArgumentException e) {

			System.out.println(e.getMessage());
		} finally {

			System.out.println("Thank you");
		}

//	closing the scanner
		s2.close();
	}
}
