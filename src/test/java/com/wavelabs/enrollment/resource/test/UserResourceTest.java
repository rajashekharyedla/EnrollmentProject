package com.wavelabs.enrollment.resource.test;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;

import com.wavelabs.enrollment.builder.DataBuilder;
import com.wavelabs.enrollment.entity.Status;
import com.wavelabs.enrollment.entity.User;
import com.wavelabs.enrollment.repository.UserRepository;
import com.wavelabs.enrollment.resource.UserResource;
import com.wavelabs.enrollment.service.UserFlowService;

@RunWith(MockitoJUnitRunner.class)
public class UserResourceTest {
	@InjectMocks
	UserResource userResource;
	@Mock
	UserRepository userRepo;
	@Mock
	User user;
	@Mock
	UserFlowService userFlow;

	@Test
	public void testfindByEmail() {
		when(userRepo.findByEmail(anyString())).thenReturn(DataBuilder.getUser());
		ResponseEntity en = userResource.findByEmail("ddd@gmail.com");
		Assert.assertEquals(200, en.getStatusCodeValue());

	}

	@Test
	public void testfindByEmailFail() {
		when(userRepo.findByEmailAndPassword(anyString(), anyString())).thenReturn(null);
		ResponseEntity en = userResource.findByEmail("fds");
		Assert.assertEquals(401, en.getStatusCodeValue());

	}

	@Test
	public void testNormalUser() {

	}

	@Test
	public void testGetAllUsers() {

	}
}
