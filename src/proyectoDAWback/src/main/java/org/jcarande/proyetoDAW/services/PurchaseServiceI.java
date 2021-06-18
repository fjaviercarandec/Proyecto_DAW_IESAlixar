package org.jcarande.proyetoDAW.services;

import java.sql.Timestamp;
import java.util.List;

import org.jcarande.proyetoDAW.models.Purchase;

public interface PurchaseServiceI {
	
	public void addPurchase(final Purchase purchase);
	
	public void updatePurchase(final Purchase purchase);
	
	public List<Purchase> getAll();
	
	public List<Purchase> getByIdPurchase(final long idPurchase);
	
	public List<Purchase> getByPurchaseDate(final Timestamp purchaseDate);

}
