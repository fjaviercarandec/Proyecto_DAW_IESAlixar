package org.jcarande.proyetoDAW.services;

import java.util.List;

import org.jcarande.proyetoDAW.models.User;

public interface UserServiceI {
	
	public void addUser(final User user);
	
	public void updateUser(final User user);
		
	public List<User> getAll();
	
	public List<User> getByIdUser(final long idUser);
	
	public List<User> getByName(final String name);
	
	public List<User> getBySurnames(final String surnames);
	
	public List<User> getByNameAndSurnames(final String name, final String surnames);
	
	public List<User> getByActive(final Boolean active);
	
	public User getByPasswordAndEmail(final String password, final String email);
	
	public User getByNameAndEmail(final String name, final String email);
	
	public void removeByIdUser(final long idUser);
}
