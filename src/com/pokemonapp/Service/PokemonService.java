package com.pokemonapp.Service;

import com.pokemonapp.Model.Pokemon;

import java.util.Map;

public class PokemonService {
    private Map<String, Pokemon> pokemonMap;

    public PokemonService(Map<String, Pokemon> pokemonMap) {
        this.pokemonMap = pokemonMap;
    }

    public void addPokemon(String name) {
        if (pokemonMap.containsKey(name)) {
            System.out.println("El pokemon ya está en la colección");
        } else {
            Pokemon pokemon = new Pokemon(name, "TypeExample", "AbilityExample");
            pokemonMap.put(name, pokemon);
            System.out.println("Pokemon agregado: " + name);
        }
    }

    public void showPokemon(String name) {
        Pokemon pokemon = pokemonMap.get(name);
        if (pokemon != null) {
            System.out.println(pokemon);
        } else {
            System.out.println("Pokemon no encontrado");
        }
    }

    public void showUserCollectionByType() {
        pokemonMap.values().stream()
                .sorted((p1, p2) -> p1.getType1().compareTo(p2.getType1()))
                .forEach(p -> System.out.println(p.getName() + " - " + p.getType1()));
    }

    public void showAllPokemonByType() {
        showUserCollectionByType();
    }

    public void showPokemonByAbility(String ability) {
        pokemonMap.values().stream()
                .filter(p -> p.getAbility().equalsIgnoreCase(ability))
                .forEach(p -> System.out.println(p.getName()));
    }
}
