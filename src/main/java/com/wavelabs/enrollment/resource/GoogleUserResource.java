package com.wavelabs.enrollment.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wavelabs.enrollment.entity.LoginType;
import com.wavelabs.enrollment.entity.Status;
import com.wavelabs.enrollment.entity.User;
import com.wavelabs.enrollment.service.SocialUserService;

@RestController
@Component
public class GoogleUserResource {
	@Autowired
	SocialUserService socialUser;

	@RequestMapping(value = "/gmail/{id}", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)

	public void addGmailUser(@RequestBody User user, @PathVariable("id") String tokenid) {
		user.setLoginType(LoginType.GOOGLE);
		user.setStatus(Status.ONE);
		socialUser.persistSocialUser(user,tokenid);
	}

}
