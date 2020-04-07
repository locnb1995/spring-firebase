package com.baoloc.hus.firebaseapp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import org.springframework.stereotype.Service;

import com.baoloc.hus.firebaseapp.entity.Employee;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.firebase.cloud.FirestoreClient;

@Service
public class AppFirebaseService
{
	public List<Employee> getAllEmp() throws InterruptedException, ExecutionException
	{
		List<Employee> result = new ArrayList<>();
		Firestore db = FirestoreClient.getFirestore();
		// asynchronously retrieve multiple documents
		ApiFuture<QuerySnapshot> future = db.collection("Employee").get();
		// future.get() blocks on response
		List<QueryDocumentSnapshot> documents = future.get().getDocuments();
		for (DocumentSnapshot document : documents)
		{
			Employee emp = document.toObject(Employee.class);
			emp.setId(document.getId());
			result.add(emp);
		}
		return result;
	}
}
