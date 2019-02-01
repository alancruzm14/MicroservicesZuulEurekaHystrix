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

import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiResponse;
import com.wordnik.swagger.annotations.ApiResponses;

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
		System.out.println("TESSSSSSSST");
		return new ResponseEntity<String>("TEST DUMMY CAPA 2", HttpStatus.OK);
	}

}
