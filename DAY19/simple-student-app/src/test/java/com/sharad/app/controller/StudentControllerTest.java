package com.sharad.app.controller;

import com.sharad.app.model.Student;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.lang.NonNull;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@WebMvcTest(StudentController.class)
public class StudentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testGetStudent() throws Exception {
        ResultActions resultActions = mockMvc.perform(get("/student/get").param("name", "student1"));
        resultActions.andExpect(status().isOk());
        String result = resultActions.andReturn().getResponse().getContentAsString();
        assertEquals("", result);
    }

    @Test
    public void testDeleteStudent() throws Exception {
        Student student = new Student();
        student.setName("John");
        student.setId(1);
        ResultActions resultActions = mockMvc.perform(post("/student/save")
                .contentType(MediaType.APPLICATION_JSON).contentType(asJsonString(student))
                .accept(MediaType.APPLICATION_JSON));

        ResultActions resultDeleteActions = mockMvc.perform(delete("/student/delete")
                .param("name", "John"));
        resultDeleteActions.andExpect(status().isOk());
        String result = resultDeleteActions.andReturn().getResponse().getContentAsString();
        assertEquals("", result);
    }

    private String asJsonString(final Object obj) {
        try {
            final ObjectMapper mapper = new ObjectMapper();
            final String jsonStudent = mapper.writeValueAsString(obj);
            return jsonStudent;
        } catch (Exception exception) {
            throw new RuntimeException(exception);
        }
    }

    private Student asStringToJson(final String json) {
        try {
            final ObjectMapper mapper = new ObjectMapper();
            Student student = mapper.readValue(json, Student.class);
            return student;
        } catch (Exception exception) {
            throw new RuntimeException(exception);
        }
    }

    private Map<String, Student> asStringToMap(final String json) {
        try {
            final ObjectMapper mapper = new ObjectMapper();
            Map<String, Student> students = mapper.readValue(json, Map.class);
            return students;
        } catch (Exception exception) {
            throw new RuntimeException(exception);
        }
    }
}