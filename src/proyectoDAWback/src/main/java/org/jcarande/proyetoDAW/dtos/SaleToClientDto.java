package org.jcarande.proyetoDAW.dtos;

public class SaleToClientDto {
	
	private Long idClient;
	private SaleDto sales;
	
	public Long getIdClient() {
		return idClient;
	}
	public void setIdClient(Long idClient) {
		this.idClient = idClient;
	}
	public SaleDto getSales() {
		return sales;
	}
	public void setSales(SaleDto sales) {
		this.sales = sales;
	}

}
