package com.fssa.hnm.day20.solved;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestStudentValidator {

	@Test
	public void testValidate() {
		StudentObjSetGet student = getStudent();
		Assertions.assertTrue(StudentValidator.validate(student));
	}
	
	@Test
	public void testInvalidName() {
		StudentObjSetGet student = getStudent();
		try {
			student.name = "a";
			StudentValidator.validate(student);
		} catch (IllegalArgumentException ex) {
			Assertions.assertEquals("Name cannot be empty or null",
					ex.getMessage());
			
		}
	}

	public StudentObjSetGet getStudent() {
		StudentObjSetGet student = new StudentObjSetGet();
		student.name = "Apj";
		student.age = 20;
		student.roll = 1001;
		student.emailId = "apj@freshworks.com";
		return student;
	}
}
