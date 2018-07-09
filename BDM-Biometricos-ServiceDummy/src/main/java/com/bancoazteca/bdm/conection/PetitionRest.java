/**
 * 
 */
package com.bancoazteca.bdm.conection;

/**
 * @author ajcruzmi
 *
 */
public class PetitionRest {

//	public static ResponseTOGenerico ejecutarPeticion(String url, String path, RequestTO requestTO, Class<? extends ResponseTO> responseTO) throws ValidateException {
//		String fullPath = url + path;
//		
//		log.info("Ejecutando Microserivicio: " +  fullPath);
//		
//		RestTemplate restTemplate = new RestTemplate();
//		String strTO = serializaObject(requestTO); 
//		HttpEntity<String> entity = new HttpEntity<>(strTO, null);
//		ResponseEntity<String> forEntity = restTemplate.postForEntity(fullPath, entity, String.class);
//		if(!forEntity.getStatusCode().toString().equals(STATUS_OK))
//			throw new BDMRuntimeException("Failed : HTTP error code : " + forEntity.getStatusCode().toString());
//		
//		return deserializaObject(responseTO, forEntity.getBody());
//	}
	
}
