package com.example.QuizApp.Controller;

import com.example.QuizApp.Model.Questions;
import com.example.QuizApp.Service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Component
@RestController
@RequestMapping(path="question")
public class QuestionController {

    @Autowired
    QuestionService questionService;

    @GetMapping(path="allQuestions")
    public ResponseEntity<List<Questions>> getAllQuestion(){
        return questionService.getAllQuestions();
    }

    @GetMapping(path="category/{language}")
    public ResponseEntity<List<Questions>> getQuestionsByCategory(@PathVariable("language") String lang){
        return questionService.getQuestionsByCategory(lang);
    }

    @GetMapping(path="{id}")
    public ResponseEntity<Questions> getQuestionById(@PathVariable Integer id){
        return questionService.getQuestionById(id);
    }

    @PostMapping(path="add")
    public ResponseEntity<String> addQuestion(@RequestBody Questions question) {
        return questionService.addQuestion(question);
    }

    @PutMapping(path="update/{id}")
    public ResponseEntity<Questions> updateQuestion(@PathVariable Integer id,@RequestBody Questions question){
        return questionService.updateQuestion(id,question);
    }

    @DeleteMapping(path="delete/{id}")
    public ResponseEntity<Questions> deleteQuestion(@PathVariable Integer id){
        return questionService.deleteQuestion(id);
    }
}
