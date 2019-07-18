package chiffrement.dechiffrement.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import chiffrement.dechiffrement.demo.common.ChiffrementRequest;
import chiffrement.dechiffrement.demo.common.ChiffrementResponse;
import chiffrement.dechiffrement.demo.common.DechiffrementRequest;
import chiffrement.dechiffrement.demo.common.DechiffrementResponse;
import chiffrement.dechiffrement.demo.service.ChiffrementDechiffrementService;

@RequestMapping(path="/eni")
@RestController
public class ChiffrementDechiffrementController {
	
	@Autowired
	private ChiffrementDechiffrementService chiffrementDechiffrementService;

	@PostMapping(path="/chiff", consumes = "application/json", produces = "application/json")
	public ChiffrementResponse chiffrement(@RequestBody ChiffrementRequest chiffrementRequest) {
		return chiffrementDechiffrementService.chiffrement(chiffrementRequest);
	}
	
	@PostMapping(path="/dechi", consumes = "application/json", produces = "application/json")
	public DechiffrementResponse dechiffrement(@RequestBody DechiffrementRequest dechiffrementRequest) {
		return chiffrementDechiffrementService.dechiffrement(dechiffrementRequest);		
	}
	
}
