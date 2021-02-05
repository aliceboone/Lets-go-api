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

    @GetMapping
    public List<Product> getProducts() {
        return productService.getProducts();
    }

    @GetMapping(path = "{productId}")
    public Product showProduct(@PathVariable("productId") Long productId) {
        return productService.showProduct(productId);
    }

    @PutMapping(path = "{productId}")
    public void updateProduct(
            @PathVariable("productId") Long id,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String brand,
            @RequestParam(required = false) String description,
            @RequestParam(required = false) double price,
            @RequestParam(required = false) int releaseYear,
            @RequestParam(required = false) String imageUrl,
            @RequestParam(required = false) int inventory) {

        productService.updateProduct(id, name, brand,
                description, price, releaseYear, imageUrl, inventory);
    }



    @PostMapping(consumes = "application/json")
    public void registerNewProduct(@RequestBody Product product) {
        productService.addNewProduct(product);
    }

    @DeleteMapping(path = "{productId}")
    public void deleteProduct(@PathVariable("productId") Long productId) {
        productService.deleteProduct(productId);
    }
}