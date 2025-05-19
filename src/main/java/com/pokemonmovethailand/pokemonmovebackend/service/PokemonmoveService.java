package com.pokemonmovethailand.pokemonmovebackend.service;

import com.pokemonmovethailand.pokemonmovebackend.entity.Pokemonmove;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public  interface PokemonmoveService {
    Page<Pokemonmove> findAll(Pageable pageable);
    Optional<Pokemonmove> findByName(String name);
    List<String> findByNameAutoComplete(String keyword);
}
