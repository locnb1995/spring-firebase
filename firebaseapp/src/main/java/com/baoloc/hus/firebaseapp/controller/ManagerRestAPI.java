package com.baoloc.hus.firebaseapp.controller;

import java.util.List;
import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.baoloc.hus.firebaseapp.entity.Employee;
import com.baoloc.hus.firebaseapp.service.AppFirebaseService;

@RestController
@RequestMapping("/api")
public final class ManagerRestAPI
{
	@Autowired
	private AppFirebaseService appFirebaseService;

	@GetMapping("/get-emp")
	public List<Employee> getEmp() throws InterruptedException, ExecutionException
	{
		return this.appFirebaseService.getAllEmp();
	}
}
