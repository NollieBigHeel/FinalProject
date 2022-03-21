package com.qa.qaFinal.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qa.qaFinal.model.Pokedex;

public interface Repo extends JpaRepository<Pokedex, Long> {

	

}
