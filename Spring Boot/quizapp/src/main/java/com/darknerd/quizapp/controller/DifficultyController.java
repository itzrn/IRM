package com.darknerd.quizapp.controller;

import com.darknerd.quizapp.dto.DifficultyDTO;
import com.darknerd.quizapp.service.DifficultyService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/difficulty")
public class DifficultyController {
    @Autowired
    private DifficultyService difficultyService;

    @PostMapping("/add-new-difficulty")
    public ResponseEntity<String> addNewCategory(@RequestBody @Valid DifficultyDTO difficultyDTO){
        return difficultyService.addNewDifficulty(difficultyDTO);
    }

    @GetMapping("/get-all-difficulties")
    public ResponseEntity<List<DifficultyDTO>> getAllDifficulties(){
        return difficultyService.getAllDifficulties();
    }
}
