package com.aso01grupo4fase6.microserviceaso01grupo4fase6.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Usuario {
	
	@Id
	private Long id;		
	private String nome;
	private String cpf;
	
}
