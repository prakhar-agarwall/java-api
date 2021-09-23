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

    @PostMapping("/coursespostfirebase")
    public String addCourseFirebase(@RequestBody Courses courses) throws ExecutionException, InterruptedException {
        return this.courseService.saveuserDetails(courses);
    }

    @GetMapping("/coursesgetfirebase/{title}")
    public Courses getuserDetails(@PathVariable String title) throws ExecutionException, InterruptedException{
        return this.courseService.getuserDetails(title);
    }

    @PutMapping("/coursesputfirebase")
    public String updateCourseFirebase(@RequestBody Courses courses) throws ExecutionException, InterruptedException {
        return this.courseService.saveuserDetails(courses);
    }

    @DeleteMapping("/coursesdeletefirebase/{title}")
    public String deleteCourseFirebase(@PathVariable String title) throws ExecutionException, InterruptedException{
        return this.courseService.deleteCourseFirebase(title);
    }

    @PostMapping("/coursesrealtime")
    public String saverealtime(@RequestBody Courses courses) throws ExecutionException, InterruptedException {
        return this.courseService.saverealtime(courses);
    }

}
