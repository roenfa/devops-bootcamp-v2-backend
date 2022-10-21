package org.devops.bootcamp;

import org.devops.bootcamp.utils.INumberGenerator;
import org.devops.bootcamp.utils.IsbnGenerator;
import org.devops.bootcamp.utils.LocalSerialGenerator;

public class GeneratorNumberFactory {
    public INumberGenerator getInstance(String location) {

        switch (location) {
            case "BO": return new LocalSerialGenerator();
            default: return new IsbnGenerator();
        }
    }
}
