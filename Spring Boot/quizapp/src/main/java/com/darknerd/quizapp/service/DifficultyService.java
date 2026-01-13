package com.darknerd.quizapp.service;

import com.darknerd.quizapp.dto.DifficultyDTO;
import com.darknerd.quizapp.entity.Difficulty;
import com.darknerd.quizapp.repository.DifficultyRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DifficultyService {

    @Autowired
    private DifficultyRepository difficultyRepository;

    public ResponseEntity<String> addNewDifficulty(@Valid DifficultyDTO difficultyDTO) {
        boolean categoryPresent = difficultyRepository.existsByDifficulty(difficultyDTO.getDifficulty().toUpperCase());
        if(!categoryPresent){
            Difficulty difficulty = Difficulty.builder().
                    difficulty(difficultyDTO.getDifficulty().
                            toUpperCase()).build();

            difficultyRepository.save(difficulty);

            return new ResponseEntity<>("NEW DIFFICULTY CREATED", HttpStatus.CREATED);
        }

        return new ResponseEntity<>("SOMETHING WENT WRONG, TRY TO ADD NEW DIFFICULTY", HttpStatus.BAD_REQUEST);
    }
    public ResponseEntity<List<DifficultyDTO>> getAllDifficulties(){
        List<Difficulty> difficultyList = difficultyRepository.findAll();
        List<DifficultyDTO> difficultyDTOList = new ArrayList<>();
        for(Difficulty difficulty:difficultyList){
            difficultyDTOList.add(DifficultyDTO.builder()
                            .id(difficulty.getId())
                            .difficulty(difficulty.getDifficulty())
                    .build());
        }
        if(difficultyDTOList.isEmpty()) return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        return new ResponseEntity<>(difficultyDTOList, HttpStatus.OK);
    }

}
