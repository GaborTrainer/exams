package files;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BookFileManager {

    private List<Book> books = new ArrayList<>();

    public List<Book> getBooks() {
        return books;
    }

    public void readFromFile(Path path) {
        try (Scanner scanner = new Scanner(path)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                processLine(line);
            }
        } catch (IOException e) {
            throw new IllegalArgumentException("Cannot read file!", e);
        }
    }

    private void processLine(String line) {
        String[] temp = line.split(" ");
        String isbn = temp[0];
        String author = temp[1];
        String title = temp[2];
        books.add(new Book(isbn, author, title));
    }

    public Book findBookByIsbn(String isbn) {
//        for (Book actualBook : books) {
//            if (actualBook.getIsbn().equals(isbn)) {
//                return actualBook;
//            }
//        }
//        throw new IllegalArgumentException("Cannot find book with ISBN: " + isbn);
//    }
        return books.stream()
                .filter(book -> book.getIsbn().equals(isbn))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Cannot find book with ISBN: " + isbn));
    }
}
