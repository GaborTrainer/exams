package files;

import org.junit.jupiter.api.Test;

import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

class BookFileManagerTest {

    BookFileManager bookFileManager = new BookFileManager();

    @Test
    void testReadFromFIle() {
        bookFileManager.readFromFile(Path.of("src/test/resources/input.txt"));
        assertEquals(7, bookFileManager.getBooks().size());
        assertEquals("Tolkien", bookFileManager.getBooks().get(6).getAuthor());
    }

    @Test
    void testReadFromFileBadInput() {
        IllegalArgumentException iae = assertThrows(IllegalArgumentException.class,
                () -> bookFileManager.readFromFile(Path.of("src/test/resources/input1.txt")));

        assertEquals("Cannot read file!", iae.getMessage());
    }

    @Test
    void testFindBookByIsbn() {
        bookFileManager.readFromFile(Path.of("src/test/resources/input.txt"));
        Book book = bookFileManager.findBookByIsbn("67238123");

        assertEquals("Da_Vinci_Code", book.getTitle());
    }

    @Test
    void testFIndBookByIsbnNotInList() {
        bookFileManager.readFromFile(Path.of("src/test/resources/input.txt"));

        IllegalArgumentException iae = assertThrows(IllegalArgumentException.class,
                () -> bookFileManager.findBookByIsbn("672381232"));

        assertEquals("Cannot find book with ISBN: 672381232", iae.getMessage());
    }
}