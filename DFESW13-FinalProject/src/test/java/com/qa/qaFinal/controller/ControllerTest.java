package com.qa.qaFinal.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.qaFinal.model.Pokedex;



@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)

@AutoConfigureMockMvc
@TestInstance(TestInstance.Lifecycle.PER_CLASS) // Allows us to use @BeforeAll in a NON STATIC way

@Sql(scripts = {"classpath:test-data.sql"}, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
@ActiveProfiles("dev")
public class ControllerTest {
	
	@Autowired  
	private MockMvc mvc; 
	
	@Autowired
	private ObjectMapper mapper;
	
	Pokedex testPokemon3 = new Pokedex("pokemon3", "type3", 3, "description3", true);
	Pokedex testPokemonID = new Pokedex(1l,"pokemon1", "type1", 1, "description1", true);
	Pokedex testPokemonID2 = new Pokedex(2l, "pokemon2", "type2", 2, "description2", false);

@Test
public void testCreate() throws Exception {
		
		// Arrange 
		 
		String pokeJson = mapper.writeValueAsString(testPokemon3);
		
		RequestBuilder req = post("/createEntry").contentType(MediaType.APPLICATION_JSON).content(pokeJson);
	
		// Act 
		ResultMatcher checkStatus = status().isCreated(); // Is the status code of our request created? (201) 
		ResultMatcher checkBody = content().string(testPokemon3.getName() + " added to the Pokedex"); // import in result string
		
		// Assert
		mvc.perform(req).andExpect(checkStatus).andExpect(checkBody);
		
	}

@Test
public void testGetEntries() throws Exception {
	
	
	// Arrange
	List<Pokedex> allPokemon = List.of(testPokemonID, testPokemonID2); // creating a list which contains these objects
	
	String allPokemonJson = mapper.writeValueAsString(allPokemon);
	RequestBuilder req = get("/getEntries");
	
	// Act
	ResultMatcher checkStatus = status().isAccepted();
	ResultMatcher checkBody = content().json(allPokemonJson); // If not valid, we'll be able to see the exact response
	
	mvc.perform(req).andExpect(checkStatus).andExpect(checkBody);
	
}

}
