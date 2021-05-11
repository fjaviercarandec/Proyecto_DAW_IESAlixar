package org.jcarande.proyetoDAW.controllers;

import org.jcarande.proyetoDAW.models.User;
import org.jcarande.proyetoDAW.services.UserServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controlador de usuarios.
 * @author javie
 *
 */
@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserServiceI userService;
	
	@PostMapping("/login")
	public User loginUser(@RequestBody User userLogin) {
		User user = userService.getByPasswordAndEmail(userLogin.getPassword(), userLogin.getEmail());
		
		if (user != null && user.getPassword().equals(userLogin.getPassword()) && user.getEmail().equals(userLogin.getEmail())) {
			return user;
		}
		
		return new User();
	}
	
	@PostMapping("/register")
	public User registerUser(@RequestBody User userRegister) {
		User user = userService.getByNameAndEmail(userRegister.getName(), userRegister.getEmail());
		
		if (user == null) {
			if(userRegister.getAdmin() == null && userRegister.getActive() == null) {
				userRegister.setAdmin(Boolean.FALSE);
				userRegister.setActive(Boolean.FALSE);
			}
			userService.addUser(userRegister);
			return userRegister;
		}
		
		return null;
	}

}
