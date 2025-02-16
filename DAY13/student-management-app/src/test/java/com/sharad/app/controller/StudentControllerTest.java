//package com.sharad.app.controller;
//
//import com.sharad.app.model.Student;
//import com.sharad.app.repository.StudentRepo;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.mockito.junit.jupiter.MockitoExtension;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//
//import java.util.Arrays;
//import java.util.List;
//
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//import static org.mockito.Mockito.*;
//
//@ExtendWith(MockitoExtension.class)
//public class StudentControllerTest {
//
//    private MockMvc mockMvc;
//
//    @Mock
//    private StudentRepo studentRepo;
//
//    @InjectMocks
//    private StudentController studentController;
//
//    private Student student;
//
//    @BeforeEach
//    void setUp() {
//        mockMvc = MockMvcBuilders.standaloneSetup(studentController).build();
//        student = new Student("1", "John Doe", "ABC School", 18, "Male");
//    }
//
//    @Test
//    void testReadStudents() throws Exception {
//        List<Student> students = Arrays.asList(student);
//        when(studentRepo.findAll()).thenReturn(students);
//
//        mockMvc.perform(get("/user/read"))
//                .andExpect(status().isOk())
//                .andExpect(content().json("[{\"id\":\"1\",\"name\":\"John Doe\",\"schoolName\":\"ABC School\",\"age\":18,\"gender\":\"Male\"}]"));
//
//        verify(studentRepo, times(1)).findAll();
//    }
//
//    @Test
//    void testSaveStudent() throws Exception {
//        when(studentRepo.save(any(Student.class))).thenReturn(student);
//
//        mockMvc.perform(post("/user/save")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content("{\"id\":\"1\",\"name\":\"John Doe\",\"schoolName\":\"ABC School\",\"age\":18,\"gender\":\"Male\"}"))
//                .andExpect(status().isOk())
//                .andExpect(content().string("save"));
//
//        verify(studentRepo, times(1)).save(any(Student.class));
//    }
//}
