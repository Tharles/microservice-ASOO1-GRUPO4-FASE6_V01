package com.aso01grupo4fase6.microserviceaso01grupo4fase6.model;

public class ObjetoValidaCPFSituacao {
	
	private Integer codigo;
	private String descricao;	
	
	public ObjetoValidaCPFSituacao() {
		
	}
	
	public ObjetoValidaCPFSituacao(Integer codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}
	public Integer getCodigo() {
		return codigo;
	}
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
	

}
