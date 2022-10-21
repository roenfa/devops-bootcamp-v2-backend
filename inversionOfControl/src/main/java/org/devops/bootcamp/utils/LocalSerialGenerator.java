package org.devops.bootcamp.utils;

import java.util.Random;

public class LocalSerialGenerator implements INumberGenerator {
    public String generateNumber() {
        return "BO-5665-" + Math.abs(new Random().nextInt());
    }
}