package com.aso01grupo4fase6.microserviceaso01grupo4fase6.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;

import com.aso01grupo4fase6.microserviceaso01grupo4fase6.model.Usuario;
import com.aso01grupo4fase6.microserviceaso01grupo4fase6.service.UsuarioService;

import Util.Utils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/v1/usuario")
@Api(value = "Microserviço de usuario pessoa física")
@SuppressWarnings("rawtypes")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;

	@ApiOperation(value = "Lista de todos os usuários")
	@ResponseBody
	@GetMapping()
	public ResponseEntity<List<Usuario>> getNegociacaoFornecedorMateriaPrima() {
		List<Usuario> listaRetorno = usuarioService.findAll();
		return listaRetorno.isEmpty() ? new ResponseEntity<List<Usuario>>(HttpStatus.NO_CONTENT)
				: new ResponseEntity<List<Usuario>>(listaRetorno, HttpStatus.OK);
	}

	@ApiOperation(value = "Inserir um novo usuário")
	@ResponseBody
	@PostMapping()
	public ResponseEntity inserirUsuario(@RequestBody Usuario usuario) throws Exception {
		try {
			Usuario usuarioRetorno = usuarioService.inserirUsuario(usuario);			
			return usuarioRetorno.getSituacaoCPF().getCodigo()==Utils.REGULAR
					? new ResponseEntity<>(usuarioRetorno, HttpStatus.CREATED)
					: new ResponseEntity<>(Utils.MSG_CPF_COM_PROBLEMA + usuarioRetorno.getSituacaoCPF().getDescricao(), HttpStatus.UNPROCESSABLE_ENTITY);
		} catch (HttpClientErrorException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.valueOf(e.getRawStatusCode()));
		}

	}

	@ApiOperation(value = "Buscar usuário")
	@ResponseBody
	@GetMapping("/id/{id}")
	public ResponseEntity<Usuario> buscarUsuario(@PathVariable("id") Long id) {
		Optional<Usuario> usuario = usuarioService.buscarUsuario(id);
		return usuario.isPresent() ? new ResponseEntity<>(usuario.get(), HttpStatus.OK)
				: new ResponseEntity<>(HttpStatus.NO_CONTENT);

	}

}
