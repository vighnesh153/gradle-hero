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
                new Pokemon("Pikachu", Arrays.asList("Electric"), MessageService.generateMessage(),
                        "images/pikachu.png"),
                new Pokemon("Charizard", Arrays.asList("Fire", "Flying"), MessageService.generateMessage(),
                        "images/charizard.png"),
                new Pokemon("Treecko", Arrays.asList("Grass"), MessageService.generateMessage(), "images/treecko.png"),
                new Pokemon("Chikorita", Arrays.asList("Grass"), MessageService.generateMessage(),
                        "images/chikorita.png"))
                .iterator();
    }
}
