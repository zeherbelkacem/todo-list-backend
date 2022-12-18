//package com.belkacem.todolistbackend;
//
//import static org.hamcrest.CoreMatchers.is;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.web.servlet.MockMvc;
//
//@SpringBootTest
//@AutoConfigureMockMvc
//class TodoControllerIntegrationTest {
//
//		@Autowired
//		private MockMvc mockMvc;
//		
//		@Test
//		void shouldReturnListOTodos() throws Exception {
//			 mockMvc.perform(get("/api/todo/v1/todos"))
//	            .andExpect(status().isOk())
//	            .andExpect(jsonPath("$[0].title", is("todo1")))
//	            .andExpect(jsonPath("$[0].done", is(false)));
//		}
//
//}
