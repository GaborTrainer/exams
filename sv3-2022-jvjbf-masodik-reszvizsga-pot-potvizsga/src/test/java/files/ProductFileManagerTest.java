package files;

import org.junit.jupiter.api.Test;

import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

class ProductFileManagerTest {

    @Test
    void testReadFromFile() {
        ProductFileManager pfm = new ProductFileManager();

        pfm.readFromFile(Path.of("src/test/resources/input.csv"));

        assertEquals(6, pfm.getProducts().size());
    }

    @Test
    void testReadFromNotExistingFile() {
        ProductFileManager pfm = new ProductFileManager();

        IllegalArgumentException iae = assertThrows(IllegalArgumentException.class,
                () -> pfm.readFromFile(Path.of("src/test/resources/input1.csv")));

        assertEquals("Cannot read file!", iae.getMessage());
    }

    @Test
    void testFindProductWithMaxProfit() {
        ProductFileManager pfm = new ProductFileManager();
        pfm.readFromFile(Path.of("src/test/resources/input.csv"));

        Product product = pfm.findProductWithMaxProfit();

        assertEquals(1250, product.getPrice());
    }

    @Test
    void testFindProductsWithMaxProfitWithoutRead() {
        ProductFileManager pfm = new ProductFileManager();
        assertThrows(IllegalStateException.class, () -> pfm.findProductWithMaxProfit());
    }
}