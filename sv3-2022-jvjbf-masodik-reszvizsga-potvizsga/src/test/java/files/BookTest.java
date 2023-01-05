package files;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookTest {

    @Test
    void testCreateBook() {
        Book book = new Book("723631", "Tolkien", "Fellowship of the ring");

        assertEquals("723631", book.getIsbn());
        assertEquals("Tolkien", book.getAuthor());
        assertEquals("Fellowship of the ring", book.getTitle());
    }
}