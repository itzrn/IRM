package com.darknerd.quiz_app_question_service.service;

import com.darknerd.quiz_app_question_service.dto.AnswerWrapperDTO;
import com.darknerd.quiz_app_question_service.dto.QuestionDTO;
import com.darknerd.quiz_app_question_service.dto.QuestionResponseDTO;
import com.darknerd.quiz_app_question_service.entity.Category;
import com.darknerd.quiz_app_question_service.entity.Difficulty;
import com.darknerd.quiz_app_question_service.entity.Question;
import com.darknerd.quiz_app_question_service.repository.CategoryRepository;
import com.darknerd.quiz_app_question_service.repository.DifficultyRepository;
import com.darknerd.quiz_app_question_service.repository.QuestionRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Slf4j
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

        Optional<Category> optionalCategory = categoryRepository.findByCategory(categoryType.toUpperCase());

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

    public ResponseEntity<List<Long>> getQuestionsForQuiz(String categoryType, Integer numQ) {

        Optional<Category> optionalCategory = categoryRepository.findByCategory(categoryType.toUpperCase());
        if(optionalCategory.isEmpty()) {
            log.info("THE PROVIDED CATEGORY QUESTIONS ARE NOT AVAILABLE ========================");
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        List<Long> questionsId = questionRepository.findRandomQuestionsByCategory(optionalCategory.get().getId(), numQ);

        if(questionsId.isEmpty()){
            log.info("NO QUESTIONS ARE AVAILABLE IN PROVIDED CATEGORY ====================");
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(questionsId, HttpStatus.OK);
    }

    public ResponseEntity<List<QuestionResponseDTO>> getQuestionFromId(List<Long> questionsIds) {
        List<QuestionResponseDTO> questionList = new ArrayList<>();

        for(Long id:questionsIds){
            Optional<Question> question = questionRepository.findById(id);
            question.ifPresent(value -> questionList.add(QuestionResponseDTO.builder()
                    .id(value.getId())
                    .questionTitle(value.getQuestionTitle())
                    .option1(value.getOption1())
                    .option2(value.getOption2())
                    .option3(value.getOption3())
                    .option4(value.getOption4())
                    .build()));
        }

        return new ResponseEntity<>(questionList, HttpStatus.OK);
    }

    public ResponseEntity<Integer> getScore(List<AnswerWrapperDTO> answerWrapperDTOS) {
        int rightAnswerCount=0;

        for(AnswerWrapperDTO answerWrapperDTO : answerWrapperDTOS){

            Integer  rightAnswer=questionRepository.getRightAnswerForGivenQuestionId(answerWrapperDTO.getId());

            if(Objects.equals(rightAnswer, answerWrapperDTO.getAnswer())){
                rightAnswerCount++;
            }
        }

        int score = (int)(((double)rightAnswerCount/answerWrapperDTOS.size())*100);
        return new ResponseEntity<>(score, HttpStatus.OK);
    }
}