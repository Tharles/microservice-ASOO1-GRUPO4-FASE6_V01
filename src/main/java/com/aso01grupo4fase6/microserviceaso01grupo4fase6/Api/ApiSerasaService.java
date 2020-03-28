package com.aso01grupo4fase6.microserviceaso01grupo4fase6.Api;

import javax.naming.ServiceUnavailableException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aso01grupo4fase6.microserviceaso01grupo4fase6.model.ObjetoValidaCPF;

import Util.Utils;

@Service
public class ApiSerasaService {

	@Autowired
	private AutenticatorSerasaService serasaAutenticator;
	@Autowired
	private RequisicoesService requisicao;

	public ObjetoValidaCPF verificarCPFValido(String cpf) throws ServiceUnavailableException {
		StringBuilder url = new StringBuilder();
		url.append(Utils.API_SERASA);
		url.append("consulta-cpf-df-trial/v1/cpf/");
		url.append(cpf);
		return requisicao.get(url.toString(), ObjetoValidaCPF.class, serasaAutenticator.getToken());

	}

}
