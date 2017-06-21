package com.wavelabs.enrollment.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.wavelabs.enrollment.entity.Address;
import com.wavelabs.enrollment.entity.User;
import com.wavelabs.enrollment.repository.AddressRepository;

@Component
public class AddressSource {
	static Logger logger = Logger.getLogger(AddressSource.class);

	@Autowired
	GoogleGeoCode googleGeoCode;
	@Autowired
	AddressRepository addressrepo;

	public Address persistAddress(User user) {
		Address address = user.getAddress();
		String zipcode = address.getZipCode();
		String[] result = googleGeoCode.getLatitudeLongitude(zipcode);
		address.setLatitude(result[0]);
		address.setLongitude(result[1]);
		addressrepo.save(address);
		return address;
	}

}
