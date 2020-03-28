package com.aso01grupo4fase6.microserviceaso01grupo4fase6.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

@Entity
public class Usuario {

	@Id
	private Long id;
	private String nome;
	private String cpf;
	@OneToOne
	private Endereco endereco;
	private String telefone;

	@Transient
	private ObjetoValidaCPFSituacao situacaoCPF;

	public Usuario() {

	}

	public Usuario(Long id, String nome, String cpf, Endereco endereco, String telefone) {
		super();
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.endereco = endereco;
		this.telefone = telefone;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public ObjetoValidaCPFSituacao getSituacaoCPF() {
		return situacaoCPF;
	}

	public void setSituacaoCPF(ObjetoValidaCPFSituacao situacaoCPF) {
		this.situacaoCPF = situacaoCPF;
	}
	
	

}
