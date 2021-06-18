package org.jcarande.proyetoDAW.controllers;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.jcarande.proyetoDAW.dtos.ClientRecoveryDto;
import org.jcarande.proyetoDAW.dtos.SaleDetailsDto;
import org.jcarande.proyetoDAW.dtos.SaleDto;
import org.jcarande.proyetoDAW.dtos.SaleToClientDto;
import org.jcarande.proyetoDAW.models.Client;
import org.jcarande.proyetoDAW.models.Product;
import org.jcarande.proyetoDAW.models.Sale;
import org.jcarande.proyetoDAW.models.SaleDetails;
import org.jcarande.proyetoDAW.services.ClientServiceI;
import org.jcarande.proyetoDAW.services.ProductServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/client")
@CrossOrigin(origins = "*", allowedHeaders = "*", exposedHeaders = "Authorization")
public class ClientController {
	
	@Autowired
	private ClientServiceI clientService;
	
	@Autowired
	private ProductServiceI productService;
	
	@PostMapping("/getClient")
	public List<Client> getClient(@RequestBody ClientRecoveryDto clientRecoveryDto) {
		List<Client> aux = new ArrayList<Client>();
		if(clientRecoveryDto.getId() != null) {
			aux = clientService.getByIdClient(clientRecoveryDto.getId());
		} else {
			if(!ObjectUtils.isEmpty(clientRecoveryDto.getName())) {
				if(!ObjectUtils.isEmpty(clientRecoveryDto.getSurname())) {
					aux = clientService.getByNameAndSurname(clientRecoveryDto.getName(), clientRecoveryDto.getSurname());
				} else {
					aux = clientService.getByName(clientRecoveryDto.getName());
				}
			} else {
				aux = clientService.getBySurname(clientRecoveryDto.getSurname());
			}
		}
		
		if(aux.isEmpty()) {
			return null;
		} else {
			return aux;
		}
	}
	
	@PostMapping("/addSaleToClient")
	public Boolean addSaleToClient(@RequestBody SaleToClientDto saleToClientDto) {
		Boolean aux;
		List<Client> clients = clientService.getByIdClient(saleToClientDto.getIdClient());
		SaleDto sales = saleToClientDto.getSales();
				
		Date date = new Date();
		Timestamp fechaHoy = new Timestamp(date.getTime());
		
		Sale s1 = new Sale();
		List<SaleDetails> newDetails = new ArrayList<SaleDetails>();
		s1.setClient(clients.get(0));
		s1.setSaleDate(fechaHoy);
		for (SaleDetailsDto saleDetail : sales.getSaleDetails()) {
			SaleDetails sd1 = new SaleDetails();
			sd1.setSale(s1);
			sd1.setQuantity(saleDetail.getQuantity());
			Long idProducto = saleDetail.getIdProduct();
			List<Product> product = productService.getByIdProduct(idProducto);
			int cantidadRestada = product.get(0).getQuantity() - saleDetail.getQuantity();
			if(cantidadRestada <= 0) {
				product.get(0).setQuantity(0);
			} else {
				product.get(0).setQuantity(cantidadRestada);
			}
			productService.updateProduct(product.get(0));
			sd1.setProduct(product.get(0));
			newDetails.add(sd1);
		}
		s1.setSaleDetails(newDetails);
		clients.get(0).getSales().add(s1);

		try {
			clientService.addSaleToClient(clients.get(0));
			aux = Boolean.TRUE;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			aux = Boolean.FALSE;
		}
		
		return aux;
	}
	
	@PostMapping("/deleteClient")
	public Boolean deleteClient(@RequestBody Client idClient) {
		Boolean aux;
		
		try {
			clientService.deleteClient(idClient.getIdClient());
			aux = Boolean.TRUE;
		} catch (Exception e) {
			aux = Boolean.FALSE;
		}
		
		return aux;
	}


}
