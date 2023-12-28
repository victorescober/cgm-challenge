package com.example.question;

import static org.junit.jupiter.api.Assertions.assertEquals;
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
        assertEquals(utils.getOnlyQuestionString("What is Peters favorite food?\"Pizza\" \"Spaguetti\" \"Ice Cream\""),
                "What is Peters favorite food");
    }

    @Test
    public void getOnlyAnswers() {
        assertEquals(utils.getOnlyAnswers("what is your favorite food?\"Pizza\" \"Spaguetti\" \"Ice Cream\"").size(),
                3);
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
    public void isInvalidAnswerLength() {
        assertEquals(utils.isAnswerInvalidLength(
                "what is your favorite food?\"testing more the 255 Characters, testing more the 255 Characters, testing more the 255 Characters, testing more the 255 Characters, testing more the 255 Characters, testing more the 255 Characters, testing more the 255 Characters, testing more the 255 Characters, testing more the 255 Characters\""),
                true);
    }

    @Test
    public void isInvalidQuestionLength() {
        assertEquals(utils.isInvalidLength(
                "testing more the 255 Characters, testing more the 255 Characters, testing more the 255 Characters, testing more the 255 Characters, testing more the 255 Characters, testing more the 255 Characters, testing more the 255 Characters, testing more the 255 Characters, testing more the 255 Characters"),
                true);
    }
}
