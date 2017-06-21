package com.wavelabs.enrollment.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.wavelabs.enrollment.entity.AutherizationTokens;
import com.wavelabs.enrollment.entity.User;
import com.wavelabs.enrollment.repository.AutherizationTokensRepository;
import com.wavelabs.enrollment.repository.UserRepository;

@Component
public class SocialUserService {
	@Autowired
	UserRepository userrepo;

	@Autowired
	AutherizationTokensRepository authtokenrepo;

	public String persistSocialUser(User user, String tokenid) {
		AutherizationTokens token = new AutherizationTokens();
		authtokenrepo.findByTokenId(tokenid);
		if (authtokenrepo.findByTokenId(tokenid) != null) {
			return "WELCOME";

		} else {
			token.setTokenId(tokenid);
			authtokenrepo.save(token);
			user.setTokens(token);
			userrepo.save(user);
		}
		return "registered";

	}
}
