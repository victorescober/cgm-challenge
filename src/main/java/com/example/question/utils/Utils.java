package com.example.question.utils;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class Utils {

    public String getOnlyQuestionString(String question) {
        return question.substring(0, question.lastIndexOf("?"));
    }

    public String[] getOnlyAnswers(String question) {
        return question.substring(question.lastIndexOf("?") + 1, question.length()).split(" ");
    }

    public boolean isOnlyQuestion(String questionText) {
        return (questionText.length()) - questionText.lastIndexOf("?") > 1;
    }

    public boolean isInvalidQuestion(String questionText) {
        return !questionText.contains("?");
    }

    public boolean isInvalidLength(String questionText) {
        return questionText.length() > 255;
    }

    public boolean isAnswerInvalidLength(String question) {
        List<String> answers = Arrays
                .asList((question.substring(question.lastIndexOf("?") + 1, question.length()).split(" ")));
        for (String answer : answers) {
            if (isInvalidLength((answer.replace("\"", "")))) {
                return true;
            }
        }
        return false;
    }

}
