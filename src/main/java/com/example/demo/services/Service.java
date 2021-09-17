package com.example.demo.services;

import com.example.demo.entities.Courses;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.*;
import com.google.firebase.cloud.FirestoreClient;

import java.util.ArrayList;
import java.util.List;
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
            if(courses.getId().equals(courseid)){
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

    public List<String> getuserDetails(Courses courses) throws ExecutionException, InterruptedException {
       /* list.add(courses);
        return courses;*/
        List<String> listt = null;
        Firestore firestore = FirestoreClient.getFirestore();
        ApiFuture<QuerySnapshot> future = firestore.collection("courses").get();
        List<QueryDocumentSnapshot> documents = future.get().getDocuments();
        for (QueryDocumentSnapshot document : documents) {
            System.out.print(document.getId());
            assert false;
            listt.add(document.getId());
        }
        System.out.print("adadadadadad");
        System.out.print("555   "+ listt);
        return listt;
    }
}
