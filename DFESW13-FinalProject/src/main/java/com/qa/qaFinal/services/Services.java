package com.qa.qaFinal.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.qa.qaFinal.model.Pokedex;
import com.qa.qaFinal.repo.Repo;

@Service
public class Services {
	
	private Repo repo;

	public Services(Repo repo) {
		super();
		this.repo = repo;
	}
	
	public Pokedex createEntry(Pokedex pokedex) {
		Pokedex savedObj = repo.save(pokedex);
		return savedObj;
	}
	
	public List<Pokedex> getEntries() {
		return repo.findAll();
	}

}
