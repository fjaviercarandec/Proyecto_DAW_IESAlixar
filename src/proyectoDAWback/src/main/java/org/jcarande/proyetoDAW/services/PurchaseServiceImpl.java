package org.jcarande.proyetoDAW.services;

import java.sql.Timestamp;
import java.util.List;

import org.jcarande.proyetoDAW.models.Purchase;
import org.jcarande.proyetoDAW.repositories.PurchaseRepositoryI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PurchaseServiceImpl implements PurchaseServiceI {
	
	@Autowired
	private PurchaseRepositoryI purchaseRepository;

	@Override
	public void addPurchase(Purchase purchase) {
		purchaseRepository.save(purchase);
	}

	@Override
	public void updatePurchase(Purchase purchase) {
		purchaseRepository.save(purchase);
	}

	@Override
	public List<Purchase> getAll() {
		return purchaseRepository.findAll();
	}

	@Override
	public List<Purchase> getByIdPurchase(long idPurchase) {
		return purchaseRepository.findByIdPurchase(idPurchase);
	}

	@Override
	public List<Purchase> getByPurchaseDate(Timestamp purchaseDate) {
		return purchaseRepository.findByPurchaseDate(purchaseDate);
	}

}
