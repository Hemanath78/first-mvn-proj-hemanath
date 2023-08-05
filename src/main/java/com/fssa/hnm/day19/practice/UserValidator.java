package com.fssa.hnm.day19.practice;

//importing regex pattern class to validate the user inputs

import java.util.regex.Pattern;

//validating the user details

public class UserValidator {

//main method which holds all the validations for the user details

	public static boolean validate(UserDetails user) throws IllegalArgumentException {

//		throw new error if object is null

		if (user == null) {

			throw new IllegalArgumentException("Student object cannot be null.");
		}

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

	public static boolean idValidate(int id) throws IllegalArgumentException {

//		if the id is less than or equal to zero thrown new error

		if (id <= 0) {

			throw new IllegalArgumentException("Invalid id. Id cannot be zero or less than zero.");
		}

//		if the id is less than 1 or greater than 999 throw new error

		if (id >= 1000) {

			throw new IllegalArgumentException("Invalid id. Id must within 3 digit number.");
		}

//	if there is no exception return true

		return true;
	}

//validating the name
//name must contains upper and lower case letters
//no white spaces no special characters no numbers
//minimum length is 3 maximum length is 30

	public static boolean nameValidate(String name) throws IllegalArgumentException {

//	throw new error if name is null

		if (name == null) {

			throw new IllegalArgumentException("Invalid name. Name cannot be null.");
		}

		String userName = name.trim();

//	if the given input is null or white spaces
//	then the below error will thrown
		if ("".equals(userName)) {
			throw new IllegalArgumentException("Invalid name. Name cannot be white spaces.");
		}

//	minimum length for name is 3
//	if the given input is lesser than 3 throw new error

		if (userName.length() < 3) {

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

//	if there is no exception then return true
		return true;
	}

//validating the email
//email id must contains '@' symbol and '.' in the last

	public static boolean emailValidate(String email) throws IllegalArgumentException {

//	throw new error if email is null

		if (email == null) {

			throw new IllegalArgumentException("Invalid email. Email cannot be null.");
		}

		String userEmail = email.trim();

//	if the given input is null or white spaces
//	then the below error will thrown
		if ("".equals(userEmail)) {
			throw new IllegalArgumentException("Invalid email. Email id cannot be white spaces.");
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

//	if there is no exception then return true
		return true;
	}

//validating the password	
//password must contains one lower case, one upper case, one special character and one number
//no white spaces
//minimum is 8 characters and maximum is 16 character

	public static boolean passwordValidate(String password) throws IllegalArgumentException {

//	throw new error if password is null

		if (password == null) {

			throw new IllegalArgumentException("Invalid password. Password cannot be null");
		}

		String userPassword = password.trim();

//	if the given input is null or white spaces
//	then the below error will thrown
		if ("".equals(userPassword)) {
			throw new IllegalArgumentException("Invalid password. Password cannot be white spaces.");
		}

//		password must be 8 characters length

		if (userPassword.length() < 8) {

			throw new IllegalArgumentException("Invalid password. Password must be 8 characters.");
		}

//		password must be with 16 character length

		if (userPassword.length() > 16) {

			throw new IllegalArgumentException("Invalid password. Password must be within 16 characters.");
		}

//	regex pattern for password
		String passwordPattern = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]+$";
//	the below matches the given string with pattern
//	if matches it will return true otherwise false
		Boolean isMatch = Pattern.matches(passwordPattern, userPassword);

//	if isMatch holds false value throw new error
		if (!isMatch) {

			throw new IllegalArgumentException("Invalid Password. Given input doesn't match the requested format.");
		}

//		if there is not exception then return true
		return true;
	}

}
