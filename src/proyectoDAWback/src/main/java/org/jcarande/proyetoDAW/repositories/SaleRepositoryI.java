package org.jcarande.proyetoDAW.repositories;

import java.sql.Timestamp;
import java.util.List;

import org.jcarande.proyetoDAW.models.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SaleRepositoryI extends JpaRepository<Sale, Long>{
	
	/**
	 * Obtiene una venta por su Id
	 * @param idSale
	 * @return List<Sale>
	 */
	public List<Sale> findByIdSale(final long idSale);
	
	/**
	 * Obtiene una lista de ventas por fecha
	 * @param saleDate
	 * @return List<Sale>
	 */
	public List<Sale> findBySaleDateBetween(final Timestamp saleDateStart, final Timestamp saleDateEnd);

}
