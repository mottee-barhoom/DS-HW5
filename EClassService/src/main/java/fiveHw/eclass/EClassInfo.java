/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fiveHw.eclass;

import java.util.List;

/**
 *
 * @author M M BARHOOM
 */
public class EClassInfo {

    private Long id;
    private String class_name;
    private List<Student> students;
    private List<Course> courses;

    public EClassInfo() {
    }

    public EClassInfo(Long id, String class_name, List<Student> students, List<Course> courses) {
        this.id = id;
        this.class_name = class_name;
        this.students = students;
        this.courses = courses;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getClass_name() {
        return class_name;
    }

    public void setClass_name(String class_name) {
        this.class_name = class_name;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

}
