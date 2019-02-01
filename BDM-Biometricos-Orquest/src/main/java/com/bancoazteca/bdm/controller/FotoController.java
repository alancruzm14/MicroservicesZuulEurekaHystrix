/**
 * 
 */
package com.bancoazteca.bdm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bancoazteca.bdm.service.FotoService;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiResponse;
import com.wordnik.swagger.annotations.ApiResponses;

/**
 * @author ajcruzmi
 *
 */
@RestController
@RequestMapping("api/bdm/")
@Api(value = "Foto")
public class FotoController {

	@Autowired
	FotoService fotoService;

	@ApiOperation(value = "Consulta persona por foto")
	@ApiResponses(value = { @ApiResponse(code = 404, message = "Ops Not found"),
			@ApiResponse(code = 200, message = "Sucess") })
	@RequestMapping(value = "existPersonaXFoto", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> existePersonaXFoto() throws Exception {

		String result = fotoService.defaultPersonaXFoto();

		return new ResponseEntity<String>(result, HttpStatus.OK);
	}
	
	
	@ApiOperation(value = "Consulta persona por id")
	@ApiResponses(value = { @ApiResponse(code = 404, message = "Ops Not found"),
			@ApiResponse(code = 200, message = "Sucess") })
	@RequestMapping(value = "consultaFotoXPersona", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> consultaFotoXPersona() throws Exception {

		String result = fotoService.consultaFotoXId("595d33882e1ba3da09a165eb");

		return new ResponseEntity<String>(result, HttpStatus.OK);
	}
	

}
