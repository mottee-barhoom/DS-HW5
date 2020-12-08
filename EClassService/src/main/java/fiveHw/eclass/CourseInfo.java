/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fiveHw.eclass;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author M M BARHOOM
 */
@Service
public class CourseInfo {
    
    @Autowired
    private RestTemplate restTemplate;
    
    @HystrixCommand(fallbackMethod = "getFallbackCourse") // fallback
    public Course getCourseById(Long id) { // course service is running ok
        return restTemplate.getForObject("http://course-service/courses/" + id, Course.class);
    }
    
    public Course getFallbackCourse(Long id) { //  the default values int failure cases
        Course course = new Course();
        course.setId(1L);
        course.setTitle("default title");
        course.setDescription("default description");
        Date date = new Date();
        course.setStart_at(date);
        course.setEnd_at(date);
        course.setLecturer("default lecturer");
        return course;
    }
    
}
