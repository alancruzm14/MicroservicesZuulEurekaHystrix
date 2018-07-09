/**
 * 
 */
package com.bancoazteca.bdm.conection;

import org.apache.log4j.Logger;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

/**
 * @author ajcruzmi
 *
 */
public class PetitionRest {

//	private static final Logger log = Logger.getLogger(PetitionRest.class);
//
//	public static String ejecutarPeticion(String url, String path, RequestTO requestTO,
//			Class<? extends ResponseTO> responseTO) throws ValidateException {
//		String fullPath = url + path;
//
//		log.info("Ejecutando Microserivicio: " + fullPath);
//
//		RestTemplate restTemplate = new RestTemplate();
//		String strTO = serializaObject(requestTO);
//		HttpEntity<String> entity = new HttpEntity<>(strTO, null);
//		ResponseEntity<String> forEntity = restTemplate.postForEntity(fullPath, entity, String.class);
//
//		return deserializaObject(responseTO, forEntity.getBody());
//	}

}
