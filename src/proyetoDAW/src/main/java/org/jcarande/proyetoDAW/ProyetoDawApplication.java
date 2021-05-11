package org.jcarande.proyetoDAW;

import org.jcarande.proyetoDAW.models.User;
import org.jcarande.proyetoDAW.services.UserServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProyetoDawApplication implements CommandLineRunner {
	
	@Autowired
	private UserServiceI userService;

	public static void main(String[] args) {
		SpringApplication.run(ProyetoDawApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		User u1 = new User();
		u1.setName("Javier");
		u1.setSurnames("Carande");
		u1.setPassword("pass123");
		u1.setEmail("javier@correo.es");
		u1.setAdmin(Boolean.TRUE);
		u1.setActive(Boolean.TRUE);
		
		userService.addUser(u1);
		
	}

}
