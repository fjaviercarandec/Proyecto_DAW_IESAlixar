package org.jcarande.proyetoDAW.controllers;

import java.util.ArrayList;
import java.util.List;

import org.jcarande.proyetoDAW.dtos.ProductRecoveryDto;
import org.jcarande.proyetoDAW.models.Product;
import org.jcarande.proyetoDAW.services.ProductServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controlador de productos.
 * @author javie
 *
 */
@RestController
@RequestMapping("/product")
@CrossOrigin(origins = "*", allowedHeaders = "*", exposedHeaders = "Authorization")
public class ProductController {
	
	@Autowired
	private ProductServiceI productService;
	
	@PostMapping("/addProduct")
	public Boolean addProduct(@RequestBody Product product) {
		Boolean aux;
		
		try {
			productService.addProduct(product);
			aux = Boolean.TRUE;
		} catch(Exception e) {
			aux = Boolean.FALSE;
		}
		
		return aux;
	}
	
	@PostMapping("/updateProduct")
	public Boolean updateProduct(@RequestBody Product product) {
		Boolean aux;
		
		List<Product> p1 = productService.getByIdProduct(product.getIdProduct());
		if(!ObjectUtils.isEmpty(product.getName())) {
			p1.get(0).setName(product.getName());
		}
		
		if(p1.get(0).getQuantity() != product.getQuantity()) {
			p1.get(0).setQuantity(product.getQuantity());
		}
		
		if(!ObjectUtils.isEmpty(product.getSize())) {
			p1.get(0).setSize(product.getSize());
		}
		
		if(!ObjectUtils.isEmpty(product.getColor())) {
			p1.get(0).setColor(product.getColor());
		}
		
		try {
			productService.updateProduct(p1.get(0));
			aux = Boolean.TRUE;
		} catch(Exception e) {
			aux = Boolean.FALSE;
		}
		
		return aux;
	}

	
	@PostMapping("/deleteProduct")
	public Boolean deleteProduct(@RequestBody Product idProduct) {
		Boolean aux;
		
		try {
			productService.deleteProduct(idProduct.getIdProduct());
			aux = Boolean.TRUE;
		} catch (Exception e) {
			aux = Boolean.FALSE;
		}
		
		return aux;
	}
	
	@PostMapping("/searchProduct")
	public List<Product> getProduct(@RequestBody ProductRecoveryDto productRecovery) {
		List<Product> aux = new ArrayList<Product>();
		
		if(productRecovery.getIdProduct() != null) {
			aux = productService.getByIdProduct(productRecovery.getIdProduct());
		} else {
			if(!ObjectUtils.isEmpty(productRecovery.getName())) {
				if(!ObjectUtils.isEmpty(productRecovery.getColor())) {
					aux = productService.getByNameAndColor(productRecovery.getName(), productRecovery.getColor());
				} else {
					aux = productService.getByName(productRecovery.getName());
				}
			} else {
				aux = productService.getByColor(productRecovery.getColor());
			}
		}
		
		if(aux.isEmpty()) {
			return null;
		} else {
			return aux;
		}
	}

}
