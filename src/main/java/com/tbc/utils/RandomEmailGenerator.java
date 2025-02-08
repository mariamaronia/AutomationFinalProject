package com.tbc.utils;

import java.util.UUID;

public class RandomEmailGenerator {
    public static String generateRandomEmail() {
        return "test" + UUID.randomUUID().toString() + "@gmail.com";
    }
}