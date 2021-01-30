package com.letsgosportscards.letsGo_api.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "letsGo/product")

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

    @PostMapping(consumes = "application/json")
    public void registerNewProduct(@RequestBody Product product) {
        productService.addNewProduct(product);
    }
}
