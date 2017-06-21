package com.wavelabs.enrollment.entity.test;

import org.junit.Assert;
import org.junit.Test;

import com.wavelabs.enrollment.entity.Address;

public class AddressTest {

	Address address= new Address();

	@Test
	public void getCity() {
		address.setCity("Hyderabad");
		Assert.assertEquals("Hyderabad", address.getCity());
	}

	@Test
	public void getid() {
		address.setId(55);
		Assert.assertEquals(55, address.getId());
	}

	@Test
	public void getStreet() {
		address.setStreet("hyderabad");
		Assert.assertEquals("hyderabad", address.getStreet());
	}
	@Test
	public void getState() {
		address.setState("telangana");;
		Assert.assertEquals("telangana", address.getState());
	}
	@Test
	public void getZipCode() {
		address.setZipCode("500081");
		Assert.assertEquals("500081", address.getZipCode());
	}
	@Test
	public void getLatitude() {
		address.setLatitude("14.025148555");
		Assert.assertEquals("14.025148555", address.getLatitude());
	}
	@Test
	public void getLongitude() {
		address.setLongitude("14.025148555");
		Assert.assertEquals("14.025148555", address.getLongitude());
	}
}
