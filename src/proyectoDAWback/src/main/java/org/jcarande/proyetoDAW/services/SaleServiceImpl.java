package org.jcarande.proyetoDAW.services;

import java.sql.Timestamp;
import java.util.List;

import org.jcarande.proyetoDAW.models.Sale;
import org.jcarande.proyetoDAW.repositories.SaleRepositoryI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SaleServiceImpl implements SaleServiceI {
	
	@Autowired
	private SaleRepositoryI saleRepository;

	@Override
	public void addSale(Sale sale) {
		saleRepository.save(sale);
	}

	@Override
	public void updateSale(Sale sale) {
		saleRepository.save(sale);
	}

	@Override
	public List<Sale> getAll() {
		return saleRepository.findAll();
	}

	@Override
	public List<Sale> getByIdSale(long idSale) {
		return saleRepository.findByIdSale(idSale);
	}

	@Override
	public List<Sale> getBySaleDateBetween(Timestamp saleDateStart, Timestamp saleDateEnd) {
		return saleRepository.findBySaleDateBetween(saleDateStart, saleDateEnd);
	}

}
