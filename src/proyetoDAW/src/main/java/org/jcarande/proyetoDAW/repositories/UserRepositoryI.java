package org.jcarande.proyetoDAW.repositories;

import org.jcarande.proyetoDAW.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepositoryI extends JpaRepository<User, Long>{
	
	/**
	 * Obtiene un usuario por su Id
	 * @param idUser
	 * @return User
	 */
	public User findByIdUser(final long idUser);
	
	/**
	 * Obtiene un usuario por password y email
	 * @param password
	 * @param email
	 * @return User
	 */
	public User findByPasswordAndEmail(final String password, final String email);
	
	/**
	 * Obtiene un usuario por nombre y email
	 * @param name
	 * @param email
	 * @return User
	 */
	public User findByNameAndEmail(final String name, final String email);
}
