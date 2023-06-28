package com.fssa.hnm.day20.solved;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class StudentValidator {

	public static boolean validate(StudentObjSetGet student)
			throws IllegalArgumentException {

		// check for nullity of the parameter
		if (student == null) {
			throw new IllegalArgumentException("Argument is " + "NULL");
		}
		// Check for name, name should only have alphabets
		// For Simplicity, Check if name has length of 2.
		validateName(student.name);
		validateAge(student.age);
		validateEmail(student.emailId);
		validateRoll(student.roll);
		return true;
		}


	public static boolean validateName(String name)
			throws IllegalArgumentException {
		if (name == null || "".equals(name.trim()) || name.length() < 2) {
			throw new IllegalArgumentException(
					"Name cannot " + "be empty or null");
		}
		return true;
	}

	public static boolean validateAge(int age) throws IllegalArgumentException {
		// Assuming its a College Student with age range of
		// 17 to 20
		if (age >= 17 && age <= 20) {
			return true;
		}
		throw new IllegalArgumentException("Age should be between 17 and 20");

	}

	public static boolean validateEmail(String email)
			throws IllegalArgumentException {
		// Below is a Regex by RFC standard RFC 5322
		String regex = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";

		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(email);
		Boolean isMatch = matcher.matches();
//				Boolean isMatch = Pattern.matches(regex, email);

		if (isMatch) {
			return true;
		} else {
			throw new IllegalArgumentException("The email address is: Invalid");
		}
	}

	public static boolean validateRoll(int rollNo)
			throws IllegalArgumentException {

		if (rollNo > 1000 && rollNo < 10000) {
			return true;
		} else {
			throw new IllegalArgumentException("RollNo is not valid");
		}

	}

}


