/*
package com.belkacem.todolistbackend;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.belkacem.todolistbackend.business.TodoBusinessLogic;
import com.belkacem.todolistbackend.controller.TodoController;


@WebMvcTest(controllers = TodoController.class)
class TodoControllerUnitaryTest {
	
	@Autowired
    private MockMvc mockMvc;

    @MockBean
    private TodoBusinessLogic todoBusinessLogic;
	
	@Test
    void testGetEmployees() throws Exception {
        mockMvc.perform(get("/api/todo/v1/todos"))
            .andExpect(status().isOk());
    }


}
*/
