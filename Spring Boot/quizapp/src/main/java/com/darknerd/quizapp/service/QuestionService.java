package com.darknerd.quizapp.service;

import com.darknerd.quizapp.dto.QuestionDTO;
import com.darknerd.quizapp.entity.Category;
import com.darknerd.quizapp.entity.Difficulty;
import com.darknerd.quizapp.entity.Question;
import com.darknerd.quizapp.repository.CategoryRepository;
import com.darknerd.quizapp.repository.DifficultyRepository;
import com.darknerd.quizapp.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class QuestionService {
    @Autowired
    private QuestionRepository questionRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private DifficultyRepository difficultyRepository;

    public ResponseEntity<String> addNewQuestion(QuestionDTO questionDTO){
        Optional<Difficulty> optionalDifficulty = difficultyRepository.findByDifficulty(questionDTO.getDifficulty().toUpperCase());
        Optional<Category> optionalCategory = categoryRepository.findByCategory(questionDTO.getCategory().toUpperCase());


        if(optionalDifficulty.isPresent() && optionalCategory.isPresent()) {

            Difficulty difficulty = optionalDifficulty.get();
            Category category = optionalCategory.get();

            Question question = Question.builder()
                    .questionTitle(questionDTO.getQuestionTitle())
                    .category(category)
                    .difficulty(difficulty)
                    .rightOption(questionDTO.getRightOption())
                    .option1(questionDTO.getOption1())
                    .option2(questionDTO.getOption2())
                    .option3(questionDTO.getOption3())
                    .option4(questionDTO.getOption4())
                    .build();

            questionRepository.save(question);
            return new ResponseEntity<>("Question added successfully", HttpStatus.CREATED);
        }
        return new ResponseEntity<>("SOMETHING WENT WRONG! ADD NEW QUESTION", HttpStatus.BAD_REQUEST);
    }


    public ResponseEntity<List<QuestionDTO>> getAllQuestion() {
        List<Question> questionList = questionRepository.findAll();
        List<QuestionDTO> questionDTOList=new ArrayList<>();
        for (Question questions : questionList){

            questionDTOList.add(QuestionDTO.builder()
                            .questionTitle(questions.getQuestionTitle())
                            .category(questions.getCategory().getCategory())
                            .difficulty(questions.getDifficulty().getDifficulty())
                            .option1(questions.getOption1())
                            .option2(questions.getOption2())
                            .option3(questions.getOption3())
                            .option4(questions.getOption4())
                            .rightOption(questions.getRightOption())
                    .build());

        }

        if(questionDTOList.isEmpty()) return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        return new ResponseEntity<>(questionDTOList, HttpStatus.OK);
    }

    public ResponseEntity<List<QuestionDTO>> getAllQuestionOfDifficulty(String difficultyType){

        Optional<Difficulty> optionalDifficulty = difficultyRepository.findByDifficulty(difficultyType);

        if(optionalDifficulty.isPresent()) {

            List<Question> questionList = optionalDifficulty.get().getQuestions();
            List<QuestionDTO> questionDTOList = new ArrayList<>();
            for (Question questions : questionList) {

                questionDTOList.add(QuestionDTO.builder()
                        .questionTitle(questions.getQuestionTitle())
                        .category(questions.getCategory().getCategory())
                        .difficulty(questions.getDifficulty().getDifficulty())
                        .option1(questions.getOption1())
                        .option2(questions.getOption2())
                        .option3(questions.getOption3())
                        .option4(questions.getOption4())
                        .rightOption(questions.getRightOption())
                        .build());

            }

            if (questionDTOList.isEmpty()) return new ResponseEntity<>(HttpStatus.NO_CONTENT);


            return new ResponseEntity<>(questionDTOList, HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


    public ResponseEntity<List<QuestionDTO>> getAllQuestionOfCategory(String categoryType) {

        Optional<Category> optionalCategory = categoryRepository.findByCategory(categoryType);

        if(optionalCategory.isPresent()) {

            List<Question> questionList = optionalCategory.get().getQuestions();
            List<QuestionDTO> questionDTOList = new ArrayList<>();
            for (Question questions : questionList) {

                questionDTOList.add(QuestionDTO.builder()
                        .questionTitle(questions.getQuestionTitle())
                        .category(questions.getCategory().getCategory())
                        .difficulty(questions.getDifficulty().getDifficulty())
                        .option1(questions.getOption1())
                        .option2(questions.getOption2())
                        .option3(questions.getOption3())
                        .option4(questions.getOption4())
                        .rightOption(questions.getRightOption())
                        .build());

            }

            if (questionDTOList.isEmpty()) return new ResponseEntity<>(HttpStatus.NO_CONTENT);


            return new ResponseEntity<>(questionDTOList, HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }
}
