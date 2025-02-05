//package com.sharad.app.repository;
//
//import com.sharad.app.model.Student;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//import static org.assertj.core.api.Assertions.assertThat;
//
//import java.util.Optional;
//
//@DataJpaTest // Loads only repository-related beans
//public class StudentRepoTest {
//
//    @Autowired
//    private StudentRepo studentRepo;
//
//    @Test
//    void testSaveAndFindStudent() {
//        Student student = new Student("1", "Jane Doe", "XYZ School", 20, "Female");
//        Student savedStudent = studentRepo.save(student);
//
//        Optional<Student> foundStudent = studentRepo.findById(Integer.parseInt(savedStudent.getId()));
//        assertThat(foundStudent).isPresent();
//        assertThat(foundStudent.get().getName()).isEqualTo("Jane Doe");
//    }
//}
