/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fiveHw.studentService;

import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author M M BARHOOM
 */
@RestController
@RequestMapping("/students")
public class StudentController {

    private Long firstId = 1L;
    private String firstName = "Mottee BARHOOM";
    private int firstAge = 23;
    private Gender firstGender = Gender.MALE;

    private Student firstStudent = new Student(firstId, firstName, firstAge, firstGender);
    private List<Student> students = new ArrayList<>();

    public StudentController() {
        students.add(firstStudent);
    }

    @GetMapping
    public List<Student> findAll() {
        return students;
    }

    @GetMapping("/{id}")
    public Student getById(@PathVariable("id") Long id) {
        return students.stream().filter(it -> it.getId().equals(id)).findFirst().get();
    }

    @PostMapping
    public Student add(@RequestBody Student s) {
        long index;
        if (students.size() > 0) {
            index = students.get(students.size() - 1).getId();
        } else {
            index = 0;
        }
        s.setId(index + 1);
        students.add(s);
        return s;
    }

}
