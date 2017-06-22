/*package com.wavelabs.enrollment.test;

import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import com.wavelabs.enrollment.EnrollmentJpaApplication;

@SpringBootTest
 @RunWith(SpringRunner.class)
// @RunWith(MockitoJUnitRunner.class)
//@RunWith(PowerMockRunner.class)
@PrepareForTest(SpringApplication.class)
public class EnrollmentJpaApplicationTest {

	@Test
	public void mainTest() {

		PowerMockito.mockStatic(SpringApplication.class);
		when(SpringApplication.run(eq(EnrollmentJpaApplication.class), new String[] {}))
				.thenReturn(mock(ConfigurableApplicationContext.class));
	}
	@Test
	 public void contextLoads() {
	 }

}
*/