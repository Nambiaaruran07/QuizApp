package com.example.QuizApp.Service;

import com.example.QuizApp.Dao.QuestionDao;
import com.example.QuizApp.Model.Questions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {
    @Autowired
    QuestionDao questionDao;
    public ResponseEntity<List<Questions>> getAllQuestions() {
        try {
            return new ResponseEntity<>(questionDao.findAll(), HttpStatus.OK);
        }catch(Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<List<Questions>> getQuestionsByCategory(@PathVariable String lang) {
        try {
            return new ResponseEntity<>(questionDao.findByCategory(lang), HttpStatus.OK);
        }catch(Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<Questions> getQuestionById(Integer id){
        try{
            if(questionDao.existsById(id)){
                Questions question = questionDao.findById(id).orElse(null);
                if(question!=null) {
                    return new ResponseEntity<>(question, HttpStatus.OK);
                }else{
                    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
                }
            }else{
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<String> addQuestion(@RequestBody Questions question) {
        questionDao.save(question);
        return new ResponseEntity<>("success",HttpStatus.CREATED);

    }

    public ResponseEntity<Questions> updateQuestion(Integer id, Questions question) {
        try {
            if (questionDao.existsById(id)) {
                question.setId(id);
                questionDao.save(question);

                Questions updatedQuestion = questionDao.findById(id).orElse(null);
                if (updatedQuestion != null) {
                    return new ResponseEntity<>(updatedQuestion, HttpStatus.OK);
                } else {
                    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
                }
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        }catch(Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<Questions> deleteQuestion(Integer id) {
        try{
            if(questionDao.existsById(id)){
                Questions deletedQuestion = questionDao.findById(id).orElse(null);
                if(deletedQuestion!=null){
                    questionDao.deleteById(id);
                    return new ResponseEntity<>(deletedQuestion,HttpStatus.OK);
                }
                else{
                    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
                }
            }else{
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        }catch(Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
