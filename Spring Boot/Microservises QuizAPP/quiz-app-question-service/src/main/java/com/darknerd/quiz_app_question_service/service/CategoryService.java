package com.darknerd.quiz_app_question_service.service;


import com.darknerd.quiz_app_question_service.dto.CategoryDTO;
import com.darknerd.quiz_app_question_service.entity.Category;
import com.darknerd.quiz_app_question_service.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public ResponseEntity<String> addNewCategory(CategoryDTO categoryDTO){
        boolean categoryPresent = categoryRepository.existsByCategory(categoryDTO.getCategory().toUpperCase());
        if(!categoryPresent){
            Category category = Category.builder().
                    category(categoryDTO.getCategory().
                            toUpperCase()).build();

            categoryRepository.save(category);

            return new ResponseEntity<>("NEW CATEGORY CREATED", HttpStatus.CREATED);
        }

        return new ResponseEntity<>("SOMETHING WENT WRONG, TRY TO ADD NEW CATEGORY", HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<List<CategoryDTO>> getAllCategory() {
        List<Category> categoryList = categoryRepository.findAll();
        if(categoryList.isEmpty()) return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        List<CategoryDTO> categoryDTOList = new ArrayList<>();

        for(Category category:categoryList){
            categoryDTOList.add(CategoryDTO.builder()
                    .category(category.getCategory())
                    .id(category.getId())
                    .build());
        }

        return new ResponseEntity<>(categoryDTOList, HttpStatus.OK);
    }


}