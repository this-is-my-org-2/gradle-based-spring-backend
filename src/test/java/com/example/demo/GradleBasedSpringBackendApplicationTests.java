package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(HelloController.class)
class GradleBasedSpringBackendApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Test
	void helloShouldReturnDefaultMessage() throws Exception {
		mockMvc.perform(get("/hello"))
				.andExpect(status().isOk())
				.andExpect(content().string("Hello, World!"));
	}

	@Test
	void helloShouldReturnCustomMessage() throws Exception {
		mockMvc.perform(get("/hello").param("name", "Gemini"))
				.andExpect(status().isOk())
				.andExpect(content().string("Hello, Gemini!"));
	}
}
