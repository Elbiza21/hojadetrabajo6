package com.pokemonapp.Test;

import com.pokemonapp.Factory.MapFactory;
import com.pokemonapp.Model.Pokemon;
import com.pokemonapp.Service.PokemonService;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
class MapFactoryTest {

    @Test
    void testGetMapHashMap() {
        Map<String, Pokemon> map = MapFactory.getMap(1);
        assertNotNull(map);
        assertEquals(java.util.HashMap.class, map.getClass());
    }

    @Test
    void testGetMapTreeMap() {
        Map<String, Pokemon> map = MapFactory.getMap(2);
        assertNotNull(map);
        assertEquals(java.util.TreeMap.class, map.getClass());
    }
}
