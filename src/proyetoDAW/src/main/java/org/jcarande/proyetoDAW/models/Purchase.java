package org.jcarande.proyetoDAW.models;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Purchase")
public class Purchase implements Serializable {

	/** SERIAL ID */
	private static final long serialVersionUID = 1L;
	
	/** Identificador compra (PK) */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_purchase")
	private long idPurchase;
	/** Fecha de compra */
	@Column(nullable = false)
	private Timestamp purchaseDate;
	/** Identificador de usuario (FK) */
	@ManyToOne
	@JoinColumn(name = "id_user", nullable = false)
	private User user;
	
	@OneToMany(mappedBy="purchase")
	private List<PurchaseDetail> purchaseDetails;
	
	public long getIdPurchase() {
		return idPurchase;
	}
	public void setIdPurchase(long idPurchase) {
		this.idPurchase = idPurchase;
	}
	public Timestamp getPurchaseDate() {
		return purchaseDate;
	}
	public void setPurchaseDate(Timestamp purchaseDate) {
		this.purchaseDate = purchaseDate;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public List<PurchaseDetail> getPurchaseDetails() {
		return purchaseDetails;
	}
	public void setPurchaseDetails(List<PurchaseDetail> purchaseDetails) {
		this.purchaseDetails = purchaseDetails;
	}
	
}
