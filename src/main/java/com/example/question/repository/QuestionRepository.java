package com.example.question.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.question.entity.Question;


@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {

    Question findByQuestion(String question);
    void deleteByQuestion(String question);
    void deleteById(Integer id);
    
}
