package com.wavelabs.enrollment.service.test;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.wavelabs.enrollment.builder.DataBuilder;
import com.wavelabs.enrollment.entity.Address;
import com.wavelabs.enrollment.repository.AddressRepository;
import com.wavelabs.enrollment.service.AddressSource;
import com.wavelabs.enrollment.service.GoogleGeoCode;

@RunWith(MockitoJUnitRunner.class)
public class AddressSourceTest {

	@InjectMocks
	private AddressSource test;

	@Mock
	private GoogleGeoCode code;

	@Mock
	private AddressRepository addressRepoTest;

	@Test
	public void testAddress() {

		String str[] = { "a", "b" };
		when(code.getLatitudeLongitude(anyString())).thenReturn(str);
		when(addressRepoTest.save(any(Address.class))).thenReturn(mock(Address.class));
		test.persistAddress(DataBuilder.getUser());
		verify(addressRepoTest, times(1)).save(any(Address.class));
	}

}
