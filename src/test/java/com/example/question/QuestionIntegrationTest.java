package com.example.question;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.example.question.service.QuestionService;

@SpringBootTest(args = { "test" })
@SpringJUnitConfig
public class QuestionIntegrationTest {

	@Autowired
	private QuestionService service;

	@BeforeEach
	public void addQuestion() {
		service.save("What is Peters favorite food?\"Pizza\" \"Spaguetti\" \"Ice cream");
		service.save("What is Autos's color?\"red\" \"blue\"");
	}

	@AfterEach
	public void removeQuestion() {
		service.deleteQuestion("What is Peters favorite food");
		service.deleteQuestion("What is Autos's color");
	}

	@Test
	public void getAllQuestions() {
		assertEquals(service.findAll().size(), 2);
	}

	@Test
	public void getFirstQuestionAnswers() {
		assertEquals(service.findByQuestion("What is Peters favorite food").getAnswers().size(), 3);
	}

}
