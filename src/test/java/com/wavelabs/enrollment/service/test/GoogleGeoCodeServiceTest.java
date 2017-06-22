package com.wavelabs.enrollment.service.test;


import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;
import com.wavelabs.enrollment.builder.DataBuilder;
import com.wavelabs.enrollment.service.GoogleGeoCode;

@RunWith(MockitoJUnitRunner.class)
public class GoogleGeoCodeServiceTest {

	@InjectMocks
	GoogleGeoCode googleGeoCode;

	@Test
	public void testLatitudeAndLongitude() {
		String zipCode = DataBuilder.getAddress().getZipCode();
		String str[] = { "17.3874364", "78.47217289999999" };
		Assert.assertEquals(str, googleGeoCode.getLatitudeLongitude(zipCode));
	}

}
