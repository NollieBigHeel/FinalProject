package com.qa.qaFinal.services;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

import com.qa.qaFinal.model.Pokedex;
import com.qa.qaFinal.repo.Repo;



@SpringBootTest
@ActiveProfiles("test")
public class ServicesTest {
	
	
	@MockBean
	private Repo repo;
	
	@Autowired
	private Services service;
	
    // Without id
	Pokedex testPokemon1 = new Pokedex("pokemon1", "type1", 1, "description1", true);
	Pokedex testPokemon2 = new Pokedex("pokemon2", "type2", 2, "description2", false);
	// With id
	Pokedex testPokemonID = new Pokedex(1l,"pokemon1", "type1", 1, "description1", true);
	Pokedex testPokemonID2 = new Pokedex(2l, "pokemon2", "type2", 2, "description2", false);
	
	
	@Test
	public void testCreate() {
		
		// Arrange
		Mockito.when(repo.save(testPokemon1)).thenReturn(testPokemonID);
		
		// Act
		Pokedex result = service.createEntry(testPokemon1);
		
		// Assert
		Assertions.assertEquals(testPokemonID, result);
		Mockito.verify(repo, Mockito.times(1)).save(testPokemon1);
	}
	
	@Test
	public void testGetById() {
		
		// Arrange
	    Mockito.when(repo.findById(1l)).thenReturn(Optional.of(testPokemonID));
	    
	    // Act
	    Pokedex result = service.getById(1l);
	    
	    // Assert
	    Assertions.assertEquals(testPokemonID, result);
	    Mockito.verify(repo, Mockito.never()).getById(1l);
	}
	
	@Test 
	public void testGetAll () {
		
		// Arrange
		List<Pokedex> pokeList = new ArrayList<>();
		pokeList.add(testPokemon1);
	
		// Act
		Mockito.when(this.repo.findAll()).thenReturn(pokeList);
		
		// Assert
		assertThat(this.service.getEntries()).isEqualTo(pokeList);
		Mockito.verify(this.repo, Mockito.times(1)).findAll();
	}
	
	@Test
	public void getByName() {
		
		// Arrange
		String s = "pokemon1";
		List<Pokedex> pokeList = new ArrayList<>();
		pokeList.add(testPokemon1);
		
		// Act
		Mockito.when(this.repo.findByName(s)).thenReturn(pokeList);
		
		// Assert
		assertThat(this.service.getByName(s)).isEqualTo(pokeList);
		Mockito.verify(this.repo, Mockito.times(1)).findByName(s);
	}
	
	@Test
	public void getByType() {
		
		// Arrange
		String s = "type1";
		List<Pokedex> pokeList = new ArrayList<>();
		pokeList.add(testPokemon1);
		
		// Act
		Mockito.when(this.repo.findByType(s)).thenReturn(pokeList);
		
		// Assert
		assertThat(this.service.getByType(s)).isEqualTo(pokeList);
		Mockito.verify(this.repo, Mockito.times(1)).findByType(s);
	}
	

}
