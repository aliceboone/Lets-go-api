package com.letsgosportscards.letsGo_api.Product;

import com.letsgosportscards.letsGo_api.User.UserRepository;
import com.letsgosportscards.letsGo_api.exception.ResourceNotFoundException;
import com.letsgosportscards.letsGo_api.model.User;
import com.letsgosportscards.letsGo_api.security.CurrentUser;
import com.letsgosportscards.letsGo_api.security.UserPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/product")
public class ProductController {

    private final ProductService productService;
    private final UserRepository userRepository;

    @Autowired
    public ProductController(ProductService productService, UserRepository userRepository) {
        this.productService = productService;
        this.userRepository = userRepository;
    }

    // Index
    @GetMapping
    public List<Product> getProducts(@CurrentUser UserPrincipal userPrincipal) {
        User user = userRepository.findById(userPrincipal.getId())
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", userPrincipal.getId()));

        return productService.getProducts();
    }
    //Show
    @GetMapping(path = "/{productId}")
    public Product showProduct(@PathVariable("productId") long productId) {
        return productService.showProduct(productId);
    }

    //Create
    @PostMapping(consumes = "application/json")
    public void addProduct(@CurrentUser UserPrincipal userPrincipal, @RequestBody Product product) {
        User user = userRepository.findById(userPrincipal.getId())
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", userPrincipal.getId()));
        productService.addNewProduct(product, user.getId());
    }

    // Update
    @PutMapping(path = "/{productId}")
    public void updateProduct(@PathVariable("productId") long productId,
                              @RequestBody Product product) {
        productService.updateProduct(productId, product);
    }

    //Delete
    @DeleteMapping(path = "{productId}")
    public void deleteProduct(@PathVariable("productId") long productId) {
        productService.deleteProduct(productId);
    }

}
