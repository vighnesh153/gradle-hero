package com.vighnesh153;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class MessageService {
    public static String generateMessage() {
        List<String> messages = Arrays.asList("Pikachu is GOAT", "Charizard is a GOAT too!");
        return messages.get(new Random().nextInt(messages.size()));
    }
}
