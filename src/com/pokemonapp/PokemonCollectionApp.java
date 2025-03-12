package com.pokemonapp;

import com.pokemonapp.Factory.MapFactory;
import com.pokemonapp.Model.Pokemon;
import com.pokemonapp.Service.PokemonService;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.Scanner;

public class PokemonCollectionApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Seleccione el tipo de Mapa: 1) HashMap 2) TreeMap 3) LinkedHashMap");
        int choice = scanner.nextInt();

        Map<String, Pokemon> pokemonMap = MapFactory.getMap(choice);
        loadPokemonData(pokemonMap);

        PokemonService service = new PokemonService(pokemonMap);

        while (true) {
            System.out.println("1. Agregar pokemon\n2. Mostrar datos de un pokemon\n3. Mostrar colección ordenada por tipo\n4. Mostrar todos los pokemons ordenados por tipo\n5. Buscar por habilidad\n6. Salir");
            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    System.out.println("Ingrese el nombre del pokemon a agregar:");
                    String name = scanner.nextLine();
                    service.addPokemon(name);
                    break;
                case 2:
                    System.out.println("Ingrese el nombre del pokemon a mostrar:");
                    name = scanner.nextLine();
                    service.showPokemon(name);
                    break;
                case 3:
                    service.showUserCollectionByType();
                    break;
                case 4:
                    service.showAllPokemonByType();
                    break;
                case 5:
                    System.out.println("Ingrese la habilidad a buscar:");
                    String ability = scanner.nextLine();
                    service.showPokemonByAbility(ability);
                    break;
                case 6:
                    System.out.println("Saliendo...");
                    return;
                default:
                    System.out.println("Opción no válida");
            }
        }
    }

    private static void loadPokemonData(Map<String, Pokemon> pokemonMap) {
        String filePath = "pokemon_data_pokeapi.csv";
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            br.readLine(); // Saltar encabezado
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length >= 3) {
                    String name = data[0];
                    String type1 = data[1];
                    String ability = data[2];
                    pokemonMap.put(name, new Pokemon(name, type1, ability));
                }
            }
            System.out.println("Datos de Pokémon cargados correctamente.");
        } catch (IOException e) {
            System.err.println("Error al leer el archivo CSV: " + e.getMessage());
        }
    }
}
