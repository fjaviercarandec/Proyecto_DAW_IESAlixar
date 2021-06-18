package org.jcarande.proyetoDAW.repositories;

import java.sql.Timestamp;
import java.util.List;

import org.jcarande.proyetoDAW.models.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PurchaseRepositoryI extends JpaRepository<Purchase, Long>{
	
	/**
	 * Obtienes una compra por Id
	 * @param idPurchase
	 * @return List<Purchase>
	 */
	public List<Purchase> findByIdPurchase(final long idPurchase);
	
	/**
	 * 
	 * @param purchaseDate
	 * @return List<Purchase>
	 */
	public List<Purchase> findByPurchaseDate(final Timestamp purchaseDate);

}
