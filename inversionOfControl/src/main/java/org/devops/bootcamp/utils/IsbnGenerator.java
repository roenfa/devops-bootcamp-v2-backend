package org.devops.bootcamp.utils;

import java.util.Random;

/**
 * International Standard Book Number
 */
public class IsbnGenerator implements INumberGenerator {

    public String generateNumber() {
        return "SS-83256-" + Math.abs(new Random().nextInt());
    }
}