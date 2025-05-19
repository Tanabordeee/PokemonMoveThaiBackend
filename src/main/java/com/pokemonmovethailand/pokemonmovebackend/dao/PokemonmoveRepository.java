package com.pokemonmovethailand.pokemonmovebackend.dao;

import com.pokemonmovethailand.pokemonmovebackend.entity.Pokemonmove;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PokemonmoveRepository extends JpaRepository<Pokemonmove , Integer> ,  PokemonmoveRepositoryCustom{
}
