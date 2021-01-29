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

    public void addNewCategory(Category category) {
        Optional<Category> categoryOptional = categoryRepository
                .findCategoryByName(category.getName());
       if (categoryOptional.isPresent()) {
           throw  new IllegalStateException("name taken");
       }
       categoryRepository.save(category);
    }
}
