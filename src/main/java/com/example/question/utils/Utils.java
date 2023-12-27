package com.example.question.utils;

import org.springframework.stereotype.Component;

@Component
public class Utils {

    public String getOnlyQuestionString(String question) {
        return question.substring(0, question.lastIndexOf("?"));
    }

    public String[] getOnlyAnswers(String question) {
        return question.substring(question.lastIndexOf("?") + 1, question.length()).split(" ");
    }

    /* 
     * Verify if the string contains only the question (before of the ?). 
     * 
     */
    public boolean isOnlyQuestion(String questionText) {
        return (questionText.length()) - questionText.lastIndexOf("?") > 1;
    }

}
