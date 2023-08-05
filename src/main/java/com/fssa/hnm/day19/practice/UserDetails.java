package com.fssa.hnm.day19.practice;
//blueprint for user details
public class UserDetails {

	//userDetails holds 
	//attributes of the user
	//that are declared below with data types

		int id;
		String name;
		String password;
		String email;

	//for each attribute there are two methods one will set the values to the attribute
	//another one method it will return the value to the attribute

	//return value to the id attribute
		public int getId() {
			return id;
		}

	//set the value to the id attribute
		public void setId(int id) {
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
