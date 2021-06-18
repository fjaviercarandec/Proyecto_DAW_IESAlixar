package org.jcarande.proyetoDAW.models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Supplier")
public class Supplier implements Serializable {

	/** SERIAL ID */
	private static final long serialVersionUID = 1L;
	
	/** Identificador proveedor (PK) */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_supplier")
	private long idSupplier;
	/** Nombre del proveedor */
	@Column(nullable = false)
	private String companyName;
	/** Telefono del proveedor */
	@Column(nullable = true)
	private String phone;
	/** Email del proveedor */
	@Column(nullable = true)
	private String email;
	
	@OneToMany(mappedBy="supplier")
	private List<PurchaseDetail> purchaseDetails;

	public long getIdSupplier() {
		return idSupplier;
	}
	public void setIdSupplier(long idSupplier) {
		this.idSupplier = idSupplier;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public List<PurchaseDetail> getPurchaseDetails() {
		return purchaseDetails;
	}
	public void setPurchaseDetails(List<PurchaseDetail> purchaseDetails) {
		this.purchaseDetails = purchaseDetails;
	}
	
}
