package org.example.repositorz;

import org.example.model.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProductRepository {
    private List<Product> products = new ArrayList<>();

    public ProductRepository() {
        products.add(new Product(1L, "Apple", 0.99));
        products.add(new Product(2L, "Banana", 0.59));
        products.add(new Product(3L, "Cherry", 2.99));
    }

    public List<Product> getAllProducts() {
        return products;
    }

    public Optional<Product> getProductById(Long id) {
        return products.stream().filter(product -> product.getId().equals(id)).findFirst();
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public boolean updateProduct(Long id, Product updatedProduct) {
        Optional<Product> productOpt = getProductById(id);
        if (productOpt.isPresent()) {
            Product product = productOpt.get();
            product.setName(updatedProduct.getName());
            product.setPrice(updatedProduct.getPrice());
            return true;
        }
        return false;
    }

    public boolean deleteProduct(Long id) {
        return products.removeIf(product -> product.getId().equals(id));
    }
}
