package com.aso01grupo4fase6.microserviceaso01grupo4fase6.service;

import java.util.List;
import java.util.Optional;

import javax.naming.ServiceUnavailableException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aso01grupo4fase6.microserviceaso01grupo4fase6.Api.ApiSerasaService;
import com.aso01grupo4fase6.microserviceaso01grupo4fase6.model.ObjetoValidaCPF;
import com.aso01grupo4fase6.microserviceaso01grupo4fase6.model.Usuario;
import com.aso01grupo4fase6.microserviceaso01grupo4fase6.repository.EnderecoRepository;
import com.aso01grupo4fase6.microserviceaso01grupo4fase6.repository.UsuarioRepository;

import Util.Utils;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private EnderecoRepository enderecoRepository;

	@Autowired
	private ApiSerasaService apiSerasa;

	public List<Usuario> findAll() {
		return (List<Usuario>) usuarioRepository.findAll();
	}

	public Usuario inserirUsuario(Usuario usuario) throws Exception {

		ObjetoValidaCPF cpfValidado = verificarCPFValido(usuario);
		usuario.setSituacaoCPF(cpfValidado.getSituacao());
		if (cpfValidado.getSituacao().getCodigo().equals(Utils.REGULAR)) {
			enderecoRepository.save(usuario.getEndereco());
			return usuarioRepository.save(usuario);
		}
		return usuario;
	}

	public Optional<Usuario> buscarUsuario(Long id) {
		return usuarioRepository.findById(id);
	}

	private ObjetoValidaCPF verificarCPFValido(Usuario usuario) throws ServiceUnavailableException {
		return apiSerasa.verificarCPFValido(usuario.getCpf());
	}
}
