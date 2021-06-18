package org.jcarande.proyetoDAW.services;

import java.util.List;

import org.jcarande.proyetoDAW.models.SaleDetails;
import org.jcarande.proyetoDAW.repositories.SaleDetailsRepositoryI;
import org.springframework.beans.factory.annotation.Autowired;

public class SaleDetailsServiceImpl implements SaleDetailsServiceI {
	
	@Autowired
	private SaleDetailsRepositoryI saleDetailsRepository;

	@Override
	public void addSaleDetails(SaleDetails saleDetails) {
		saleDetailsRepository.save(saleDetails);
	}

	@Override
	public void updateSaleDetails(SaleDetails saleDetails) {
		saleDetailsRepository.save(saleDetails);
	}

	@Override
	public List<SaleDetails> getAll() {
		return saleDetailsRepository.findAll();
	}

	@Override
	public List<SaleDetails> getByIdSaleDetails(long idSaleDetails) {
		return saleDetailsRepository.findByIdSaleDetails(idSaleDetails);
	}

}
