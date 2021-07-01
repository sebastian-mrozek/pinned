package org.example;

import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class PinnedTest {

    Pinned service = new Pinned();

    @Test
    public void testReturns1000Elements() {
        Collection<Short> elements = service.generate();
        assertNotNull(elements);
        assertEquals(1000, elements.size(), "Collection count");
    }

    @Test
    public void testElementsAreUnique() {
        Collection<Short> elements = service.generate();
        assertEquals(1000, new HashSet<>(elements).size());
    }

}
