package com.project.quizapp.Controller;

import com.project.quizapp.Entities.Questions;
import com.project.quizapp.Service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("question")
public class QuestionController {
    @Autowired
    QuestionService questionService;
    @GetMapping("allQuestions")
    public ResponseEntity<List<Questions>> getAllQuestions(){
        return questionService.getAllQuestions();
    }

    @GetMapping("category/{cat}")
    public ResponseEntity<List<Questions>> getQuestionsByCategory(@PathVariable("cat")String category){
        return questionService.getQuestionsByCategory(category);
    }

    @PostMapping ("add-question")
    public ResponseEntity<String> addQuestion(@RequestBody Questions question){
        return questionService.addQuestion(question);
    }

    @DeleteMapping ("delete-question/{quesId}")
    public ResponseEntity<String> deleteQuestion(@PathVariable int quesId){
        return questionService.deleteQuestion(quesId);
    }
}
