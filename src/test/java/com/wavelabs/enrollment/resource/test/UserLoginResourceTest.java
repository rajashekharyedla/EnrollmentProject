package com.wavelabs.enrollment.resource.test;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;

import com.wavelabs.enrollment.builder.DataBuilder;
import com.wavelabs.enrollment.entity.User;
import com.wavelabs.enrollment.repository.UserRepository;
import com.wavelabs.enrollment.resource.UserLoginResource;

@RunWith(MockitoJUnitRunner.class)
public class UserLoginResourceTest {

	@InjectMocks
	UserLoginResource userLoginResource;
	@Mock
	UserRepository userRepo;
	@Mock
	User user;

	@Test
	public void testLoginValidation() {
		when(userRepo.findByEmailAndPassword(anyString(), anyString())).thenReturn(DataBuilder.getUser());
		ResponseEntity en = userLoginResource.credentials("fds", "sddddd");
		Assert.assertEquals(200, en.getStatusCodeValue());

	}

	@Test
	public void testLoginValidationFail() {
		when(userRepo.findByEmailAndPassword(anyString(), anyString())).thenReturn(null);
		ResponseEntity en = userLoginResource.credentials("fds", "sddddd");
		Assert.assertEquals(401, en.getStatusCodeValue());

	}

}
