package com.aso01grupo4fase6.microserviceaso01grupo4fase6.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aso01grupo4fase6.microserviceaso01grupo4fase6.model.Usuario;
import com.aso01grupo4fase6.microserviceaso01grupo4fase6.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	public List<Usuario> findAll() {		
		return (List<Usuario>) usuarioRepository.findAll();
	}
	
	public Usuario inserirUsuario(Usuario usuario) {
		return usuarioRepository.save(usuario);
	}
	
	public Optional<Usuario> buscarUsuario(Long id) {
		return usuarioRepository.findById(id);
	}
}
