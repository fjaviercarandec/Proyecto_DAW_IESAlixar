package org.jcarande.proyetoDAW.models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Product")
public class Product implements Serializable {

	/** SERIAL ID */
	private static final long serialVersionUID = 1L;
	
	/** Identificador producto (PK) */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_product")
	private long idProduct;
	/** Nombre del product */
	@Column(nullable = false)
	private String name;
	/** Cantidad disponible del producto */
	@Column(nullable = false, columnDefinition="int default 0")
	private int quantity;
	/** Talla del producto */
	@Column(nullable = true)
	private String size;
	/** Color del producto */
	@Column(nullable = true)
	private String color;
	/** Descripcion del producto */
	@Column(nullable = true)
	private String description;
	
	@OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonIgnore
	private List<SaleDetails> saleDetails;
	
	@OneToMany(mappedBy="product", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<PurchaseDetail> purchaseDetails;
	
	public long getIdProduct() {
		return idProduct;
	}
	public void setIdProduct(long idProduct) {
		this.idProduct = idProduct;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public List<SaleDetails> getSaleDetails() {
		return saleDetails;
	}
	public void setSaleDetails(List<SaleDetails> saleDetails) {
		this.saleDetails = saleDetails;
	}
	public List<PurchaseDetail> getPurchaseDetails() {
		return purchaseDetails;
	}
	public void setPurchaseDetails(List<PurchaseDetail> purchaseDetails) {
		this.purchaseDetails = purchaseDetails;
	}
	
}
