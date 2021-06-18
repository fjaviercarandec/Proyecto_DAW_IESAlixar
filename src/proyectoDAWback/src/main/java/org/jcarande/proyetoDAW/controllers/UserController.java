package org.jcarande.proyetoDAW.controllers;

import java.util.ArrayList;
import java.util.List;

import org.jcarande.proyetoDAW.dtos.UserRecoveryDto;
import org.jcarande.proyetoDAW.models.User;
import org.jcarande.proyetoDAW.services.UserServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
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
@CrossOrigin(origins = "*", allowedHeaders = "*", exposedHeaders = "Authorization")
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
	
	@PostMapping("/getUser")
	public List<User> getUser(@RequestBody UserRecoveryDto userRecoveryDto) {
		List<User> aux = new ArrayList<User>();
		
		if(userRecoveryDto.getId() != null) {
			aux = userService.getByIdUser(userRecoveryDto.getId());
		} else {
			if(!ObjectUtils.isEmpty(userRecoveryDto.getName())) {
				if(!ObjectUtils.isEmpty(userRecoveryDto.getSurname())) {
					aux = userService.getByNameAndSurnames(userRecoveryDto.getName(), userRecoveryDto.getSurname());
				} else {
					aux = userService.getByName(userRecoveryDto.getName());
				}
			} else {
				aux = userService.getBySurnames(userRecoveryDto.getSurname());
			}
		}

		
		if(aux.isEmpty()) {
			return null;
		} else {
			return aux;
		}
	
	}
	
	@GetMapping("/noActiveUsers")
	public List<User> getNoActiveUsers() {
		return userService.getByActive(Boolean.FALSE);
		
	}
	
	@PostMapping("/activateUser")
	public Boolean updateInactiveUser(@RequestBody User user) {
		Boolean aux;
		List<User> u1 = userService.getByIdUser(user.getIdUser());
		
		try {
			u1.get(0).setActive(Boolean.TRUE);
			userService.updateUser(u1.get(0));
			aux = Boolean.TRUE;
		} catch (Exception e) {
			aux = Boolean.FALSE;
		}
		
		return aux;
		
	}

}
