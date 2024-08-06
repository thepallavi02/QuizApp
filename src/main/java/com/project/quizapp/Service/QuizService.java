package com.project.quizapp.Service;

import com.project.quizapp.Dao.QuestionDao;
import com.project.quizapp.Dao.QuizDao;
import com.project.quizapp.Entities.Questions;
import com.project.quizapp.Entities.Quiz;
import com.project.quizapp.Entities.QuizWrapper;
import com.project.quizapp.Entities.Responses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuizService {
    @Autowired
    QuizDao quizDao;
    @Autowired
    QuestionDao questionDao;

    public ResponseEntity<String>createQuiz(String category,String title,int numQ){
        List<Questions> questions=questionDao.findRandomQuestionsByCategory(category,numQ);
        Quiz quiz = new Quiz();
        quiz.setTitle(title);
        quiz.setQuestionsList(questions);
        quizDao.save(quiz);
        return new ResponseEntity<>("Success", HttpStatus.CREATED);


    }

    public ResponseEntity<List<QuizWrapper>> getQuizQuestions(int id) {
        Optional<Quiz> quiz = quizDao.findById(id);
        List<Questions> questionsFromDB = quiz.get().getQuestionsList();
        List<QuizWrapper> questionsForUser = new ArrayList<>();
        for(Questions q :questionsFromDB){
            QuizWrapper qw = new QuizWrapper(q.getId(),q.getQuestionTitle(),q.getOption1(),q.getOption2(),q.getOption3(),q.getOption4());
            questionsForUser.add(qw);
        }
        return new ResponseEntity<>(questionsForUser,HttpStatus.OK);
    }

    public ResponseEntity<Integer> calculateResult(Integer id, List<Responses> responses) {
        Optional<Quiz> quiz = quizDao.findById(id);
        List<Questions> questions = quiz.get().getQuestionsList();
        int sum=0;
        int i=0;
        for(Responses r : responses){
           if( r.getResponse().equalsIgnoreCase(questions.get(i).getRightAnswer())){
               sum++;
           }
           i++;
        }
        return new ResponseEntity<>(sum,HttpStatus.OK);
    }
}
