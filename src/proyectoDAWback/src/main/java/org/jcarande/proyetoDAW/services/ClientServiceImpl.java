package org.jcarande.proyetoDAW.services;

import java.util.List;

import org.jcarande.proyetoDAW.models.Client;
import org.jcarande.proyetoDAW.repositories.ClientRepositoryI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Servicio: gestion clientes
 * @author javie
 *
 */
@Service
public class ClientServiceImpl implements ClientServiceI{

	@Autowired
	private ClientRepositoryI clientRepository;
	
	@Override
	public void addClient(Client client) {
		clientRepository.save(client);
	}

	@Override
	public void updateClient(Client client) {
		clientRepository.save(client);
	}
	
	@Override
	public void deleteClient(Long idClient) {
		clientRepository.deleteById(idClient);
	}

	@Override
	public List<Client> getAll() {
		return clientRepository.findAll();
	}

	@Override
	public List<Client> getByIdClient(long idClient) {
		return clientRepository.findByIdClient(idClient);
	}
	
	@Override
	public List<Client> getByName(String name) {
		return clientRepository.findByName(name);
	}

	@Override
	public List<Client> getBySurname(String surname) {
		return clientRepository.findBySurname(surname);
	}

	@Override
	public List<Client> getByNameAndSurname(String name, String surname) {
		return clientRepository.findByNameAndSurname(name, surname);
	}

	@Override
	public void addSaleToClient(Client client) {
		clientRepository.save(client);
	}

}
