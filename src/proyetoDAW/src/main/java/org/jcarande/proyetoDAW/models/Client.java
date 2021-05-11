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
@Table(name = "Client")
public class Client implements Serializable {

	/** SERIAL ID */
	private static final long serialVersionUID = 1L;
	
	/** Identificador cliente (PK) */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_client")
	private long idClient;
	/** Nombre del cliente */
	@Column(nullable = false)
	private String name;
	/** Apellido/s del cliente */
	@Column(nullable = true)
	private String surname;
	/** Telefono del cliente */
	@Column(nullable = true)
	private String phone;
	/** Email del cliente */
	@Column(nullable = true)
	private String email;
	/** Direccion del cliente */
	@Column(nullable = true)
	private String address;
	
	@OneToMany(mappedBy="client")
	private List<Sale> sales;
	
	public long getIdClient() {
		return idClient;
	}
	public void setIdClient(long idClient) {
		this.idClient = idClient;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public List<Sale> getSales() {
		return sales;
	}
	public void setSales(List<Sale> sales) {
		this.sales = sales;
	}
	
}
