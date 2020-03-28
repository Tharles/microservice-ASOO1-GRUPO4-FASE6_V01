package com.aso01grupo4fase6.microserviceaso01grupo4fase6.Api;

import java.io.IOException;
import java.util.Collections;
import java.util.Optional;

import javax.naming.ServiceUnavailableException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;

import Util.Utils;

@Service
public class RequisicoesService {
	@Autowired
	private RestTemplate restTemplate;
	protected ObjectMapper objectMapper = new ObjectMapper();

	private static final Logger LOG = LoggerFactory.getLogger(RequisicoesService.class);

	public <T> T executarPost(String url, Object resquestObject, Class<T> bind) {
		ResponseEntity<String> response = this.restTemplate.postForEntity(url, resquestObject, String.class);
		return getObjetoRequisicao(url, bind, response, HttpStatus.CREATED, Utils.POST);
	}

	protected <T> T get(String url, Class<T> bind) throws ServiceUnavailableException {
		return executarGet(url, bind, Optional.empty());
	}

	protected <T> T get(String url, Class<T> bind, Optional<String> token) throws ServiceUnavailableException {
		return executarGet(url, bind, token);
	}

	private <T> T executarGet(String url, Class<T> bind, Optional<String> token) {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
		

		if (token.isPresent())
			headers.setBearerAuth(token.get());

		HttpEntity<String> entity = new HttpEntity<>("body", headers);

		ResponseEntity<String> response = this.restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
		return getObjetoRequisicao(url, bind, response, HttpStatus.OK, Utils.GET);
		
	}

	private <T> T getObjetoRequisicao(String url, Class<T> bind, ResponseEntity<String> response, HttpStatus status,
			String msg) {
		if (status.equals(response.getStatusCode())) {
			try {
				return objectMapper.readValue(response.getBody(), bind);
			} catch (IOException e) {
				LOG.info("Erro ao converter do jackson para classe. Exceção: {} Classe: {} na URL: {}", e, bind, url);				
			}
		} else {
			LOG.error("Erro ao realizar {} código retorno: {} da classe: {}", msg, response.getStatusCodeValue(),
					bind.getSimpleName());
		}
		return null;
	}
}
