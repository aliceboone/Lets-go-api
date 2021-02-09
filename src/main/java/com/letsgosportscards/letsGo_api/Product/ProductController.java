package com.letsgosportscards.letsGo_api.Product;

import com.letsgosportscards.letsGo_api.Category.CategoryRepository;
//import com.letsgosportscards.letsGo_api.User.UserRepository;
import com.letsgosportscards.letsGo_api.User.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/product")
public class ProductController {

    private final ProductService productService;
    private final CategoryRepository categoryRepository;
//    private final UserRepository userRepository;

    @Autowired
    public ProductController(ProductService productService, CategoryRepository categoryRepository) {
        this.productService = productService;
        this.categoryRepository = categoryRepository;
//        this.userRepository = userRepository;
    }

    // Index
    @GetMapping
    public List<Product> getProducts() {
        return productService.getProducts();
    }
    //Show
    @GetMapping(path = "/{productId}")
    public Product showProduct(@PathVariable("productId") Long productId) {
        return productService.showProduct(productId);
    }

    //Create
    @PostMapping(path = "/category/{categoryId}}",  consumes = "application/json")
    public void addNewProduct(@PathVariable("categoryId") Long categoryId, @RequestBody Product product) {
        productService.addNewProduct(product, categoryId);
    }

    // Update
    @PutMapping(path = "/{productId}")
    public void updateProduct(@PathVariable("productId") Long productId,
                            @RequestBody Product product) {
        productService.updateProduct(productId, product);
    }

    //Delete
    @DeleteMapping(path = "{productId}")
    public void deleteProduct(@PathVariable("productId") Long productId) {
        productService.deleteProduct(productId);
    }

}

