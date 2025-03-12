package com.pokemonapp.Model;

public class Pokemon {
    private String name;
    private String type1;
    private String ability;

    public Pokemon(String name, String type1, String ability) {
        this.name = name;
        this.type1 = type1;
        this.ability = ability;
    }

    public String getName() { return name; }
    public String getType1() { return type1; }
    public String getAbility() { return ability; }

    @Override
    public String toString() {
        return "Pokemon{name='" + name + "', type1='" + type1 + "', ability='" + ability + "'}";
    }
}
