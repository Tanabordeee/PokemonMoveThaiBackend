package com.pokemonmovethailand.pokemonmovebackend.dao;

import com.pokemonmovethailand.pokemonmovebackend.entity.Pokemonmove;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class PokemonmoveRepositoryImpl implements  PokemonmoveRepositoryCustom{
    private EntityManager entityManager;
    @Autowired
    public  PokemonmoveRepositoryImpl(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    @Override
    public Optional<Pokemonmove> findbyName(String name) {
        try{
            // ให้ใช้ชื่อ Class Entity ในการ Query
            Pokemonmove move = entityManager.createQuery(
                            "FROM Pokemonmove p WHERE p.name = :thename", Pokemonmove.class
                    ).setParameter("thename", name)
                    .getSingleResult();
            return  Optional.of(move);
        }catch (NoResultException e){
            return  Optional.empty();
        }
    }

    @Override
    public List<String> findByNameAutoComplete(String keyword) {
        return entityManager.createQuery(
                        "SELECT p.name FROM Pokemonmove p WHERE p.name LIKE :keyword", String.class)
                .setParameter("keyword", keyword + "%")
                .setMaxResults(10)
                .getResultList();
    }
}
