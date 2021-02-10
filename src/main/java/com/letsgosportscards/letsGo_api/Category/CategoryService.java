
package com.letsgosportscards.letsGo_api.Category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> getCategories() {
        return categoryRepository.findAll();
    }

    public Category showCategory(Long categoryId) {
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new IllegalStateException(
                        "Category with ID: " + categoryId + " does not exist"
                ));
        return category;
    }

    public void addCategory(Category category) {
        Optional<Category> categoryOptional = categoryRepository
                .findCategoryByName(category.getName());
        if (categoryOptional.isPresent()) {
            throw  new IllegalStateException("name taken");
        }
        categoryRepository.save(category);
    }

    public void deleteCategory(Long categoryId) {
        boolean exists = categoryRepository.existsById(categoryId);
        if(!exists) {
            throw new IllegalStateException(
                    "category with id" + categoryId + "does not exist");
        }
        categoryRepository.deleteById(categoryId);
    }

    public void updateCategory(Long categoryId, Category category) {
        Category checkCategory = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new IllegalStateException(
                        "category with id " + categoryId + " does not exists"
                ));
        checkCategory.setName(category.getName());
        categoryRepository.save( checkCategory);
    }
}
