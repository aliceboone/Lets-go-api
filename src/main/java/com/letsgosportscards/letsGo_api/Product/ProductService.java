package com.letsgosportscards.letsGo_api.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
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

    @Transactional
    public void updateProduct(Long id,
                             String name,
                             String brand,
                             String description,
                             double price,
                             int releaseYear,
                             String imageUrl,
                             int inventory) {

        Product product = productRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException(
                        "product with id " + id + " does not exists"
                ));
        if (name != null && name.length() > 0 ) {
            product.setName(name);
        }
        if (brand != null && brand .length() > 0 ) {
            product.setBrand(brand );
        }
        if (description != null && description.length() > 0 ) {
            product.setDescription(description);
        }
        if (imageUrl!= null && imageUrl.length() > 0 ) {
            product.setImageUrl(imageUrl);
        }

        product.setPrice(price);
        product.setReleaseYear(releaseYear);
        product.setInventory(inventory);
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