package org.jcarande.proyetoDAW;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.jcarande.proyetoDAW.models.Client;
import org.jcarande.proyetoDAW.models.Product;
import org.jcarande.proyetoDAW.models.Sale;
import org.jcarande.proyetoDAW.models.SaleDetails;
import org.jcarande.proyetoDAW.models.User;
import org.jcarande.proyetoDAW.services.ClientServiceI;
import org.jcarande.proyetoDAW.services.ProductServiceI;
import org.jcarande.proyetoDAW.services.UserServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProyetoDawApplication implements CommandLineRunner {
	
	@Autowired
	private UserServiceI userService;
	
	@Autowired
	private ClientServiceI clientService;
	
	@Autowired
	private ProductServiceI productService;

	public static void main(String[] args) {
		SpringApplication.run(ProyetoDawApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		User u1 = new User();
		u1.setName("Javier");
		u1.setSurnames("Carande");
		u1.setPassword("pass123");
		u1.setEmail("javier@correo.es");
		u1.setAdmin(Boolean.TRUE);
		u1.setActive(Boolean.TRUE);
		
		User u2 = new User();
		u2.setName("Javier");
		u2.setSurnames("Lopez");
		u2.setPassword("pass123");
		u2.setEmail("javier.lopez@correo.es");
		u2.setAdmin(Boolean.TRUE);
		u2.setActive(Boolean.TRUE);
		
		User u3 = new User();
		u3.setName("Manolo");
		u3.setSurnames("Lopez");
		u3.setPassword("pass123");
		u3.setEmail("manolo.lopez@correo.es");
		u3.setAdmin(Boolean.TRUE);
		u3.setActive(Boolean.TRUE);
		
		User u4 = new User();
		u4.setName("Paco");
		u4.setSurnames("Martin");
		u4.setPassword("pass123");
		u4.setEmail("paco.martin@correo.es");
		u4.setAdmin(Boolean.FALSE);
		u4.setActive(Boolean.FALSE);

		userService.addUser(u1);
		userService.addUser(u2);
		userService.addUser(u3);
		userService.addUser(u4);
		
		Product p1 = new Product();
		p1.setName("Falda");
		p1.setQuantity(10);
		p1.setSize("M");
		p1.setColor("Verde");
		
		productService.addProduct(p1);
		
		Client c1 = new Client();
		c1.setName("Javier");
		c1.setSurname("Carande");
		c1.setEmail("javier@correo.es");
		c1.setPhone("111 222 333");
		c1.setAddress("c/Calle n1");
		
		Client c2 = new Client();
		c2.setName("Ana");
		c2.setSurname("Carande");
		c2.setEmail("ana@correo.es");
		c2.setPhone("444 555 666");
		c2.setAddress("c/Calle n2");
		List<Sale> sales = new ArrayList<Sale>();
		Sale s1 = new Sale();
		s1.setClient(c2);
		Date date = new Date();
		s1.setSaleDate(new Timestamp(date.getTime()));
		List<SaleDetails> saleDetails = new ArrayList<SaleDetails>();
		SaleDetails saleDetail = new SaleDetails();
		saleDetail.setSale(s1);
		saleDetail.setQuantity(2);
		saleDetail.setProduct(p1);
		saleDetails.add(saleDetail);
		s1.setSaleDetails(saleDetails);
		sales.add(s1);
		c2.setSales(sales);
		
		clientService.addClient(c1);
		clientService.addClient(c2);

	}

}
