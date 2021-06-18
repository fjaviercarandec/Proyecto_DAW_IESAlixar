package org.jcarande.proyetoDAW.repositories;

import org.jcarande.proyetoDAW.models.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SupplierRepositoryI extends JpaRepository<Supplier, Long>{
	
	/**
	 * Obtiene un proveedor por su Id
	 * @param idSupplier
	 * @return Supplier
	 */
	public Supplier findByIdSupplier(final long idSupplier);
	
	/**
	 * Obtiene un proveedor por el nombre de la compañia
	 * @param companyName
	 * @return Supplier
	 */
	public Supplier findByCompanyName(final long companyName);
}
