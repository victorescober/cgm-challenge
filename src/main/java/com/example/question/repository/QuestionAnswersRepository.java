package com.example.question.repository;

import org.springframework.stereotype.Repository;

import com.example.question.entity.QuestionAnswer;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface QuestionAnswersRepository extends JpaRepository<QuestionAnswer,Long> {
    
}
