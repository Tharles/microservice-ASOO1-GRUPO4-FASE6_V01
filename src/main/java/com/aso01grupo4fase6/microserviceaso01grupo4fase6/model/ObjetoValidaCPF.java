package com.aso01grupo4fase6.microserviceaso01grupo4fase6.model;

public class ObjetoValidaCPF {
	private String ni;
	private String nome;
	private ObjetoValidaCPFSituacao situacao;	
		
	public ObjetoValidaCPF() {
	}
		
	public ObjetoValidaCPF(String ni, String nome, ObjetoValidaCPFSituacao situacao) {
		this.ni = ni;
		this.nome = nome;
		this.situacao = situacao;
	}

	public String getNi() {
		return ni;
	}
	public void setNi(String ni) {
		this.ni = ni;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public ObjetoValidaCPFSituacao getSituacao() {
		return situacao;
	}
	public void setSituacao(ObjetoValidaCPFSituacao situacao) {
		this.situacao = situacao;
	}
	
	

}
