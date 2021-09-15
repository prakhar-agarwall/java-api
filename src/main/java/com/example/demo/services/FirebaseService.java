package com.example.demo.services;

import com.example.demo.entities.Courses;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;

import java.util.concurrent.ExecutionException;

public class FirebaseService {

//    public String saveuserDetails(Courses courses) throws ExecutionException, InterruptedException {
//        Firestore firestore = FirestoreClient.getFirestore();
//        ApiFuture<WriteResult> collectionsApiFuture = firestore.collection("courses").document(courses.getTitle()).set(courses);
//        return collectionsApiFuture.get().getUpdateTime().toString();
//    }
}
