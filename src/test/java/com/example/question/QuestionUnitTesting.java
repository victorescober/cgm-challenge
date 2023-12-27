package com.example.question;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.example.question.utils.Utils;

@SpringBootTest(args = { "test" })
@SpringJUnitConfig
public class QuestionUnitTesting {

    @Autowired
    private Utils utils;

    @Test
    public void getOnlyQuestion() {
        assertEquals(utils.getOnlyQuestionString("what is your favorite food?\"a\" \"b\" "),
                "what is your favorite food");
    }

    @Test
    public void getOnlyAnswers() {
        assertEquals(List.of(utils.getOnlyAnswers("what is your favorite food?\"a\" \"b\" ")).size(), 2);
    }
}
