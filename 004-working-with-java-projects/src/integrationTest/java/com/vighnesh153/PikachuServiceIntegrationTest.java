package com.vighnesh153;

import org.junit.jupiter.api.Test;

public class PikachuServiceIntegrationTest {
    @Test
    public void testMainMethod() {
        PikachuService.main(new String[]{"pokemonEvolutions"});
    }
}
