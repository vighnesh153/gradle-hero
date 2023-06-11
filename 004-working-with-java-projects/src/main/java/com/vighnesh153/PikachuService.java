package com.vighnesh153;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.apache.commons.lang3.StringUtils;

public class PikachuService {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Parameter name should be provided");
            System.exit(1);
        }

        String parameterName = StringUtils.trim(args[0]);
        String paramValue = getParamValue(parameterName);

        System.out.printf("Pikachu's '%s' stat value is '%s'", parameterName, paramValue);
    }

    public static String getParamValue(String parameterName) {
        List<String> paramValues = readFile(String.format("%s.txt", parameterName));
        return paramValues.get(new Random().nextInt(paramValues.size()));
    }

    private static List<String> readFile(String filename) {
        InputStream resourceStream = PikachuService.class.getClassLoader().getResourceAsStream(filename);
        if (resourceStream == null) {
            throw new IllegalArgumentException("Stat not found. Choose one of 'pokemonEvolutions', 'pokemonType'");
        }

        List<String> result = new ArrayList<>();
        try (BufferedReader bufferedInputStream = new BufferedReader(new InputStreamReader(resourceStream, StandardCharsets.UTF_8))) {
            while (bufferedInputStream.ready()) {
                result.add(bufferedInputStream.readLine());
            }
        } catch (IOException exception) {
            throw new RuntimeException("Couldn't read file", exception);
        }

        return result;
    }
}