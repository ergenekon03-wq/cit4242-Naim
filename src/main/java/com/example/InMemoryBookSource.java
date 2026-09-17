package com.example;

import java.util.List;

public class InMemoryBookSource implements BookSource {

    @Override
    public List<Book> load() {
        return List.of(
                new Book("Germinal", 591),
                new Book("Bel Ami", 394),
                new Book("Nana", 470)
        );
    }
}