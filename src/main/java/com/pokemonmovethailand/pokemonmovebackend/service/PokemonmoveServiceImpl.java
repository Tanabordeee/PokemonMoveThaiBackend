package com.pokemonmovethailand.pokemonmovebackend.service;

import com.pokemonmovethailand.pokemonmovebackend.dao.PokemonmoveRepository;
import com.pokemonmovethailand.pokemonmovebackend.entity.Pokemonmove;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PokemonmoveServiceImpl implements PokemonmoveService{
    private PokemonmoveRepository pokemonmoveRepository;

    @Autowired
    public  PokemonmoveServiceImpl(PokemonmoveRepository pokemonmoveRepository){
        this.pokemonmoveRepository = pokemonmoveRepository;
    }

    @Override
    public Page<Pokemonmove> findAll(Pageable pageable) {
        return pokemonmoveRepository.findAll(pageable);
    }

    @Override
    public Optional<Pokemonmove> findByName(String name) {
        return pokemonmoveRepository.findbyName(name);
    }

    @Override
    public List<String> findByNameAutoComplete(String keyword) {
        return pokemonmoveRepository.findByNameAutoComplete(keyword);
    }
}
