package com.fssa.hnm.day19.practice;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class TestUserObjectValidator {

//	creating one object using the blueprint of the user details 
//	and using it every where
	
	public UserDetails checkValidate() {

		UserDetails user = new UserDetails();

		user.id = 125;
		user.name = "Hemanath";
		user.email = "hemanathm4@gmail.com";
		user.password = "Hemanath@7867";

		return user;
	}

//	creating a new object with null 
//	and testing the validation
	@Test // checking the object validate with null
	public void testObjWithNull() {

		Exception exception = assertThrows(IllegalArgumentException.class, () -> {

			UserValidator.validate(null);
		});

		assertEquals("Student object cannot be null.", exception.getMessage());

	}
	
	@Test // validating the main validation method
	public void Validators() {
		
		UserDetails user = checkValidate();
		
		assertTrue(UserValidator.validate(user));
	}

//	id validation test cases start (3 test cases)

	@Test // checking with correct user id
	public void testIdValidate() {
//		I am expecting true value from the method which validates the user id
		
		assertTrue(UserValidator.idValidate(132));
	} 

	@Test // checking with zero user id
	public void testIdWithZero() {

		Exception exception = assertThrows(IllegalArgumentException.class, () -> {
			UserValidator.idValidate(0);
		});

		assertEquals("Invalid id. Id cannot be zero or less than zero.", exception.getMessage());
	}

	@Test // checking with less than zero
	public void testIdWithLessThanZero() {

		Exception exception = assertThrows(IllegalArgumentException.class, () -> {
			UserValidator.idValidate(-1);
		});

		assertEquals("Invalid id. Id cannot be zero or less than zero.", exception.getMessage());

	}

	@Test // checking the id is not more than 3 characters
	public void testIdWithMoreThanThree() {
		Exception exception = assertThrows(IllegalArgumentException.class, () -> {
			UserValidator.idValidate(1000);
		});

		assertEquals("Invalid id. Id must within 3 digit number.", exception.getMessage());
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
