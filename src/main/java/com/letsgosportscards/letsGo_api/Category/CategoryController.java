package com.letsgosportscards.letsGo_api.Category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(path = "/category")

public class CategoryController {

    private final CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    //Index
    @GetMapping
    public List<Category> getCategories() {
        return categoryService.getCategories();
    }

    //Show by Id
    @GetMapping(path = "{categoryId}")
    public Category showCategory(@PathVariable("categoryId") Long categoryId) {
        return categoryService.showCategory(categoryId);
    }

    // Create
    @PostMapping(consumes = "application/json")
    public void addCategory(@RequestBody Category category) {
        categoryService.addCategory(category);
    }

    // Update
    @PutMapping(path = "/{categoryId}")
    public void updateCategory(@PathVariable("categoryId") Long categoryId,
                              @RequestBody Category category) {
       categoryService.updateCategory(categoryId, category);
    }

   //Delete
    @DeleteMapping(path = "{categoryId}")
    public void deleteCategory(@PathVariable("categoryId") Long categoryId) {
        categoryService.deleteCategory(categoryId);
    }
}