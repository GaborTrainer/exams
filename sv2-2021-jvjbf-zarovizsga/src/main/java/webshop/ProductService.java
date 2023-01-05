package webshop;

public class ProductService {

    private ProductRepository productRepository;

    public ProductService(ProductRepository repository) {
        this.productRepository = repository;
    }

    public void saleProduct(long id, int amount) {
        Product product = productRepository.findProductById(id);
        if (product.getStock() >= amount) {
            productRepository.updateProductStock(id, amount);
        } else {
            throw new IllegalArgumentException("Not enough pieces.");
        }
    }
}
