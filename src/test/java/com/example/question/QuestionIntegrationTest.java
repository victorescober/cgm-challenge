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
		service.save("test1?\"a\" \"b\" \"c\" \"d\" \"e\"");
		service.save("test2?\"a\" \"b\"");
	}

	@AfterEach
	public void removeQuestion() {
		service.deleteQuestion("test1");
		service.deleteQuestion("test2");
	}

	@Test
	public void getAllQuestions() {
		assertEquals(service.findAll().size(), 2);
	}

	@Test
	public void getAnswers() {
		assertEquals(service.findByQuestion("test1").getAnswers().size(), 5);
	}

}
