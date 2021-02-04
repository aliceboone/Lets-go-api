package com.letsgosportscards.letsGo_api.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    public Product showProduct(Long productId) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new IllegalStateException(
                        "Product with ID: " + productId + " does not exist"
                ));
        return product;
    }

    public void addNewProduct(Product product){
        Optional<Product> productOptional = productRepository
                .findProductByName(product.getName());
        if(productOptional.isPresent()) {
            throw new IllegalStateException("product taken");
        }
        productRepository.save(product);
    }

    public void deleteProduct(Long productId) {
        boolean exists = productRepository.existsById(productId);
        if(!exists) {
            throw new IllegalStateException(
                    "product with id" + productId + "does not exist");
        }
        productRepository.deleteById(productId);
    }
}