package com.qa.qaFinal.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.qa.qaFinal.model.Pokedex;
import com.qa.qaFinal.services.Services;



@RestController
public class Controller {
	
	private Services service;

	public Controller(Services service) {
		super();
		this.service = service;
	}
	
	@PostMapping("/createEntry")
	public ResponseEntity<String> createEntry(@RequestBody Pokedex pokedex) {
		
		
		service.createEntry(pokedex);
		
		
		ResponseEntity<String> response = new ResponseEntity<>(pokedex.getName() + " added to the Pokedex", HttpStatus.CREATED);
		return response;
	}
	
	@GetMapping("/getEntries")
	public ResponseEntity<List<Pokedex>> getEntries() {
		
		List<Pokedex> response = service.getEntries();
		
	   return new ResponseEntity<>(response, HttpStatus.ACCEPTED);

}
}
