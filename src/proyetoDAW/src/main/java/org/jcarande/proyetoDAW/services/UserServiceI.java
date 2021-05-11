package org.jcarande.proyetoDAW.services;

import java.util.List;

import org.jcarande.proyetoDAW.models.User;

public interface UserServiceI {
	
	public void addUser(final User user);
	
	public void updateUser(final User user);
		
	public List<User> getAll();
	
	public User getByIdUser(final long idUser);
	
	public User getByPasswordAndEmail(final String password, final String email);
	
	public User getByNameAndEmail(final String name, final String email);
	
	public void removeByIdUser(final long idUser);
}
