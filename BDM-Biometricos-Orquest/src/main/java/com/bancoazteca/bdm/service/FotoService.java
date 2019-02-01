/**
 * 
 */
package com.bancoazteca.bdm.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

/**
 * @author ajcruzmi
 *
 */
@Service
public class FotoService {

	@HystrixCommand(fallbackMethod = "defaultPersonaXFoto")
	public String sendPetition() {
		String ip = "localhost:8765";
//		String ip = "zuul-registry.testgitlab.svc/bdmbiometricosdummy/";
		String path = "/bdmbiometricosdummy/ms/existPersonaXFoto";

		String url = ip + path;
		
		System.out.println("URL: " + url);
		
		RestTemplate restTemplate = new RestTemplate();
		String result = restTemplate.postForObject(url, "", String.class);

		System.out.println("Response**" + result);

		return result;
	}

	public String defaultPersonaXFoto() {
		return "Servicio abajo, resp dflt hystrix";
	}

	public String consultaFotoXId(String id) {
		String result = "";

		String DB_NAME = "BAZBDMDESA";
		String MONGO_HOST = "10.63.32.180";
		int MONGO_PORT = 27021;
		String user = "UsrBazDigital";
		String pass = "B4zD1g1T4l20164$78";

		try {

			ServerAddress sa = new ServerAddress(MONGO_HOST, MONGO_PORT);
			String db = DB_NAME;
			MongoCredential mc = MongoCredential.createCredential(user, db, pass.toCharArray());
			List<MongoCredential> mcs = new ArrayList<MongoCredential>();
			mcs.add(mc);
			MongoClientOptions.Builder builder = MongoClientOptions.builder();
			builder.serverSelectionTimeout(1000);

			MongoClientOptions options = builder.build();
			MongoClient client = new MongoClient(sa, mcs, options);
			System.out.println("Connect to database successfully=" + client.getConnectPoint());

			System.out.println("######");
			System.out.println(client.getDatabaseNames());
			System.out.println("######");

			DB BAZBDMDESA = client.getDB(DB_NAME);
			System.out.println("Base de datos[" + BAZBDMDESA + "]");

			System.out.println("*****");

			DBCollection coll = BAZBDMDESA.getCollection("testA");

			System.out.println("Hay tantos registros: " + coll.count());

			System.out.println("*****");
			result = "Conexion BD exitosa";
			
		} catch (Exception e) {
			System.out.println("Ocurrio una Incidencia en el servicio");
			e.printStackTrace();
		}
		return result;
	}

//	public static void main(String[] args) {
//		FotoService f = new FotoService();
//		f.consultaFotoXId("595d33882e1ba3da09a165eb");
//	}

}
