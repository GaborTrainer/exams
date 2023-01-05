package abstractions;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ArticleTest {

    @Test
    void testGetTitle() {
        Content article = new Article(new Header("Important", 10),
                "John Doe",
                List.of("Very important", "Very very important!"));

        assertEquals("Important", article.getTitle());
    }

    @Test
    void testGetImportance() {
        Content article = new Article(new Header("Important", 10),
                "John Doe",
                List.of("Very important", "Very very important!"));

        assertEquals(20, article.getImportance());
    }
}