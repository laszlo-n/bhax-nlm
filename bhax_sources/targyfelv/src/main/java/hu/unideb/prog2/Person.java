package hu.unideb.prog2;

import java.util.stream.Stream;

public class Person {
    private String name;
    private String userID;

    public Person(String name) {
        this.name = name;
        this.userID = Stream.of(name.split("(?=[A-Z])"))
                .reduce((str1, str2) -> str1 + str2)
                .orElse("")
                .toLowerCase()
                .concat(String.format("%d", (int) (Math.random() * 100)));
    }
}
