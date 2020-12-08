/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fiveHw.eclass;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author M M BARHOOM
 */
@Service
public class StudentInfo {
    
    @Autowired
    private RestTemplate restTemplate;
    
    @HystrixCommand(fallbackMethod = "getFallbackStudent") // fallback
    public Student getStudentById(Long id) {// student service is running ok
        return restTemplate.getForObject("http://student-service/students/" + id, Student.class);
    }
    
    public Student getFallbackStudent(Long id) {//  the default values int failure cases
        Student student = new Student();
        student.setId(1L);
        student.setName("default Name");
        student.setAge(23);
        student.setGender(Gender.MALE);
        return student;
    }
    
}
