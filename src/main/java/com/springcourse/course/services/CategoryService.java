package com.springcourse.course.services;

import com.springcourse.course.entities.Category;
import com.springcourse.course.repositories.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> findAll(){
        return categoryRepository.findAll();
    }

    public Category findById(Long id){
        return categoryRepository.findById(id).get();
    }
}
