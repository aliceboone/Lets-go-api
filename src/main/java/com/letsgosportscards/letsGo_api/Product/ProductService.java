package com.letsgosportscards.letsGo_api.Product;

import com.letsgosportscards.letsGo_api.Category.Category;
import com.letsgosportscards.letsGo_api.Category.CategoryRepository;
import com.letsgosportscards.letsGo_api.Role.Role;
import com.letsgosportscards.letsGo_api.User.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    @Autowired
    public ProductService(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
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

    public void addNewProduct(Product product, Long categoryId) {
        Category category = categoryRepository
                .findById(categoryId)
                .orElseThrow(() -> new IllegalStateException("Category does not exists"));
        Optional<Product> productOptional = productRepository
                .findProductByName(product.getName());
        if (productOptional.isPresent()) {
            throw  new IllegalStateException("name taken");
        }
        product.setCategory(category);
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