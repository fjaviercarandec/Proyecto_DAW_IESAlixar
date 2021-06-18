package org.jcarande.proyetoDAW.services;

import java.sql.Timestamp;
import java.util.List;

import org.jcarande.proyetoDAW.models.Sale;

public interface SaleServiceI {
	
	public void addSale(final Sale sale);
	
	public void updateSale(final Sale sale);
	
	public List<Sale> getAll();
	
	public List<Sale> getByIdSale(final long idSale);
	
	public List<Sale> getBySaleDateBetween(final Timestamp saleDateStart, final Timestamp saleDateEnd);

}
