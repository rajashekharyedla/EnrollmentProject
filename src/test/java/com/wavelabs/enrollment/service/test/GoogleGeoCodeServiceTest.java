package com.wavelabs.enrollment.service.test;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import com.wavelabs.enrollment.builder.DataBuilder;
import com.wavelabs.enrollment.entity.User;
import com.wavelabs.enrollment.service.GoogleGeoCode;


@RunWith(MockitoJUnitRunner.class)
public class GoogleGeoCodeServiceTest {

	@InjectMocks
	GoogleGeoCode googleGeoCode;

	@Test
	public void testLatitudeAndLongitude() {
		String zipCode = DataBuilder.getAddress().getZipCode();
		String str[] = { "552.25", "85222" };
//		Assert.assertEquals(str, googleGeoCode.getLatitudeLongitude(zipCode));
//		when(googleGeoCode.getLatitudeLongitude(anyString()).thenReturn();
		}

}
