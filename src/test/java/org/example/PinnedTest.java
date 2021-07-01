package org.example;

import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.HashSet;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

public class PinnedTest {

    Pinned service = new Pinned();

    @Test
    public void testReturns1000Elements() {
        Collection<String> elements = service.generate();
        assertNotNull(elements);
        assertEquals(1000, elements.size(), "Collection count");
    }

    @Test
    public void testElementsAreUnique() {
        Collection<String> elements = service.generate();
        assertEquals(1000, new HashSet<>(elements).size());
    }

    @Test void testElementsAre4Digits() {
        Collection<String> failed = service.generate().stream()
                .map(String::trim)
                .filter(this::isNotFourDigit)
                .collect(Collectors.toList());
        assertTrue(failed.isEmpty(), "There are " + failed.size() + " pin numbers that are not 4-digit: " + failed);
    }

    private boolean isNotFourDigit(String s) {
        return s.length() != 4 || !isDigitsOnly(s);
    }

    private boolean isDigitsOnly(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

}
