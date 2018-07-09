/**
 * 
 */
package com.bancoazteca.bdm.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * @author ajcruzmi
 *
 */
@RestController
@RequestMapping("ms/")
@Api(value = "Foto")
public class FotoController {

	@ApiOperation(value = "Consulta persona por foto")
	@ApiResponses(value = { @ApiResponse(code = 404, message = "Ops Not found"),
			@ApiResponse(code = 200, message = "Sucess") })
	@RequestMapping(value = "existPersonaXFoto", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> existePersonaXFoto() throws Exception {
		
		return new ResponseEntity<String>("TEST DUMMY CAPA 2", HttpStatus.OK);
	}

}
