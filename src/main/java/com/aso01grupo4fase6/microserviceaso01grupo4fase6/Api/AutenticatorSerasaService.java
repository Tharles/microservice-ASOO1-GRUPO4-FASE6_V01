package com.aso01grupo4fase6.microserviceaso01grupo4fase6.Api;

import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public class AutenticatorSerasaService {

	public Optional<String> getToken() {
		return Optional.of("4e1a1858bdd584fdc077fb7d80f39283");
	}
}
