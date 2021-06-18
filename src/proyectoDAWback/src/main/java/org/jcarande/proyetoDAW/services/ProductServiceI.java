package org.jcarande.proyetoDAW.services;

import java.util.List;

import org.jcarande.proyetoDAW.models.Product;

public interface ProductServiceI {
	
	public void addProduct(final Product product);
	
	public void updateProduct(final Product product);
	
	public void deleteProduct(final Long idProduct);
	
	public List<Product> getAll();
	
	public List<Product> getByIdProduct(final long idProduct);
	
	public List<Product> getByName(final String name);
	
	public List<Product> getByColor(final String color);
	
	public List<Product> getByNameAndColor(final String name, final String color);

}
