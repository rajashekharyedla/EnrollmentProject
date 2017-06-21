package com.wavelabs.enrollment.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wavelabs.enrollment.entity.LoginType;
import com.wavelabs.enrollment.entity.User;
import com.wavelabs.enrollment.repository.UserRepository;
import com.wavelabs.enrollment.service.UserFlowService;

@RestController
@Component
public class UserResource {

	@Autowired
	UserRepository userrepo;
	@Autowired
	UserFlowService userFlow;

	@RequestMapping(value = "/usercreate", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public String normaluser(@RequestBody User user) {
		user.setLoginType(LoginType.NORMALUSER);
		return userFlow.normaluser(user);
	}

	@RequestMapping(value = "/byemail", method = RequestMethod.POST)
	public ResponseEntity<?> findByEmail(@RequestParam("email") String email) {
		User member = userrepo.findByEmail(email);
		if (member != null) {
			return ResponseEntity.status(HttpStatus.OK).body(member);
		}
		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("User doesnot exists");
	}

	/**
	 * This is getting all the employees available in the database.
	 * 
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/all")
	public List<User> getAll() {
		return (List<User>) userrepo.findAll();
	}

}
