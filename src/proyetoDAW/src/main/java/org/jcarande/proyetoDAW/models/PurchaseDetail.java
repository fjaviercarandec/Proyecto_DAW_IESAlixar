package org.jcarande.proyetoDAW.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Purchase_Detail")
public class PurchaseDetail implements Serializable{

	/** SERIAL ID */
	private static final long serialVersionUID = 1L;
	
	/** Identificador de detalle de compra */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_purchase_details")
	private long idPurchaseDetail;
	/** Cantidad de producto */
	@Column(nullable = false)
	private int quantity;
	@ManyToOne
	@JoinColumn(name = "id_purchase", nullable = false)
	private Purchase purchase;
	@ManyToOne
	@JoinColumn(name = "id_supplier", nullable = false)
	private Supplier supplier;
	@ManyToOne
	@JoinColumn(name = "id_product", nullable = false)
	private Product product;
	
	public long getIdPurchaseDetail() {
		return idPurchaseDetail;
	}
	public void setIdPurchaseDetail(long idPurchaseDetail) {
		this.idPurchaseDetail = idPurchaseDetail;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public Purchase getPurchase() {
		return purchase;
	}
	public void setPurchase(Purchase purchase) {
		this.purchase = purchase;
	}
	public Supplier getSupplier() {
		return supplier;
	}
	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	
	
}
