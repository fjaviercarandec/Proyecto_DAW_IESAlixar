package org.jcarande.proyetoDAW.repositories;

import java.util.List;

import org.jcarande.proyetoDAW.models.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepositoryI extends JpaRepository<Client, Long>{
	
	/**
	 * Obtiene una lista de clientes por su Id
	 * @param idClient
	 * @return List<Client>
	 */
	public List<Client> findByIdClient(final long idClient);
	
	/**
	 * Obtiene una lista de clientes por su nombre
	 * @param name
	 * @return List<Client>
	 */
	public List<Client> findByName(final String name);
	
	/**
	 * Obtiene una lista de clientes por su apellido
	 * @param surname
	 * @return List<Client>
	 */
	public List<Client> findBySurname(final String surname);
	
	/**
	 * Obtiene una lista de clientes por su nombre y apellido/s
	 * @param name
	 * @param surname
	 * @return List<Client>
	 */
	public List<Client> findByNameAndSurname(final String name, final String surname);
	
}
