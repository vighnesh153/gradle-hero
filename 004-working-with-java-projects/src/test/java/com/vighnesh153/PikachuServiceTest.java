package com.vighnesh153;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PikachuServiceTest {
    @ParameterizedTest(name = "{index} gets {0} pikachu's stat")
    @ValueSource(strings = {"pokemonType", "pokemonEvolutions"})
    public void getPikachuStat(String statType) {
        PikachuService pikachuService = new PikachuService();
        String pikachuStatValue = pikachuService.getParamValue(statType);
        assertNotNull(pikachuStatValue);
    }

    @Test
    public void unknownPikachuStatNameCausesFailure() {
        PikachuService pikachuService = new PikachuService();

        assertThrows(IllegalArgumentException.class, () -> {
            pikachuService.getParamValue("health");
        });
    }
}