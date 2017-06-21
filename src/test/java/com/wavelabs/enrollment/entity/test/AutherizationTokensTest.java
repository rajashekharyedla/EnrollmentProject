package com.wavelabs.enrollment.entity.test;

import org.junit.Assert;
import org.junit.Test;

import com.wavelabs.enrollment.entity.AutherizationTokens;

public class AutherizationTokensTest {
	
	 AutherizationTokens at= new AutherizationTokens();
	
	@Test
	public void getId(){
		at.setId(55);
		Assert.assertEquals(55, at.getId());
	}
	@Test
	public void getToken(){
		at.setTokenId("32014578521475");
		Assert.assertEquals("32014578521475", at.getTokenId());
	}
	

}
