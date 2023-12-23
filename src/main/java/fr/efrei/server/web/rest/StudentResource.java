package fr.efrei.server.web.rest;

import fr.efrei.server.domain.Student;
import fr.efrei.server.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentResource
{
    public final StudentService studentService;
    public StudentResource(StudentService studentService) { this.studentService = studentService;}

    @GetMapping("/students/{id}")
    public Student getItem(@PathVariable int id) {
        List<Student> students = getAllStudents();
        return students.get(id-1);
    }
    @GetMapping("/students")
    public List<Student> getAllStudents(){
        return studentService.findAll();
    }

    @PostMapping("/students")
    public Student newStudent(@RequestBody Student newStudent) {
        return studentService.getStudentRepository().save(newStudent);
    }

    @PutMapping("/students/{id}")
    public Student replaceStudent(@RequestBody Student newStudent, @PathVariable int id) {

        return studentService.getStudentRepository().findById(id)
                .map(student -> {
                    student.setName(newStudent.getName());
                    student.setAge(newStudent.getAge());
                    return studentService.getStudentRepository().save(student);
                })
                .orElseGet(() -> {
                    newStudent.setId(id);
                    return studentService.getStudentRepository().save(newStudent);
                });
    }

    @DeleteMapping("/students/{id}")
    public void deleteStudent(@PathVariable int id) {
        studentService.getStudentRepository().deleteById(id);
    }

   /* @GetMapping("/students")
    public String test() {
        return "Hello world!";
    }*/
}