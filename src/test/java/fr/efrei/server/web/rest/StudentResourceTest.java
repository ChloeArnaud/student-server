package fr.efrei.server.web.rest;

import fr.efrei.server.domain.Student;
import fr.efrei.server.repository.StudentRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@TestPropertySource(
        locations = "classpath:application-test.properties")
public class StudentResourceTest {
    @Autowired
    private StudentRepository studentRepository;

    @Test
    @Transactional
    void createStudent() throws Exception {
        int databaseSizeBeforeCreate = studentRepository.findAll().size();
        assertThat(databaseSizeBeforeCreate).isEqualTo(0);

        Student student = new Student();
        student.setId(6);
        student.setName("Pierre Granger");
        studentRepository.save(student);

        List<Student> studentList = studentRepository.findAll();
        assertThat(studentList).hasSize(databaseSizeBeforeCreate + 1);
    }
}