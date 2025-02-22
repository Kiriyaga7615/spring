package org.example.model;

import java.util.HashSet;
import java.util.Set;

public class Cart {
    private Set<Product> products = new HashSet<>();

    public void addProduct(Product product) {
        products.add(product);
    }

    public void removeProduct(Long id) {
        products.removeIf(product -> product.getId().equals(id));
    }

    public Set<Product> getProducts() {
        return products;
    }

    @Override
    public String toString() {
        return "Cart{products=" + products + '}';
    }
}
