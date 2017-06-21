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
import com.wavelabs.enrollment.repository.AutherizationTokensRepository;
import com.wavelabs.enrollment.repository.UserRepository;
import com.wavelabs.enrollment.service.SocialUserService;

@RestController
@Component
public class FacebookUserResource {

	@Autowired
	UserRepository userrepo;

	@Autowired
	AutherizationTokensRepository at;
	
	@Autowired
	SocialUserService socialUser;
	

	@RequestMapping(value = "/fb/{id}", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void addfbUser(@RequestBody User user, @PathVariable("id") String tokenid) {
		user.setLoginType(LoginType.FACEBOOK);
		user.setStatus(Status.ONE);
		socialUser.persistSocialUser(user,tokenid);
	}
}
