package com.qa.qaFinal.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	
	// Create
	@PostMapping("/createEntry")
	public ResponseEntity<String> createEntry(@RequestBody Pokedex pokedex) {
		
		
		service.createEntry(pokedex);
		
		
		ResponseEntity<String> response = new ResponseEntity<>(pokedex.getName() + " added to the Pokedex", HttpStatus.CREATED);
		return response;
	}
	
	// Read
	@GetMapping("/getEntries")
	public ResponseEntity<List<Pokedex>> getEntries() {
		
		List<Pokedex> response = service.getEntries();
		
	   return new ResponseEntity<>(response, HttpStatus.ACCEPTED);

}
	
	@GetMapping("/getId/{id}")
	public ResponseEntity<Pokedex> getById(@PathVariable("id") long id) {
		
		
		Pokedex result = service.getById(id);
		
		
		ResponseEntity<Pokedex> response = new ResponseEntity<>(result, HttpStatus.ACCEPTED);
		
		return response;
	}
	
	@GetMapping("/getName/{name}")
	public ResponseEntity<List<Pokedex>> getByName (@PathVariable("name") String name) {
		List<Pokedex> response = service.getByName(name);
		return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/getType/{type}")
	public ResponseEntity<List<Pokedex>> getByType (@PathVariable("type") String type) {
		List<Pokedex> response = service.getByType(type);
		return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
	}
	
	// Update
	@PutMapping("/update/{id}")
	public ResponseEntity<String> updateByid(@PathVariable("id") long id, @RequestBody Pokedex pokedex) {
		
		service.update(id, pokedex); // Telling the Service to do the method, but not doing anything with the return
		
		String response = "Updating pokemon of id: " + id;
		return new ResponseEntity<>(response, HttpStatus.OK);
   
}
	
	// Delete
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteByid(@PathVariable("id") long id) {
		service.remove(id);
		String response = "Pokemon of id: " + id + " deleted";
		return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
	}
	
	
}	
	
