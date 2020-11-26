package com.projeto.model.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idUsuario")
	private Integer id;
	
	@Column(name = "usernameUsuario", length = 60, nullable = false)
	private String username;
	
	@Column(name = "emailUsuario", length = 100, nullable = false, unique = true)
	private String email;
	
	@Column(name = "passwordUsuario", length = 60, nullable = false)
	private String password;
	
	@Column(nullable = false)
	private boolean ativo = true;
	
	@Column(nullable = false)
	private boolean admin = false;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "departamentoId", nullable = false)
	private Departamento departamento;
	
	@ManyToMany()
	@JoinTable(name = "usuarioRole", 
		joinColumns = @JoinColumn(name = "idUsuario"),
		inverseJoinColumns = @JoinColumn(name = "idRole"))
	private List<Role> roles;
	
	public Usuario() {}
	
	public Usuario(Integer id, String username, String email, String password, boolean ativo, boolean admin,
			Departamento departamento) {
		super();
		this.id = id;
		this.username = username;
		this.email = email;
		this.password = password;
		this.ativo = ativo;
		this.admin = admin;
		this.departamento = departamento;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isAtivo() {
		return ativo;
	}
	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}
	public boolean isAdmin() {
		return admin;
	}
	public void setAdmin(boolean admin) {
		this.admin = admin;
	}
	public Departamento getDepartamento() {
		return departamento;
	}
	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}
	public List<Role> getRole() {
		return roles;
	}
	public void setRole(List<Role> roles) {
		this.roles = roles;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (admin ? 1231 : 1237);
		result = prime * result + (ativo ? 1231 : 1237);
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if (admin != other.admin)
			return false;
		if (ativo != other.ativo)
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Usuario [id=" + id + ", username=" + username + ", email=" + email + ", password = "+password+", ativo=" + ativo + ", admin="
				+ admin + "]";
	}
	
	
}
