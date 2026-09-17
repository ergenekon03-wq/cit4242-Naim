package com.example.cit4242_Naim;

import com.example.Book;
import com.example.BookSource;
import com.example.InMemoryBookSource;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class BookSourceTest {

    @Test
    void loadsThreeBooksFromMemory() {
        BookSource source = new InMemoryBookSource();
        List<Book> books = source.load();

        assertEquals(3, books.size());
        assertFalse(books.isEmpty());
    }

    @Test
    void inMemoryBooksHaveTitles() {
        BookSource source = new InMemoryBookSource();
        List<Book> books = source.load();

        for (Book b : books) {
            assertFalse(b.title().isBlank());
        }
    }

    @Test
    void firstBookIsGerminal() {
        BookSource source = new InMemoryBookSource();
        List<Book> books = source.load();

        assertEquals("Germinal", books.get(0).title());
    }
}