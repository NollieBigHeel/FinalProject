package com.qa.qaFinal.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qa.qaFinal.model.Pokedex;


public interface Repo extends JpaRepository<Pokedex, Long> {
	
	public List<Pokedex> findByName(String name);
	
	public List<Pokedex> findByType(String type);

	

}
