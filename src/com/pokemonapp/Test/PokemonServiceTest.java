package com.pokemonapp.Test;

import com.pokemonapp.Factory.MapFactory;
import com.pokemonapp.Model.Pokemon;
import com.pokemonapp.Service.PokemonService;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class PokemonServiceTest {

    @Test
    void testAddPokemon() {
        Map<String, Pokemon> map = MapFactory.getMap(1);
        PokemonService service = new PokemonService(map);

        service.addPokemon("Pikachu");
        assertTrue(map.containsKey("Pikachu"));
    }

    @Test
    void testShowPokemon() {
        Map<String, Pokemon> map = MapFactory.getMap(1);
        PokemonService service = new PokemonService(map);
        map.put("Charmander", new Pokemon("Charmander", "Fire", "Blaze"));

        service.showPokemon("Charmander");
    }
}
