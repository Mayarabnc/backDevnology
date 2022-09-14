package com.api.devnology.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


	/*Indica que a classe é uma entidade*/
@Entity

	/*Indica que essa entidade é uma tabela*/
@Table(name = "link")

public class LinkModel {
	
	@Id
						/*Estrategia da chave primaria*/
	@GeneratedValue(strategy = GenerationType.IDENTITY)
												/*Auto increment do SQL*/
	private long id;
	
	@NotNull
	private String nomeLink;
	
	@NotNull
	private String link;
	
	@ManyToOne
	@JsonIgnoreProperties("linkmodel")
	@JoinColumn(name = "usuario")
	private Usuario usuario;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNomeLink() {
		return nomeLink;
	}

	public void setNomeLink(String nomeLink) {
		this.nomeLink = nomeLink;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
