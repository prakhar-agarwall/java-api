package com.example.demo.services;

import com.example.demo.entities.Courses;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.*;
import com.google.firebase.cloud.FirestoreClient;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

@org.springframework.stereotype.Service
public class Service implements CourseService{

    List<Courses> list;

    public Service() {
        list = new ArrayList<>();
      //  list.add(new Courses(1,"Title 101","Description 101"));
       // list.add(new Courses(2,"Title 102","Description 102"));
    }

    @Override
    public List<Courses> getCourses() {
        return list;
    }

    @Override
    public Courses getCoursesID(Long courseid) {

        Courses c = null;
        for(Courses courses:list){
            if(courses.getId() == courseid){
                c = courses;
                break;
            }
        }

        return c;
    }

    @Override
    public Courses addCourse(Courses courses) {

        list.add(courses);
        return courses;
    }

    public String saveuserDetails(Courses courses) throws ExecutionException, InterruptedException {
       /* list.add(courses);
        return courses;*/
        Firestore firestore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> collectionsApiFuture = firestore.collection("courses").document(courses.getTitle()).set(courses);
        return collectionsApiFuture.get().getUpdateTime().toString();
    }

    public Courses getuserDetails(String title) throws ExecutionException, InterruptedException {
        Firestore firestore = FirestoreClient.getFirestore();

        DocumentReference documentReference = firestore.collection("courses").document(title);
        ApiFuture<DocumentSnapshot> future = documentReference.get();
        DocumentSnapshot document = future.get();

        Courses course = null;
        if(document.exists()){
            course = document.toObject(Courses.class);
            return course;
        }else{
            return null;
        }
    }

    public String updateCourseFirebase(Courses courses) throws ExecutionException, InterruptedException {
       /* list.add(courses);
        return courses;*/
        Firestore firestore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> collectionsApiFuture = firestore.collection("courses").document(courses.getTitle()).set(courses);
        return collectionsApiFuture.get().getUpdateTime().toString();
    }

    public String deleteCourseFirebase(String title) throws ExecutionException, InterruptedException {
       /* list.add(courses);
        return courses;*/
        Firestore firestore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> collectionsApiFuture = firestore.collection("courses").document(title).delete();
        return "Course with title: " + title + " deleted successfully.";
    }

    public String saverealtime(Courses courses) throws ExecutionException, InterruptedException {

        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference ref = database.getReference();

        DatabaseReference usersRef = ref.child("users");

        Map<String, Courses> users = new HashMap<>();
        users.put("alanisawesome", new Courses(1,"June 23, 1912", "Alan Turing"));
        users.put("gracehop", new Courses(2,"December 9, 1906", "Grace Hopper"));

        usersRef.setValueAsync(users);
        return "Course added successfully.";
    }
}
