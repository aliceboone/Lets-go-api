package com.letsgosportscards.letsGo_api.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping

public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {

        this.productService = productService;
    }

    @GetMapping(path = "/product")
    public List<Product> getProducts() {
        return productService.getProducts();
    }

    @PostMapping(path="/user_account/{id}/product")
    public void registerNewProduct(@RequestBody Product product) {
        productService.addNewProduct(product);
    }
}
