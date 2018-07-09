/**
 * 
 */
package com.bancoazteca.bdm.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

/**
 * @author ajcruzmi
 *
 */
@Service
public class FotoService {

	@HystrixCommand(fallbackMethod = "defaultPersonaXFoto")
	public String sendPetition() {
		String ip = "http://localhost:8765/WS_BiometricosDummy/";
		String path = "ms/existPersonaXFoto";

		String url = ip + path;

		RestTemplate restTemplate = new RestTemplate();
		String result = restTemplate.postForObject(url, "", String.class);

		System.out.println("Response**" + result);

		return result;
	}

	public String defaultPersonaXFoto() {
		return "Servicio abajo, resp dflt hystrix";
	}

}
