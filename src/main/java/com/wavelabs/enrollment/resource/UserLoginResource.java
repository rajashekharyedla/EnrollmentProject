package com.wavelabs.enrollment.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wavelabs.enrollment.entity.User;
import com.wavelabs.enrollment.repository.UserRepository;

@RestController
@Component
public class UserLoginResource {
	@Autowired
	UserRepository userrepo;

	@RequestMapping(value = "/userlogin", method = RequestMethod.POST)

	public ResponseEntity<?> credentials(@RequestParam("email") String email,
			@RequestParam("password") String password) {
		User member = userrepo.findByEmailAndPassword(email, password);
		if (member != null) {
			return ResponseEntity.status(HttpStatus.OK).body(member);
		} else {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
					.body("Invalid details Please check your Email and Password");
		}
	}
}
