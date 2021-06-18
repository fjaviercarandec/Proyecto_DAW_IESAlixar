package org.jcarande.proyetoDAW.repositories;

import java.util.List;

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
	public List<User> findByIdUser(final long idUser);
	
	/**
	 * 
	 * @param name
	 * @return List<User>
	 */
	public List<User> findByName(final String name);
	
	/**
	 * 
	 * @param surname
	 * @return List<User>
	 */
	public List<User> findBySurnames(final String surnames);
	
	/**
	 * 
	 * @param active
	 * @return List<User>
	 */
	public List<User> findByActive(final Boolean active);
	
	/**
	 * 
	 * @param name
	 * @param surnames
	 * @return List<User>
	 */
	public List<User> findByNameAndSurnames(final String name, final String surnames);
	
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
