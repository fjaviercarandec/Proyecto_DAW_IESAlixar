package org.jcarande.proyetoDAW.dtos;

import java.util.List;

public class SaleDto {
	
	private List<SaleDetailsDto> saleDetails;

	public List<SaleDetailsDto> getSaleDetails() {
		return saleDetails;
	}

	public void setSaleDetails(List<SaleDetailsDto> saleDetails) {
		this.saleDetails = saleDetails;
	}

}
