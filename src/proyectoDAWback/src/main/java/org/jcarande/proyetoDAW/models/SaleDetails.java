package org.jcarande.proyetoDAW.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "Sale_Details")
public class SaleDetails implements Serializable {

	/** SERIAL ID */
	private static final long serialVersionUID = 1L;
	/** Identificador de detalles de venta (PK) */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_sale_details")
	private long idSaleDetails;
	/** Cantidad de productos */
	@Column(nullable = false)
	private int quantity;
	/** Identificador de venta (FK) */
	@ManyToOne
	@JoinColumn(name = "id_sale", nullable = false, foreignKey = @ForeignKey(name = "saleDetails_sale"))
	@JsonBackReference
	private Sale sale;
	/** Identificador de producto (FK) */
	@ManyToOne
	@JoinColumn(name = "id_product", nullable = false, foreignKey = @ForeignKey(name = "saleDetails_product"))
	@JsonBackReference
	private Product product;
	
	public long getIdSaleDetails() {
		return idSaleDetails;
	}
	public void setIdSaleDetails(long idSaleDetails) {
		this.idSaleDetails = idSaleDetails;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public Sale getSale() {
		return sale;
	}
	public void setSale(Sale sale) {
		this.sale = sale;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
		
}
