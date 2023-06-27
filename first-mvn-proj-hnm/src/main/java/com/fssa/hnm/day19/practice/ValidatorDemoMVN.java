package com.fssa.hnm.day19.practice;

//importing scanner to get the inputs from the user

import java.util.Scanner;

//importing regex pattern class to validate the user inputs

import java.util.regex.Pattern;

//blueprint for user details

class UserDetails {

//userDetails holds 
//attributes of the user
//that are declared below with data types

String id;
String name;
String password;
String email;

//for each attribute there are two methods one will set the values to the attribute
//another one method it will return the value to the attribute

//return value to the id attribute
public String getId() {
	return id;
}

//set the value to the id attribute
public void setId(String id) {
	this.id = id;
}

//return value to the name attribute
public String getName() {
	return name;
}

//set the value to the name attribute
public void setName(String name) {
	this.name = name;
}

//return value to the password attribute
public String getPassword() {
	return password;
}

//set the value to password attribute
public void setPassword(String password) {
	this.password = password;
}

//return the value to the email attribute
public String getEmail() {
	return email;
}

//set the value to the email attribute
public void setEmail(String email) {
	this.email = email;
}

}

//validating the user details

class UserValidator {

//main method which holds all the validations for the user details

public static boolean validate(UserDetails user) {

//	calling the method to validate the id

	idValidate(user.id);

//	calling the method which validates the name

	nameValidate(user.name);

//	calling the method which validates the email id

	emailValidate(user.email);

//	calling the method which validates the password

	passwordValidate(user.password);

//	if all the validates are good
//	then return true

	return true;
}

//validating the id
//id must contains numbers only no alphabets, no special characters, no whitespaces
//minimum is 2 character and maximum is 5 character

public static boolean idValidate(String id) throws IllegalArgumentException  {
	
//	throw new error if the id is null
	
	if(id == null) {
		
		throw new IllegalArgumentException("Id cannot be null");
	}
	
//	Trimming the spaces in the both ends
	
	String userId = id.trim();

//	if the given input is null or white spaces
//	then the below error will thrown
	if ("".equals(userId)) {
		throw new IllegalArgumentException("Invalid id. Id cannot be white spaces");
	}

	int num = Integer.parseInt(userId);
	
//	if the id is e to then throw an error
	
	if(num == 0) {
		
		throw new IllegalArgumentException("Invalid id. Id cannot be zero.");
	}

//	if the id is lesser than zero then throw an error
	if (num < 0) {

		throw new IllegalArgumentException("Invalid id. Id cannote be lesser than zero.");
	}
	
//	minimum length for id is one 
//	if the given input length is 1 then throw new error
	
	if(userId.length() == 1) {
		
		throw new IllegalArgumentException("Invalid id. Minimum 2 characters requested.");
	}
	
//	maximum length for id is five
//	if the given input length is greater than five throw new error
	
	if(userId.length() > 5) {
		
		throw new IllegalArgumentException("Invalid id. Maximum 5 character is allowed.");
	}

//	regex pattern for id
	String numberPattern = "^\\d.*\\d$";
//	the below matches the given string with pattern
//	if matches it will return true otherwise false
	Boolean isMatch = Pattern.matches(numberPattern, userId);
	

//	if isMatch holds false value throw new error
	if (!isMatch) {
	    throw new IllegalArgumentException("Invalid id. Given input doesn't match the requested format.");
	}
	
	return true;
}

//validating the name
//name must contains upper and lower case letters
//no white spaces no special characters no numbers
//minimum length is 3 maximum length is 30

public static void nameValidate(String name) throws IllegalArgumentException {

	String userName = name.trim();
	
//	if the given input is null or white spaces
//	then the below error will thrown
	if ("".equals(userName)) {
		throw new IllegalArgumentException("Invalid name. Name cannot be null or white spaces.");
	}
	
//	minimum length for name is 3
//	if the given input is lesser than 3 throw new error
	
	if(userName.length() < 3) {
		
		throw new IllegalArgumentException("Invalid name. Minimum 3 characters requested.");
	}

//	regex pattern for name
	String namePattern = "^[A-Za-z]+$";
//	the below matches the given string with pattern
//	if matches it will return true otherwise false
	Boolean isMatch = Pattern.matches(namePattern, userName);

//	if isMatch holds false value throw new error
	if (!isMatch) {

		throw new IllegalArgumentException("Invalid name. Given input doesn't match the requested format.");
	}
}

//validating the email
//email id must contains '@' symbol and '.' in the last

public static void emailValidate(String email) throws IllegalArgumentException {
	
	String userEmail = email.trim();

//	if the given input is null or white spaces
//	then the below error will thrown
	if ("".equals(userEmail)) {
		throw new IllegalArgumentException("Invalid email. Email id cannot be null or white spaces.");
	}

//	regex pattern for email id
	String emailPattern = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";
//	the below matches the given string with pattern
//	if matches it will return true otherwise false
	Boolean isMatch = Pattern.matches(emailPattern, userEmail);

//	if isMatch holds false value throw new error
	if (!isMatch) {

		throw new IllegalArgumentException("Invalid email. Given input doesn't match the requested format.");
	}
}

//validating the password	
//password must contains one lower case, one upper case, one special character and one number
//no white spaces
//minimum is 8 characters and maximum is 16 character

public static void passwordValidate(String password) throws IllegalArgumentException {

	String userPassword = password.trim();
	
//	if the given input is null or white spaces
//	then the below error will thrown
	if ("".equals(userPassword)) {
		throw new IllegalArgumentException("Invalid password. Password cannot be null or white spaces.");
	}

//	regex pattern for password
	String passwordPattern = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,16}$";
//	the below matches the given string with pattern
//	if matches it will return true otherwise false
	Boolean isMatch = Pattern.matches(passwordPattern, userPassword);

//	if isMatch holds false value throw new error
	if (!isMatch) {

		throw new IllegalArgumentException("Invalid Password. Given input doesn't match the requested format.");
	}
}

}

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
	String id = s2.next();
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

	user.setId(id.trim());
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
