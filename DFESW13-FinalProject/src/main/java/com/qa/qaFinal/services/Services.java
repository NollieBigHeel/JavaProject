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

	public Pokedex getById(long id) {
		
		return repo.findById(id).get();
	}
	
	
	
	
	public boolean update(long id, Pokedex pokedex) {
		
		
		Pokedex oldEntry = getById(id);
		oldEntry.setName(pokedex.getName());
		oldEntry.setType(pokedex.getType());
		oldEntry.setHp(pokedex.getHp());
		oldEntry.setDescription(pokedex.getDescription());
	
		Pokedex updatedPokemon = oldEntry;
		
		repo.save(updatedPokemon);
		return true;
		
		
		
	}

	public boolean remove(long id) {
		repo.deleteById(id);
		return true;
		
	}

}
