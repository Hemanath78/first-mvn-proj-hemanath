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

}
