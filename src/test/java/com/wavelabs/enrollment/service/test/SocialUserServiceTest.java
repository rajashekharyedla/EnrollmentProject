package com.wavelabs.enrollment.service.test;

import static org.junit.Assert.assertEquals;
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
import com.wavelabs.enrollment.entity.AutherizationTokens;
import com.wavelabs.enrollment.repository.AutherizationTokensRepository;
import com.wavelabs.enrollment.repository.UserRepository;
import com.wavelabs.enrollment.service.SocialUserService;

@RunWith(MockitoJUnitRunner.class)
public class SocialUserServiceTest {

	@Mock
	AutherizationTokens authorizationToken;
	@Mock
	AutherizationTokensRepository autrepo;
	@InjectMocks
	SocialUserService sus;
	@Mock
	UserRepository userrepo;

	@Test
	public void testPersistSocialUser() {
		when(autrepo.save(any(AutherizationTokens.class))).thenReturn(mock(AutherizationTokens.class));
		sus.persistSocialUser(DataBuilder.getUser(), "52588555555");
		verify(autrepo, times(1)).save(any(AutherizationTokens.class));
	}

	@Test
	public void testPersistSocialUserToken() {

		when(autrepo.save(any(AutherizationTokens.class))).thenReturn(mock(AutherizationTokens.class));
		sus.persistSocialUser(DataBuilder.getUser(), null);
		verify(autrepo, times(1)).save(any(AutherizationTokens.class));
	}
	@Test
	public void testPersistSocialUser1() {
		when(autrepo.findByTokenId(anyString())).thenReturn(null);
//		sus.persistSocialUser(DataBuilder.getUser(), "52588555555");
//		verify(autrepo, times(1)).save(any(AutherizationTokens.class));
		assertEquals(null, autrepo.findByTokenId(anyString()));
	}

}
