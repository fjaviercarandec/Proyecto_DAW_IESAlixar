package org.jcarande.proyetoDAW.repositories;

import org.jcarande.proyetoDAW.models.PurchaseDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PurchaseDetailRepositoryI extends JpaRepository<PurchaseDetail, Long>{
	
	/**
	 * Obtiene un detalle de compra por su Id
	 * @param idPurchaseDetail
	 * @return PurchaseDetail
	 */
	public PurchaseDetail findByIdPurchaseDetail(final long idPurchaseDetail);

}
