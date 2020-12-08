/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fiveHw.eclass;

import java.util.Date;

/**
 *
 * @author M M BARHOOM
 */
public class Course {
    
    private Long id;
    private String title;
    private String description;
    private Date start_at;
    private Date end_at;
    private String lecturer;

    public Course() {
    }

    public Course(Long id, String title, String description, Date start_at, Date end_at, String lecturer) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.start_at = start_at;
        this.end_at = end_at;
        this.lecturer = lecturer;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getStart_at() {
        return start_at;
    }

    public void setStart_at(Date start_at) {
        this.start_at = start_at;
    }

    public Date getEnd_at() {
        return end_at;
    }

    public void setEnd_at(Date end_at) {
        this.end_at = end_at;
    }

    public String getLecturer() {
        return lecturer;
    }

    public void setLecturer(String lecturer) {
        this.lecturer = lecturer;
    }
    
}
