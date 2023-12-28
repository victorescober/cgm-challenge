package com.example.question.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.question.entity.Question;
import com.example.question.entity.QuestionAnswer;
import com.example.question.repository.QuestionRepository;
import com.example.question.utils.Utils;

@Service
public class QuestionService {

    @Autowired
    private QuestionRepository repository;

    @Autowired
    private Utils utils;

    public List<Question> findAll() {
        return repository.findAll();
    }

    public Question findByQuestion(String question) {
        return repository.findByQuestion(question);
    }

    @Transactional
    public Question save(String question) {
        // we verity if the user tries to modify the question.
        if (repository.findByQuestion(utils.getOnlyQuestionString(question)) != null) {
            repository.deleteByQuestion(utils.getOnlyQuestionString(question));
        }
        Question t = new Question();
        List<QuestionAnswer> answers = new ArrayList<>();

        List<String> answersFromQuestion = utils.getOnlyAnswers(question);

        // saving all the answers of the question
        for (String answerQuestion : answersFromQuestion) {
            QuestionAnswer answer = new QuestionAnswer();
            answer.setQuestion(t);
            answer.setAnswer(answerQuestion);
            answers.add(answer);

        }

        t.setQuestion(utils.getOnlyQuestionString(question));
        t.setAnswers(answers);

        return repository.save(t);
    }

    @Transactional
    public void deleteQuestion(String question) {
        repository.deleteByQuestion(question);
    }

}
