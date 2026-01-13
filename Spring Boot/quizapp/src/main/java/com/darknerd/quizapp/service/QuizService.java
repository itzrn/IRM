package com.darknerd.quizapp.service;

import com.darknerd.quizapp.dto.AnswerWrapperDTO;
import com.darknerd.quizapp.dto.QuestionResponseDTO;
import com.darknerd.quizapp.dto.QuizDTO;
import com.darknerd.quizapp.entity.Category;
import com.darknerd.quizapp.entity.Question;
import com.darknerd.quizapp.entity.Quiz;
import com.darknerd.quizapp.repository.CategoryRepository;
import com.darknerd.quizapp.repository.QuestionRepository;
import com.darknerd.quizapp.repository.QuizRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;

@Slf4j
@Service
public class QuizService {

    @Autowired
    private QuizRepository quizRepository;
    @Autowired
    private QuestionRepository questionRepository;
    @Autowired
    private CategoryRepository categoryRepository;


    public ResponseEntity<String> createQuiz(String category, int numQ, String title) {
        Optional<Category> optionalCategory = categoryRepository.findByCategory(category);

        if(!optionalCategory.isPresent()) return new ResponseEntity<>("QUESTIONS OF "+category+" IS NOT AVAILABLE!", HttpStatus.NO_CONTENT);

        List<Question> questionList = questionRepository.findRandomQuestionsByCategory(optionalCategory.get().getId(), numQ);

        Quiz quiz = Quiz.builder()
                .title(title)
                .questions(questionList)
                .build();

        quizRepository.save(quiz);

        return new ResponseEntity<>(title+" QUIZ SUCCESSFULLY CREATED", HttpStatus.CREATED);
    }

    public ResponseEntity<?> getQuizQuestions(String quizName) {

        Optional<Quiz> optionalQuiz = quizRepository.findByTitle(quizName);

        if(optionalQuiz.isEmpty()) return new ResponseEntity<>("PLEASE CREATE THE QUIZ WITH QUIZ NAME "+quizName, HttpStatus.NOT_FOUND);

        List<Question> questionList = optionalQuiz.get().getQuestions();

        List<QuestionResponseDTO> questionDTOList = new ArrayList<>();

        for(Question question : questionList){

            questionDTOList.add(
                    QuestionResponseDTO.builder()
                            .id(question.getId())
                            .questionTitle(question.getQuestionTitle())
                            .option1(question.getOption1())
                            .option2(question.getOption2())
                            .option3(question.getOption3())
                            .option4(question.getOption4())
                            .build()
            );

        }
        return new ResponseEntity<>(questionDTOList, HttpStatus.OK);
    }

    public ResponseEntity<List<QuizDTO>> getAllQuiz() {
        List<Quiz> quizList = quizRepository.findAll();
        if(quizList.isEmpty()) return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        List<QuizDTO> quizDTOList = new ArrayList<>();
        for(Quiz quiz:quizList){
            quizDTOList.add(
                    QuizDTO.builder()
                            .id(quiz.getId())
                            .title(quiz.getTitle())
                            .build()
            );
        }
        return new ResponseEntity<>(quizDTOList, HttpStatus.OK);
    }

    public ResponseEntity<?> calculateResult(String quizName, List<AnswerWrapperDTO> answers) {
        Optional<Quiz> optionalQuiz = quizRepository.findByTitle(quizName);
        if(optionalQuiz.isEmpty()) return new ResponseEntity<>("REQUESTING A WRONG QUIZ", HttpStatus.BAD_REQUEST);
        List<Question> questionList = optionalQuiz.get().getQuestions();

        Map<Long, Integer> correctAnswer=new HashMap<>();
        for(Question question:questionList){
            correctAnswer.put(question.getId(), question.getRightOption());
        }

        int correctCount = 0;

        for(AnswerWrapperDTO answerWrapperDTO : answers){
            if(!correctAnswer.containsKey(answerWrapperDTO.getId())) return new ResponseEntity<>("THERE IS NO SUCH QUESTION AVAILABLE WITH QUESTION ID: "+answerWrapperDTO.getId(), HttpStatus.NOT_FOUND);


            if(Objects.equals(correctAnswer.get(answerWrapperDTO.getId()), answerWrapperDTO.getAnswer())) {
                correctCount++;
            }
        }

        return new ResponseEntity<>(((double)correctCount/correctAnswer.size())*100, HttpStatus.OK);
    }
}
