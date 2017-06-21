package com.wavelabs.enrollment.builder;

import com.wavelabs.enrollment.entity.Address;
import com.wavelabs.enrollment.entity.AutherizationTokens;
import com.wavelabs.enrollment.entity.Gender;
import com.wavelabs.enrollment.entity.LoginType;
import com.wavelabs.enrollment.entity.Status;
import com.wavelabs.enrollment.entity.User;

public class DataBuilder {

	public static AutherizationTokens getTokens() {

		AutherizationTokens at = new AutherizationTokens();
		at.setId(55);
		at.setTokenId("132457852145785");
		return at;

	}

	public static User getUser() {
		User user = new User();
		user.setStatus(null);
		user.setId(1);
		user.setFirstName("rajashekhar");
		user.setLastName("reddy");
		user.setEmail("shekhar@gmail.com");
		user.setPassword("1234aadd");
		user.setExperience(2);
		user.setHighestQualification("Btech");
		user.setMobile("8500000000");
		user.setGender(Gender.MALE);
		user.setIntrestedAreas("politics");
		user.setOthers("politics");
		user.setFatherName("nana");
		user.setMotherName("amma");
		user.setLoginType(LoginType.NORMALUSER);
		user.setAddress(getAddress());
		return user;

	}

	public static User getUser1() {
		User user = new User();
		user.setStatus(Status.ONE);
		user.setId(1);
		user.setFirstName("rajashekhar");
		user.setLastName("reddy");
		user.setEmail("shekhar@gmail.com");
		user.setPassword("1234aadd");
		user.setExperience(2);
		user.setHighestQualification("Btech");
		user.setMobile("8500000000");
		user.setGender(Gender.MALE);
		user.setIntrestedAreas("politics");
		user.setOthers("politics");
		user.setFatherName("nana");
		user.setMotherName("amma");
		user.setLoginType(LoginType.NORMALUSER);
		user.setAddress(getAddress());
		return user;

	}

	public static Address getAddress() {
		Address address = new Address();
		address.setId(22);
		address.setCity("karimnagar");
		address.setStreet("ramnagar");
		address.setZipCode("500001");
		address.setState("telangana");
		address.setLatitude("17.0225514");
		address.setLongitude("22.01427584");
		return address;

	}
}
