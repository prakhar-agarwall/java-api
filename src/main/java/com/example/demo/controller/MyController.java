package com.example.demo.controller;


import com.example.demo.entities.Courses;
import com.example.demo.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.ExecutionException;

@RestController
public class MyController {

    @Autowired
    private CourseService courseService;

    @RequestMapping("/")
    public String getHello() {
        return "Helloooo";
    }

    @GetMapping("/courses")
    public List<Courses> getCourses() {
        return this.courseService.getCourses();
    }

    @RequestMapping("/courses/{courseId}")
    public Courses getCourseID(@PathVariable String courseId) {
        return this.courseService.getCoursesID(Long.parseLong(courseId));
    }

    @PostMapping("/courses")
    public Courses addCourse(@RequestBody Courses courses) {
        return this.courseService.addCourse(courses);
    }

    @PostMapping("/coursesfirebase")
    public String addCourseFirebase(@RequestBody Courses courses) throws ExecutionException, InterruptedException {
        return this.courseService.saveuserDetails(courses);
    }
}
