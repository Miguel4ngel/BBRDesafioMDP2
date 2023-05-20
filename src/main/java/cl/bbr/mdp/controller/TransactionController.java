package cl.bbr.mdp.controller;

import cl.bbr.mdp.entity.Transaction;
import cl.bbr.mdp.service.dto.TransactionDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import cl.bbr.mdp.service.TransactionService;

import javax.validation.constraints.NotBlank;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/transaction")
public class TransactionController {

	@Autowired
	private TransactionService service;
	 	
	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<TransactionDto> createTransaction(@RequestBody TransactionDto request) {
		service.createTransaction(request);
		return ResponseEntity.ok().body(request);
	}

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<TransactionDto>> findTransactions(@RequestParam ("transactionType") Optional<String> transactionType) {
		return ResponseEntity.ok().body(service.findTransactions(transactionType));
	}
	    
}
