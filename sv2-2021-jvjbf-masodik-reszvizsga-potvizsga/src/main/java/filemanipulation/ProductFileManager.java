package filemanipulation;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class ProductFileManager {

    private List<Product> products = new ArrayList<>();

    public List<Product> getProducts() {
        return products;
    }

    public void readProductsFromFile(Path path) {
        try (Stream<String> stream = Files.lines(path)) {
            stream.forEach(this::processLine);
        } catch (IOException ioe) {
            throw new IllegalStateException("Can't read file!", ioe);
        }
    }

    private void processLine(String line) {
        String[] temp = line.split(";");
        products.add(new Product(Integer.parseInt(temp[0]), temp[1], Integer.parseInt(temp[2])));
    }

    public void writePriceOverToFile(Path path, int price) {
        try {
            Files.write(path, getExpensiveProducts(price));
        } catch (IOException ioe) {
            throw new IllegalStateException("Can not write file", ioe);
        }
    }

    private List<String> getExpensiveProducts(int price) {
        return products.stream()
                .filter(p -> p.getPrice() > price)
                .map(Product::toString)
                .toList();
    }
}
