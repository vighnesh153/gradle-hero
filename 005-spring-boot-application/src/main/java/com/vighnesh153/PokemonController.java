package com.vighnesh153;

import java.util.Arrays;
import java.util.Iterator;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PokemonController {
    @GetMapping(path = "/pokemons")
    public Iterator<Pokemon> getRides() {
        return Arrays.asList(
                new Pokemon("Pikachu", Arrays.asList("Electric")),
                new Pokemon("Charizard", Arrays.asList("Fire", "Flying")),
                new Pokemon("Treeko", Arrays.asList("Grass")),
                new Pokemon("Chikorita", Arrays.asList("Grass"))).iterator();
    }
}
