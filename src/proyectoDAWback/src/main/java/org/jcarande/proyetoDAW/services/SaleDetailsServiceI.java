package org.jcarande.proyetoDAW.services;

import java.util.List;

import org.jcarande.proyetoDAW.models.SaleDetails;

public interface SaleDetailsServiceI {
	
	public void addSaleDetails(final SaleDetails saleDetails);
	
	public void updateSaleDetails(final SaleDetails saleDetails);
	
	public List<SaleDetails> getAll();
	
	public List<SaleDetails> getByIdSaleDetails(final long idSaleDetails);

}
