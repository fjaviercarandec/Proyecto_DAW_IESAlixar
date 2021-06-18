package org.jcarande.proyetoDAW.models;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Sale")
public class Sale implements Serializable {

	/** SERIAL ID */
	private static final long serialVersionUID = 1L;
	/** Identificador venta (PK) */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_sale")
	private long idSale;
	/** Fecha de venta */
	@Column(nullable = false)
	private Timestamp saleDate;
	/** Identificador de cliente (FK) */
	@ManyToOne
	@JoinColumn(name = "id_client", nullable = false,  foreignKey = @ForeignKey(name = "sale_client"))
	private Client client;
	
	@OneToMany(mappedBy="sale", cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonIgnore
	private List<SaleDetails> saleDetails;
	
	public long getIdSale() {
		return idSale;
	}
	public void setIdSale(long idSale) {
		this.idSale = idSale;
	}
	public Timestamp getSaleDate() {
		return saleDate;
	}
	public void setSaleDate(Timestamp saleDate) {
		this.saleDate = saleDate;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public List<SaleDetails> getSaleDetails() {
		return saleDetails;
	}
	public void setSaleDetails(List<SaleDetails> saleDetails) {
		this.saleDetails = saleDetails;
	}
	
}
