package com.wavelabs.enrollment.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Component;

import com.wavelabs.enrollment.entity.Status;
import com.wavelabs.enrollment.entity.User;
import com.wavelabs.enrollment.repository.AddressRepository;
import com.wavelabs.enrollment.repository.UserRepository;

@Component
public class UserFlowService {
	@Autowired
	UserRepository userrepo;
	@Autowired
	AddressRepository addressrepo;
	@Autowired
	AddressSource addresssource;

	public String normaluser(User user) {
		Logger log = Logger.getRootLogger();
		boolean flag = true;
		if (user.getStatus() == null) {
			user.setStatus(Status.ONE);
			try {
				userrepo.save(user);
				flag = false;
			} catch (DuplicateKeyException e) {
				log.info("Email already exist");
			} catch (Exception e) {
				log.info("Something went wrong! please try again");
			}

		} else if (user.getStatus() == Status.ONE) {
			user.setStatus(Status.TWO);
		} else if (user.getStatus() == Status.TWO) {
			user.setStatus(Status.THREE);
		} else if (user.getStatus() == Status.THREE) {
			user.setStatus(Status.FOUR);
		} else if (user.getStatus() == Status.FOUR) {
			user.setStatus(Status.COMPLETED);
			addresssource.persistAddress(user);

		} else if (user.getStatus() == Status.COMPLETED) {
			return "welcome";
		}
		if (flag) {
			userrepo.save(user);
		}
		return "registeredsucessfully";

	}
}
