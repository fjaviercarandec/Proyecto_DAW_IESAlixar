package org.jcarande.proyetoDAW.services;

import java.util.List;

import org.jcarande.proyetoDAW.models.Product;
import org.jcarande.proyetoDAW.repositories.ProductRepositoryI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Servicio: gestion productos
 * @author javie
 *
 */
@Service
public class ProductServiceImpl implements ProductServiceI {
	
	@Autowired
	private ProductRepositoryI productRepository;

	@Override
	public void addProduct(Product product) {
		productRepository.save(product);
	}

	@Override
	public void updateProduct(Product product) {
		productRepository.save(product);
	}
	
	@Override
	public void deleteProduct(Long idProduct) {
		productRepository.deleteById(idProduct);
	}

	@Override
	public List<Product> getAll() {
		return productRepository.findAll();
	}

	@Override
	public List<Product> getByIdProduct(long idProduct) {
		return productRepository.findByIdProduct(idProduct);
	}

	@Override
	public List<Product> getByName(String name) {
		return productRepository.findByName(name);
	}

	@Override
	public List<Product> getByColor(String color) {
		return productRepository.findByColor(color);
	}

	@Override
	public List<Product> getByNameAndColor(String name, String color) {
		return productRepository.findByNameAndColor(name, color);
	}

}
