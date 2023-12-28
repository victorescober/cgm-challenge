package com.example.question;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.question.entity.Question;
import com.example.question.entity.QuestionAnswer;
import com.example.question.service.QuestionService;
import com.example.question.utils.Utils;

@SpringBootApplication
public class QuestionApplication implements CommandLineRunner {

	@Autowired
	private QuestionService service;

	@Autowired
	private Utils utils;

	public static void main(String[] args) {
		SpringApplication.run(QuestionApplication.class, "console");
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Welcome to the Command Line Spring Boot Application, please type a question: ");
		if (args[0].equals("console")) {
			Scanner scanner = new Scanner(System.in);

			String questionText = " ";

			while (true) {
				questionText = scanner.nextLine();

				while (utils.isInvalidQuestion(questionText)) {
					System.out.println("Format Incorrect, Please try again");
					questionText = scanner.nextLine();
				}
				
				while (utils.isInvalidLength(utils.getOnlyQuestionString(questionText))) {
					System.out.println("Question Length Incorrect, Please try again");
					questionText = scanner.nextLine();
				}

				while (utils.isAnswerInvalidLength(questionText)) {
					System.out.println("Answer Length Incorrect, Please try again");
					questionText = scanner.nextLine();
				}

				//asking if the text contains only the question.
				if (utils.isOnlyQuestion(questionText)) {
					service.save(questionText);
				} else {
					Question foundQuestion = service.findByQuestion(utils.getOnlyQuestionString(questionText));
					if (foundQuestion == null) {
						System.out.println(
								"the answer to life, universe and everything is 42, according to \"The hitchhikers guide to the Galaxy\"");
					} else {
						for (QuestionAnswer questionAnswer : foundQuestion.getAnswers()) {
							System.out.println("* " + questionAnswer.getAnswer());
						}
					}
				}
			}

		}

	}

}
