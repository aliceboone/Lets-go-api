package com.letsgosportscards.letsGo_api.Category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(path = "/api/category")

public class CategoryController {

    private final CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }
//    Index
    @GetMapping
    public List<Category> getCategories() {
        return categoryService.getCategories();
    }
    //Show
    @GetMapping(path = "{categoryId}")
    public Category showCategory(@PathVariable("categoryId") Long categoryId) {
        return categoryService.showCategory(categoryId);
    }
//    Create
    @PostMapping(consumes = "application/json")
    public void registerNewCategory(@RequestBody Category category) {
        categoryService.addNewCategory(category);
    }
   //Delete
    @DeleteMapping(path = "{categoryId}")
    public void deleteCategory(@PathVariable("categoryId") Long categoryId) {
        categoryService.deleteCategory(categoryId);
    }
}