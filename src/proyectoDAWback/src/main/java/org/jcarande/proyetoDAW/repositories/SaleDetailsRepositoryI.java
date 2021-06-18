package org.jcarande.proyetoDAW.repositories;

import java.util.List;

import org.jcarande.proyetoDAW.models.SaleDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SaleDetailsRepositoryI extends JpaRepository<SaleDetails, Long>{
	
	/**
	 * Obtiene un detalle de venta por su Id
	 * @param idSaleDetails
	 * @return List<SaleDetails>
	 */
	public List<SaleDetails> findByIdSaleDetails(final long idSaleDetails);

}
