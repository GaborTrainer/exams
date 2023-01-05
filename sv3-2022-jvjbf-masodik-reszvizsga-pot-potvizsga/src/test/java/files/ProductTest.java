package files;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {

    @Test
    void testCreateProductWithCount() {
        Product product = new Product("WHEG6572", 3200, 5);

        assertEquals("WHEG6572", product.getId());
        assertEquals(3200, product.getPrice());
        assertEquals(5, product.getSoldCount());
    }

    @Test
    void testCreateProductWithoutCount() {
        Product product = new Product("WHEG6572", 3200);

        assertEquals("WHEG6572", product.getId());
        assertEquals(3200, product.getPrice());
        assertEquals(0, product.getSoldCount());
    }
}