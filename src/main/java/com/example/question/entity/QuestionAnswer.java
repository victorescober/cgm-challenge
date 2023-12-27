package com.example.question.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class QuestionAnswer {
    
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private Question question;

    @Column
    private String answer;
}
