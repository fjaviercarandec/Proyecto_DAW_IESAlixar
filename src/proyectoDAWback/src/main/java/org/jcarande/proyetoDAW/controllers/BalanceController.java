package org.jcarande.proyetoDAW.controllers;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.List;

import org.jcarande.proyetoDAW.dtos.BalanceRecoveryDto;
import org.jcarande.proyetoDAW.models.Sale;
import org.jcarande.proyetoDAW.services.PurchaseServiceI;
import org.jcarande.proyetoDAW.services.SaleServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controlador de balance.
 * @author javie
 *
 */
@RestController
@RequestMapping("/balance")
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*", exposedHeaders = "Authorization")
public class BalanceController {
	
	@SuppressWarnings("unused")
	@Autowired
	private PurchaseServiceI purchaseService;
	
	@Autowired
	private SaleServiceI saleService;
	
	@SuppressWarnings("unused")
	@PostMapping("/balanceResult")
	public BalanceRecoveryDto getBalance(@RequestBody BalanceRecoveryDto balanceRecovery) {
		Integer mes = Integer.valueOf(balanceRecovery.getMonth());
		Integer anyo = balanceRecovery.getYear();
		
		LocalDate dateBalance = LocalDate.of(anyo, mes, 1);
		LocalDate dateBalanceNext = LocalDate.of(anyo, mes+1, 1);
		
		List<Sale> sales = saleService.getBySaleDateBetween(Timestamp.valueOf(dateBalance.atStartOfDay()), Timestamp.valueOf(dateBalanceNext.atStartOfDay()));
		if(!CollectionUtils.isEmpty(sales)) {
			for (Sale sale : sales) {
			}
		}
		
		return null;
	}

}
