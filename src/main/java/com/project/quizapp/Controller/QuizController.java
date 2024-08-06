package com.project.quizapp.Controller;

import com.project.quizapp.Entities.Questions;
import com.project.quizapp.Entities.QuizWrapper;
import com.project.quizapp.Entities.Responses;
import com.project.quizapp.Service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("quiz")
public class QuizController {
    @Autowired
    QuizService quizService;
    @PostMapping("create")
    public ResponseEntity<String>createQuiz(@RequestParam String category,@RequestParam int numQ,@RequestParam String quizTitle){
        return quizService.createQuiz(category,quizTitle,numQ);
    }
    @GetMapping("get/{id}")
    public ResponseEntity<List<QuizWrapper>>getQuizQuestions(@PathVariable("id")int id){
        return quizService.getQuizQuestions(id);
    }
    @PostMapping("submit/{id}")
    public ResponseEntity<Integer>getResponse(@PathVariable Integer id,@RequestBody List<Responses>responses){
        return quizService.calculateResult(id,responses);
    }
}
