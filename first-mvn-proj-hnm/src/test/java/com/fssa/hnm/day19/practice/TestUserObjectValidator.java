package com.fssa.hnm.day19.practice;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class TestUserObjectValidator {

//	id validation test cases start (7 test cases)

	@Test // checking with correct user id
	public void testIdValidate() {
//		I am expecting true value from the method which validates the user id
		assertTrue(UserValidator.idValidate("0134"));
	}

	@Test // checking with null user id
	public void testIdValidatewithnull() {

//		Lambda expression to short hand the try and catch
//		declaring a variable to store the error message
//		I am calling assertThrows method and passing which type of exception it will thrown
//		when you run the following method
		Exception exception = assertThrows(IllegalArgumentException.class, () -> {
			UserValidator.idValidate(null);
		});

//	    assertTrue(exception.getMessage().contains("Id cannot be null"));

		assertEquals("Id cannot be null", exception.getMessage());

	}

	@Test // checking with empty string
	public void testIdWithEmptyString() {

		Exception exception = assertThrows(IllegalArgumentException.class, () -> {
			UserValidator.idValidate("      ");
		});

		assertEquals("Invalid id. Id cannot be white spaces", exception.getMessage());
	}

	@Test // checking with zero user id
	public void testIdWithZero() {

		Exception exception = assertThrows(IllegalArgumentException.class, () -> {
			UserValidator.idValidate("0");
		});

		assertEquals("Invalid id. Id cannot be zero.", exception.getMessage());
	}

	@Test // checking the id length one
	public void testIdWithLenOne() {
		Exception exception = assertThrows(IllegalArgumentException.class, () -> {
			UserValidator.idValidate("2");
		});

		assertEquals("Invalid id. Minimum 2 characters requested.", exception.getMessage());

	}

	@Test // checking the id is not more than 5 characters
	public void testIdWithMoreThanFive() {
		Exception exception = assertThrows(IllegalArgumentException.class, () -> {
			UserValidator.idValidate("2345678");
		});

		assertEquals("Invalid id. Maximum 5 character is allowed.", exception.getMessage());

	}

	@Test // checking the id with alphabets and special characters
	public void testIdWithPattern() {
		Exception exception = assertThrows(IllegalArgumentException.class, () -> {
			UserValidator.idValidate("123ab");
		});

		assertEquals("Invalid id. Given input doesn't match the requested format.", exception.getMessage());
	}

//	end of id validation test cases

//	start of user name test cases(5 test cases)

	@Test // checking with correct input
	public void testNameValidate() {

		assertTrue(UserValidator.nameValidate("Hemanath"));
	}

	@Test // checking with null input
	public void testNameWithNull() {

		Exception exception = assertThrows(IllegalArgumentException.class, () -> {

			UserValidator.nameValidate(null);
		});

		assertEquals("Invalid name. Name cannot be null.", exception.getMessage());
	}

	@Test // checking with empty string name
	public void testNameEmpty() {

		Exception exception = assertThrows(IllegalArgumentException.class, () -> {
			UserValidator.nameValidate("    ");
		});

		assertEquals("Invalid name. Name cannot be white spaces.", exception.getMessage());
	}

	@Test // checking with name less than 3 len
	public void testNameLessThanThree() {

		Exception exception = assertThrows(IllegalArgumentException.class, () -> {

			UserValidator.nameValidate("So");
		});

		assertEquals("Invalid name. Minimum 3 characters requested.", exception.getMessage());
	}

	@Test // checking the name with special characters and numbers
	public void testNamePattern() {

		Exception exception = assertThrows(IllegalArgumentException.class, () -> {
			UserValidator.nameValidate("12@67Hemanath");
		});

		assertEquals("Invalid name. Given input doesn't match the requested format.", exception.getMessage());
	}

//	end of name test cases

//	start of email test cases (4 test cases)

	@Test // checking with correct input
	public void testEmailValidate() {

		assertTrue(UserValidator.emailValidate("hemanath7867@gmail.com"));
	}

	@Test // checking with null input
	public void testEmailWithNull() {

		Exception exception = assertThrows(IllegalArgumentException.class, () -> {

			UserValidator.emailValidate(null);
		});

		assertEquals("Invalid email. Email cannot be null.", exception.getMessage());
	}

	@Test // checking with empty string input
	public void testEmailWithEmptyString() {

		Exception exception = assertThrows(IllegalArgumentException.class, () -> {

			UserValidator.emailValidate("     ");
		});

		assertEquals("Invalid email. Email id cannot be white spaces.", exception.getMessage());
	}

	@Test // checking with email pattern
	public void testEmailWithPattern() {

		Exception exception = assertThrows(IllegalArgumentException.class, () -> {

			UserValidator.emailValidate("hemanath@");
		});

		assertEquals("Invalid email. Given input doesn't match the requested format.", exception.getMessage());
	}

//	end of email test cases

//	start of password test cases (6 test cases)

	@Test // checking with correct input
	public void testPasswordValidate() {

		assertTrue(UserValidator.passwordValidate("Abcd1234!"));
	}

	@Test // checking with null input
	public void testPasswordWithNull() {

		Exception exception = assertThrows(IllegalArgumentException.class, () -> {

			UserValidator.passwordValidate(null);
		});

		assertEquals("Invalid password. Password cannot be null", exception.getMessage());
	}

	@Test // checking with empty string
	public void testPasswordWithEmptyString() {

		Exception exception = assertThrows(IllegalArgumentException.class, () -> {

			UserValidator.passwordValidate("    ");
		});

		assertEquals("Invalid password. Password cannot be white spaces.", exception.getMessage());
	}

	@Test // checking with less than 8 char
	public void testPasswordWithLessthanChar() {

		Exception exception = assertThrows(IllegalArgumentException.class, () -> {

			UserValidator.passwordValidate("demopa");
		});

		assertEquals("Invalid password. Password must be 8 characters.", exception.getMessage());
	}

	@Test // checking with more than 16 char
	public void testPasswordWithMorethanChar() {

		Exception exception = assertThrows(IllegalArgumentException.class, () -> {

			UserValidator.passwordValidate("Hemanath1234@_.hi9097890");
		});

		assertEquals("Invalid password. Password must be within 16 characters.", exception.getMessage());
	}

	@Test // checking with password pattern
	public void testPasswordWithPattern() {

		Exception exception = assertThrows(IllegalArgumentException.class, () -> {

			UserValidator.passwordValidate("Hemanath12");
		});

		assertEquals("Invalid Password. Given input doesn't match the requested format.", exception.getMessage());
	}

//	end of password test cases

}
