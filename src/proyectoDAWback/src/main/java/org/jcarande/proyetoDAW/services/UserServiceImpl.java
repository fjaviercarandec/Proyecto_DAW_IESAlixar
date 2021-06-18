package org.jcarande.proyetoDAW.services;

import java.util.List;

import org.jcarande.proyetoDAW.models.User;
import org.jcarande.proyetoDAW.repositories.UserRepositoryI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Servicio: gestion usuarios
 * @author javie
 *
 */
@Service
public class UserServiceImpl implements UserServiceI{
	
	@Autowired
	private UserRepositoryI userRepository;
	
	@Override
	public void addUser(User user) {
		userRepository.save(user);
	}

	@Override
	public void updateUser(User user) {
		userRepository.save(user);
	}

	@Override
	public List<User> getAll() {
		return userRepository.findAll();
	}

	@Override
	public List<User> getByIdUser(long idUser) {
		return userRepository.findByIdUser(idUser);
	}
	
	@Override
	public List<User> getByName(String name) {
		return userRepository.findByName(name);
	}

	@Override
	public List<User> getBySurnames(String surnames) {
		return userRepository.findBySurnames(surnames);
	}
	
	@Override
	public List<User> getByActive(Boolean active) {
		return userRepository.findByActive(active);
	}
	
	@Override
	public List<User> getByNameAndSurnames(String name, String surnames) {
		return userRepository.findByNameAndSurnames(name, surnames);
	}

	@Override
	public User getByPasswordAndEmail(String password, String email) {
		return userRepository.findByPasswordAndEmail(password, email);
	}
	
	@Override
	public User getByNameAndEmail(String name, String email) {
		return userRepository.findByNameAndEmail(name, email);
	}

	@Override
	public void removeByIdUser(long idUser) {
		userRepository.deleteById(idUser);
	}

}
