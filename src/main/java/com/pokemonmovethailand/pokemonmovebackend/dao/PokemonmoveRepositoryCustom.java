package com.pokemonmovethailand.pokemonmovebackend.dao;

import com.pokemonmovethailand.pokemonmovebackend.entity.Pokemonmove;

import java.util.List;
import java.util.Optional;

public interface PokemonmoveRepositoryCustom {
    Optional<Pokemonmove> findbyName(String name);
    List<String> findByNameAutoComplete(String keyword);
}
