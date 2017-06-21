package com.wavelabs.enrollment.entity.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.wavelabs.enrollment.entity.Address;
import com.wavelabs.enrollment.entity.AutherizationTokens;
import com.wavelabs.enrollment.entity.Gender;
import com.wavelabs.enrollment.entity.LoginType;
import com.wavelabs.enrollment.entity.Status;
import com.wavelabs.enrollment.entity.User;

public class UserTest {

	User user = new User();
	Address address = new Address();
	AutherizationTokens at = new AutherizationTokens();

	@Before
	public void testTokens() {
		at.setId(0);
		// at.setId(5);
		at.setTokenId("52587452155255");
	}

	@Before
	public void testGetAddress() {
		address.setCity("hyderabad");
		address.setId(5);
		address.setLatitude("17.0025885");
		address.setLongitude("14.0255852");
		address.setZipCode("500081");
		address.setStreet("hyderabad");

	}

	@Test 
	public void testGetId() {
		user.setId(55);
		Assert.assertEquals(55, user.getId());
	}

	@Test
	public void testGetFirstName() {
		user.setFirstName("rajashekhar");
		Assert.assertEquals("rajashekhar", user.getFirstName());
	}

	@Test
	public void testGetLastName() {
		user.setLastName("reddy");
		Assert.assertEquals("reddy", user.getLastName());
	}

	@Test
	public void testGetEmail() {
		user.setEmail("shekhar.yedla@gmail.com");
		Assert.assertEquals("shekhar.yedla@gmail.com", user.getEmail());
	}

	@Test
	public void testGetPassword() {
		user.setPassword("password@123");
		Assert.assertEquals("password@123", user.getPassword());
	}

	@Test
	public void testGetSocialPassword() {
		user.setPassword(null);
		Assert.assertEquals(null, user.getPassword());
	}

	@Test
	public void testGetMobileNumber() {
		user.setMobile("8500000000");
		Assert.assertEquals("8500000000", user.getMobile());
	}

	@Test
	public void testGetGender() {
		user.setGender(Gender.MALE);
		Assert.assertEquals(Gender.MALE, user.getGender());
	}

	@Test
	public void testGetIntrestedAreas() {
		user.setIntrestedAreas("games");
		Assert.assertEquals("games", user.getIntrestedAreas());
	}

	@Test
	public void testGetOthers() {
		user.setOthers("politics");
		Assert.assertEquals("politics", user.getOthers());
	}

	@Test
	public void testGetExperience() {
		user.setExperience(5);
		Assert.assertEquals(new Integer(5), user.getExperience());
	}

	@Test
	public void testGetMotherName() {
		user.setMotherName("MOM");
		Assert.assertEquals("MOM", user.getMotherName());
	}

	@Test
	public void testGetFatherName() {
		user.setFatherName("DAD");
		Assert.assertEquals("DAD", user.getFatherName());
	}
	@Test
	public void testAddress() {

		user.setAddress(address);
		Assert.assertEquals(address, user.getAddress());
	}

	@Test
	public void testGetHighestQualification() {
		user.setHighestQualification("MBA");
		Assert.assertEquals("MBA", user.getHighestQualification());
	}

	@Test
	public void testGetStatus() {
		user.setStatus(Status.COMPLETED);
		Assert.assertEquals(Status.COMPLETED, user.getStatus());
	}

	@Test
	public void testGetLoginType() {
		user.setLoginType(LoginType.FACEBOOK);
		Assert.assertEquals(LoginType.FACEBOOK, user.getLoginType());
	}

	@Test
	public void testGetToken() {
		user.setTokens(at);
		Assert.assertEquals(at, user.getTokens());
	}
}
