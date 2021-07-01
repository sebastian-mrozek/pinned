package org.example;

public class PinnedApp {

    public static void main(String[] args) {
        System.out.println();
        new Pinned().generate().forEach(System.out::println);
    }
}
