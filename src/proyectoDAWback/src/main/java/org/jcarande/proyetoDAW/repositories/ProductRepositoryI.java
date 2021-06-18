package org.jcarande.proyetoDAW.repositories;

import java.util.List;

import org.jcarande.proyetoDAW.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepositoryI extends JpaRepository<Product, Long>{
	
	/**
	 * Obtener un producto por su Id
	 * @param idProduct
	 * @return Product
	 */
	public List<Product> findByIdProduct(final long idProduct);
	
	/**
	 * 
	 * @param name
	 * @return List<Product>
	 */
	public List<Product> findByName(final String name);
	
	/**
	 * 
	 * @param color
	 * @return List<Product>
	 */
	public List<Product> findByColor(final String color);
	
	/**
	 * 
	 * @param name
	 * @param color
	 * @return List<Product>
	 */
	public List<Product> findByNameAndColor(final String name, final String color);
	
}
