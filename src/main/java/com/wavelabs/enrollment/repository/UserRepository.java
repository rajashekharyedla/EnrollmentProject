package com.wavelabs.enrollment.repository;

import org.springframework.data.repository.CrudRepository;

import com.wavelabs.enrollment.entity.User;

public interface UserRepository extends CrudRepository<User, Integer> {

	/**
	 * For checking the user validation with the email and password.
	 * 
	 * @param email
	 * @param password
	 * @return
	 */
	User findByEmailAndPassword(String email, String password);

	/**
	 * 
	 * @param email
	 * @return
	 */
	User findByEmail(String email);

}
