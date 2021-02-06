package com.letsgosportscards.letsGo_api.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/product")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    //    Index
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
    @PostMapping(path = "/category/{categoryId}",  consumes = "application/json")
    public void registerNewProduct(@PathVariable("categoryId") Long categoryId,  @RequestBody Product product) {
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