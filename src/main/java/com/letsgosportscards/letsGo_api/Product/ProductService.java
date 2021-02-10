
package com.letsgosportscards.letsGo_api.Product;

import com.letsgosportscards.letsGo_api.Category.Category;
import com.letsgosportscards.letsGo_api.Category.CategoryRepository;
import com.letsgosportscards.letsGo_api.model.User;
import com.letsgosportscards.letsGo_api.User.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private final ProductRepository productRepository;
    private final UserRepository userRepository;
    private final CategoryRepository categoryRepository;

    @Autowired
    public ProductService(ProductRepository productRepository, UserRepository userRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.userRepository = userRepository;
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

    public void addNewProduct(Product product, Long categoryId, Long userId) {
        Category category = categoryRepository
                .findById(categoryId)
                .orElseThrow(() -> new IllegalStateException("Category does not exists"));
        User user = userRepository
                .findById(userId)
                .orElseThrow(() -> new IllegalStateException("User does not exists"));
        Optional<Product> productOptional = productRepository
                .findById(product.getId());
        if (productOptional.isPresent()) {
            throw  new IllegalStateException("Not able to add product");
        }
        product.setCategory(category);
        product.setUser(user);
        productRepository.save(product);
    }

    @Transactional
    public void updateProduct(Long productId, Product product) {
        Product checkProduct = productRepository.findById(productId)
                .orElseThrow(() -> new IllegalStateException(
                        "product with id " + productId + " does not exists"
                ));
        checkProduct.setPlayerName( product.getPlayerName());
        checkProduct.setBrand( product.getBrand());
        checkProduct.setCard_number( product.getCard_number());
        checkProduct.setCurrent_value( product.getCurrent_value());
        checkProduct.setSetName( product.getSetName());
        checkProduct.setDescription( product.getDescription());
        checkProduct.setImageUrl( product.getImageUrl());
        checkProduct.setPrice_paid( product.getPrice_paid());
        checkProduct.setPrice_sold( product.getPrice_sold());
        checkProduct.setInventory( product.getInventory());
        checkProduct.setReleaseYear( product.getReleaseYear());
        checkProduct.setCategory( product.getCategory());
        productRepository.save(checkProduct);
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