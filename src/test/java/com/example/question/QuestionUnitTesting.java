package com.example.question;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.question.utils.Utils;

public class QuestionUnitTesting {

    private Utils utils;

    @BeforeEach
    public void instance() {
        utils = new Utils();
    }

    @Test
    public void getOnlyQuestion() {
        assertEquals(utils.getOnlyQuestionString("what is your favorite food?\"a\" \"b\" "),
                "what is your favorite food");
    }

    @Test
    public void getOnlyAnswers() {
        assertEquals(List.of(utils.getOnlyAnswers("what is your favorite food?\"a\" \"b\" ")).size(), 2);
    }

    @Test
    public void isInvalidQuestion() {
        assertEquals(utils.isInvalidQuestion("question invalid"), true);
    }

    @Test
    public void isvalidQuestionLength() {
        assertEquals(utils.isInvalidLength(
                "what is your favorite food?"),
                false);
    }

    @Test
    public void isInvalidQuestionLength() {
        assertEquals(utils.isInvalidLength(
                "question invalid, question invalid, question invalid, question invalid, question invalid, question invalid, question invalid, question invalid, question invalid, question invalid, question invalid, question invalid, question invalid, question invalid, question invalid, "),
                true);
    }
}
