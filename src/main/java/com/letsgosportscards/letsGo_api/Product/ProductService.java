
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

    public List<Product> getProducts(long userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new IllegalStateException("user does not exist"));
        return user.getProducts();
    }

    public Product showProduct(long userId, long productId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new IllegalStateException("user does not exist"));
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new IllegalStateException(
                        "Product with ID: " + productId + " does not exist"
                ));
        return product;
    }

    public void addNewProduct(Product product, long userId) {
        if(product.getImageUrl1() == null || product.getImageUrl1() == ""){
            product.setImageUrl1("https://i.ibb.co/r5CKkGV/cards-baseball-card-hd.jpg");
        }
        Category category = categoryRepository
                .findCategoryByName(product.getCategory().getName())
                .orElseThrow(() -> new IllegalStateException("Category does not exists"));
        User user = userRepository
                .findById(userId)
                .orElseThrow(() -> new IllegalStateException("User does not exists"));
        Optional<Product> productOptional = productRepository
                .findById(product.getId());
        if (productOptional.isPresent()) {
            throw  new IllegalStateException("Not able to add product");
        }
        category.addProduct(product);
        product.setCategory(category);
        product.setUser(user);
        productRepository.save(product);
    }

    @Transactional
    public void updateProduct(long productId, Product product) {
//        User user = userRepository
//                .findById(userId)
//                .orElseThrow(() -> new IllegalStateException("User does not exists"));
        Category category = categoryRepository
                .findCategoryByName(product.getCategory().getName())
                .orElseThrow(() -> new IllegalStateException("Category does not exists"));
        Product checkProduct = productRepository.findById(productId)
                .orElseThrow(() -> new IllegalStateException(
                        "product with id " + productId + " does not exists"
                ));
        checkProduct.setPlayerName( product.getPlayerName());
        checkProduct.setBrand( product.getBrand());
        checkProduct.setCardNumber( product.getCardNumber());
        checkProduct.setCurrentValue( product.getCurrentValue());
        checkProduct.setSetName( product.getSetName());
        checkProduct.setGradedBy( product.getGradedBy());
        checkProduct.setImageUrl1( product.getImageUrl1());
        checkProduct.setImageUrl2( product.getImageUrl2());
        checkProduct.setPricePaid( product.getPricePaid());
        checkProduct.setPriceSold( product.getPriceSold());
        checkProduct.setReleaseYear( product.getReleaseYear());
        checkProduct.setCategory( category);
        productRepository.save(checkProduct);
    }

    public void deleteProduct(long productId) {
        boolean exists = productRepository.existsById(productId);
        if(!exists) {
            throw new IllegalStateException(
                    "product with id" + productId + "does not exist");
        }
        productRepository.deleteById(productId);
    }
}