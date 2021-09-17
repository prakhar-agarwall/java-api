package com.example.demo.services;

import com.example.demo.entities.Courses;

import java.util.List;
import java.util.concurrent.ExecutionException;

public interface CourseService{
    public List<Courses> getCourses();

    public Courses getCoursesID(Long courseid);

    public Courses addCourse(Courses courses);

    public Courses saveuserDetails(Courses courses) throws ExecutionException, InterruptedException;
}
