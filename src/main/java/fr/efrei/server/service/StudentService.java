package fr.efrei.server.service;

import fr.efrei.server.domain.Student;
import fr.efrei.server.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    public StudentRepository getStudentRepository() {
        return studentRepository;
    }

    @Autowired
    StudentRepository studentRepository;


    public List<Student> findAll() { return studentRepository.findAll();}
}
