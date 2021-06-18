package org.jcarande.proyetoDAW.services;

import java.util.List;

import org.jcarande.proyetoDAW.models.Client;

public interface ClientServiceI {
	
	public void addClient(final Client client);
	
	public void updateClient(final Client client);
	
	public void deleteClient(final Long idClient);
	
	public List<Client> getAll();
	
	public List<Client> getByIdClient(final long idClient);
	
	public List<Client> getByName(final String name);
	
	public List<Client> getBySurname(final String surname);
	
	public List<Client> getByNameAndSurname(final String name, final String surname);
	
	public void addSaleToClient(final Client client);
}
