package files;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductFileManager {

    private List<Product> products = new ArrayList<>();

    public List<Product> readFromFile(Path path) {
        try {
            Scanner scanner = new Scanner(path);
            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                String[] temp = line.split(";");
                String id = temp[0];
                int price = Integer.parseInt(temp[1]);
                int soldCount = 0;
                if (temp.length == 3) {
                    soldCount = Integer.parseInt(temp[2]);
                }
                Product product = new Product(id, price, soldCount);
                products.add(product);
            }
        } catch (IOException e) {
            throw new IllegalArgumentException("Cannot read file!");
        }
        return products;
    }

    public Product findProductWithMaxProfit() {
        if (products.isEmpty()) {
            throw new IllegalStateException();
        }
        Product maxProfit = products.get(0);
        for (Product actualProduct : products) {
            if (actualProduct.getPrice() * actualProduct.getSoldCount() > maxProfit.getPrice() * maxProfit.getSoldCount()) {
                maxProfit = actualProduct;
            }
        }
        return maxProfit;
    }

    public List<Product> getProducts() {
        return products;
    }
}
