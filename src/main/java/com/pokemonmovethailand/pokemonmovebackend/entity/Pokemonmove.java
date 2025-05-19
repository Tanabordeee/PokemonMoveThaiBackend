package com.pokemonmovethailand.pokemonmovebackend.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "pokemon")
public class Pokemonmove {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "accuracy")
    private  Integer accuracy;

    @Column(name = "power")
    private  Integer power;

    @Column(name = "damage_class")
    private  String damage_class;

    @Column(name = "pp")
    private  Integer pp;

    @Column(name = "effect")
    private  String effect;

    @Column(name = "type")
    private  String type;

    public  Pokemonmove(){}

    public Pokemonmove(Integer id, String type, String effect, Integer pp, String damage_class, Integer power, Integer accuracy, String name) {
        this.id = id;
        this.type = type;
        this.effect = effect;
        this.pp = pp;
        this.damage_class = damage_class;
        this.power = power;
        this.accuracy = accuracy;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAccuracy() {
        return accuracy;
    }

    public void setAccuracy(Integer accuracy) {
        this.accuracy = accuracy;
    }

    public Integer getPower() {
        return power;
    }

    public void setPower(Integer power) {
        this.power = power;
    }

    public String getDamage_class() {
        return damage_class;
    }

    public void setDamage_class(String damage_class) {
        this.damage_class = damage_class;
    }

    public Integer getPp() {
        return pp;
    }

    public void setPp(Integer pp) {
        this.pp = pp;
    }

    public String getEffect() {
        return effect;
    }

    public void setEffect(String effect) {
        this.effect = effect;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Pokemonmove{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", accuracy=" + accuracy +
                ", power=" + power +
                ", damage_class='" + damage_class + '\'' +
                ", pp=" + pp +
                ", effect='" + effect + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
