package com.darknerd.quiz_app_question_service.controller;

import com.darknerd.quiz_app_question_service.dto.CategoryDTO;
import com.darknerd.quiz_app_question_service.service.CategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping("/add-new-category")
    public ResponseEntity<String> addNewCategory(@RequestBody @Valid CategoryDTO categoryDTO){
        return categoryService.addNewCategory(categoryDTO);
    }

    @GetMapping("/get-all-category")
    public ResponseEntity<List<CategoryDTO>> getAllCategory(){
        return categoryService.getAllCategory();
    }

}