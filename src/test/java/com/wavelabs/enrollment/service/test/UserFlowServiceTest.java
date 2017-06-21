package com.wavelabs.enrollment.service.test;

import static org.mockito.Matchers.any;
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
import com.wavelabs.enrollment.entity.Status;
import com.wavelabs.enrollment.entity.User;
import com.wavelabs.enrollment.repository.AddressRepository;
import com.wavelabs.enrollment.repository.UserRepository;
import com.wavelabs.enrollment.service.AddressSource;
import com.wavelabs.enrollment.service.UserFlowService;

@RunWith(MockitoJUnitRunner.class)
public class UserFlowServiceTest {

	@Mock
	UserRepository userRepo1;
	@Mock
	AddressRepository addressRepo1;
	/*
	 * @Mock User user1;
	 */
	@Mock
	AddressSource addressSource1;
	@InjectMocks
	UserFlowService userFlowService1;

	@Test
	public void testNormalUserStatusNull() {

		User user22 = DataBuilder.getUser();
		user22.setStatus(Status.ONE);
		when(userRepo1.save(any(User.class))).thenReturn(mock(User.class));
		userFlowService1.normaluser(DataBuilder.getUser());
		verify(userRepo1, times(1)).save(any(User.class));
	}

	@Test
	public void testNormalUserStatusOne() {
		User user22 = DataBuilder.getUser1();
		user22.setStatus(Status.TWO);
		when(userRepo1.save(any(User.class))).thenReturn(mock(User.class));
		userFlowService1.normaluser(DataBuilder.getUser());
		verify(userRepo1, times(1)).save(any(User.class));

	}

	@Test
	public void testNormalUserStatusTwo() {
		User user22 = DataBuilder.getUser();
		user22.setStatus(Status.THREE);
		when(userRepo1.save(any(User.class))).thenReturn(mock(User.class));
		userFlowService1.normaluser(DataBuilder.getUser());
		verify(userRepo1, times(1)).save(any(User.class));

	}

	@Test
	public void testNormalUserStatusThree() {
		User user22 = DataBuilder.getUser();
		user22.setStatus(Status.FOUR);
		when(userRepo1.save(any(User.class))).thenReturn(mock(User.class));
		userFlowService1.normaluser(DataBuilder.getUser());
		verify(userRepo1, times(1)).save(any(User.class));

	}

	@Test
	public void testNormalUserStatusFour() {
		User user22 = DataBuilder.getUser();
		user22.setStatus(Status.COMPLETED);
		when(userRepo1.save(any(User.class))).thenReturn(mock(User.class));
		userFlowService1.normaluser(DataBuilder.getUser());
		verify(userRepo1, times(1)).save(any(User.class));

	}

}
