package org.example;

import java.util.Collection;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

public class Pinned {

    private final Random random = new Random();

    public Collection<String> generate() {
        return generate(1000);
    }

    private Collection<String> generate(int count) {
        Set<String> elements = new TreeSet<>();
        while (elements.size() != count) {
            int required = count - elements.size();
            for (int i = 0; i < required; i++) {
                elements.add(nextRandomPin());
            }
        }
        return elements;
    }

    private String nextRandomPin() {
        return String.format("%4d", random.nextInt(10000) - 1)
                .replace(' ', '0');
    }
}
