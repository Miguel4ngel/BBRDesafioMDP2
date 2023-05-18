package cl.bbr.mdp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import cl.bbr.mdp.service.ServiceImpl;

@RestController
@RequestMapping("/api/v1/desafio/mdp/")
public class Controller {

	 	@Autowired
	    private ServiceImpl service;
	 	
	    @RequestMapping("/create")
	    @ResponseBody
	    public ResponseEntity<?> createRamdonTrx() {
	    	
	    	ResponseEntity<?> result = new ResponseEntity<Object>( service.createRamdonTrx(), HttpStatus.OK);
	
	    	return result;
	    }
	    
}
