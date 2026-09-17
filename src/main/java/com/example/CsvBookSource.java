package com.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UncheckedIOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CsvBookSource implements BookSource {

    private final String resource;

    public CsvBookSource(String resource) {
        this.resource = resource;
    }

    @Override
    public List<Book> load() {
        List<Book> books = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(
                        Objects.requireNonNull(
                                getClass().getClassLoader().getResourceAsStream(resource),
                                "Resource not found: " + resource)))) {

            String line;
            boolean firstLine = true;

            while ((line = reader.readLine()) != null) {
                if (firstLine) { firstLine = false; continue; } // skip header
                if (line.isBlank()) continue;

                String[] parts = line.split(";");
                books.add(new Book(
                        parts[0].trim(),
                        Integer.parseInt(parts[1].trim())
                ));
            }

        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }

        return books;
    }
}