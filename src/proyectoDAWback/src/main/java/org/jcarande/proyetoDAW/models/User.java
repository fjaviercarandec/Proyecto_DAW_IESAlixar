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
@Table(name = "User")
public class User implements Serializable {

	/** SERIAL ID */
	private static final long serialVersionUID = 1L;
	
	/** Identificador usuario (PK) */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_user")
	private long idUser;
	/** Nombre usuario */
	@Column(nullable = false)
	private String name;
	/** Apellidos usuario */
	@Column(nullable = true)
	private String surnames;
	/** Contraseña usuario */
	@Column(nullable = false)
	private String password;
	/** Telefono usuario */
	@Column(nullable = true)
	private String phone;
	/** Email usuario */
	@Column(nullable = false, unique = true)
	private String email;
	/** Controlador admin */
	@Column(nullable = false, columnDefinition="tinyint(1) default 0")
	private Boolean admin;
	/** Controlador usuario activo */
	@Column(nullable = false, columnDefinition="tinyint(1) default 0")
	private Boolean active;
	
	@OneToMany(mappedBy="user")
	private List<Purchase> purchases;

	public long getIdUser() {
		return idUser;
	}
	public void setIdUser(long idUser) {
		this.idUser = idUser;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurnames() {
		return surnames;
	}
	public void setSurnames(String surnames) {
		this.surnames = surnames;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
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
	public Boolean getAdmin() {
		return admin;
	}
	public void setAdmin(Boolean admin) {
		this.admin = admin;
	}
	public Boolean getActive() {
		return active;
	}
	public void setActive(Boolean active) {
		this.active = active;
	}
	public List<Purchase> getPurchases() {
		return purchases;
	}
	public void setPurchases(List<Purchase> purchases) {
		this.purchases = purchases;
	}
	
}
