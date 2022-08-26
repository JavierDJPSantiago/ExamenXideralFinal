package com.client.rest.service;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


import com.client.rest.model.Escuela;

@Service
public class EscuelaServiceRestClientImpl implements EscuelaService {

	private RestTemplate restTemplate;

	private String crmRestUrl;
		
	private Logger logger = Logger.getLogger(getClass().getName());
	
	@Autowired
	public EscuelaServiceRestClientImpl(RestTemplate theRestTemplate, 
										@Value("${crm.rest.url}") String theUrl) {
		
		restTemplate = theRestTemplate;
		crmRestUrl = theUrl;
				
		logger.info("Loaded property:  crm.rest.url=" + crmRestUrl);
	}
	
	@Override
	public List<Escuela> getEscuelas() {
		
		logger.info("***OBTENER LISTA DE CLIENTES DESDE EL SERVICE REST CLIENTE");
		logger.info("in getCustomers(): Calling REST API " + crmRestUrl);

		// make REST call
		ResponseEntity<List<Escuela>> responseEntity = 
											restTemplate.exchange(crmRestUrl, HttpMethod.GET, null, 
													 new ParameterizedTypeReference<List<Escuela>>() {});

		// get the list of customers from response
		List<Escuela> escuelas = responseEntity.getBody();

		logger.info("in getEscuelas(): escuelas" + escuelas);
		
		return escuelas;
	}

	@Override
	public Escuela getEscuela(int theId) {
		logger.info("***OBTENER UN CLIENTE DESDE EL SERVICE REST CLIENTE");

		logger.info("in getEscuela(): Calling REST API " + crmRestUrl);

		// make REST call
		Escuela theEscuela = 
				restTemplate.getForObject(crmRestUrl + "/" + theId, 
						Escuela.class);

		logger.info("in saveEscuela(): theEscuela=" + theEscuela);
		
		return theEscuela;
	}

	@Override
	public void saveEscuela(Escuela theEscuela) {

		logger.info("in saveEscuela(): Calling REST API " + crmRestUrl);
		
		int escuelaId = theEscuela.getId();

		// make REST call
		if (escuelaId == 0) {
			// add employee
			logger.info("***SALVAR UN CLIENTE DESDE EL SERVICE REST CLIENTE");

			restTemplate.postForEntity(crmRestUrl, theEscuela, String.class);			
		
		} else {
			// update employee
			logger.info("***ACTUALIZAR UN CLIENTE DESDE EL SERVICE REST CLIENTE");

			restTemplate.put(crmRestUrl, theEscuela);
		}

		logger.info("in saveEscuela(): success");	
	}

	@Override
	public void deleteEscuela(int theId) {
		logger.info("***BORRAR UN CLIENTE DESDE EL SERVICE REST CLIENTE");

		logger.info("in deleteEscuela(): Calling REST API " + crmRestUrl);

		// make REST call
		restTemplate.delete(crmRestUrl + "/" + theId);

		logger.info("in deleteEscuela(): deleted escuela theId=" + theId);
	}

}
