package com.vighnesh153;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

public class PokemonTest {
    @Test
    public void setsFieldsCorrectly() {
        Pokemon pokemon = new Pokemon("Pikachu", Arrays.asList("Electric"), "GOAT", "pikachu.png");
        assertEquals("Pikachu", pokemon.name());
        assertEquals(Arrays.asList("Electric"), pokemon.types());
        assertEquals("GOAT", pokemon.message());
        assertEquals("pikachu.png", pokemon.imagePath());
    }
}
