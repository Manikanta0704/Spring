package com.springboot.School_Management_System.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

<<<<<<< HEAD:src/main/java/com/springboot/School_Management_System/controller/ParentController.java
import com.springboot.School_Management_System.entities.Parent;
import com.springboot.School_Management_System.service.ParentServiceImpl;
=======
import springboot.school.entities.Parent;
import springboot.school.service.ParentServiceImpl;
>>>>>>> fa83683b4b0d6bd75fa2e10fb671b1589123866a:src/main/java/springboot/school/controller/ParentController.java

@RestController
@RequestMapping("parent")
public class ParentController {
	
	@Autowired
	ParentServiceImpl service;
	
	@PostMapping("add")
	public ResponseEntity addParents(@RequestBody Parent parent) {
		service.addParent(parent);
		return new ResponseEntity(true,HttpStatus.OK);
	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity findParentsById(@PathVariable("id") String parentId) {
	    Parent parent = service.findParentById(parentId);
	    return new ResponseEntity<>(parent, HttpStatus.OK);
	}

	
	@GetMapping("getall")
	public ResponseEntity findAllParents() {
		List list=service.findAllParent();
		return new ResponseEntity<>(list,HttpStatus.OK);
	}
	
	@PutMapping("update")
	public ResponseEntity updateParents(@RequestBody Parent parent) {
		service.updateParent(parent);
		return new ResponseEntity(parent,HttpStatus.OK);
	}
	
//	@DeleteMapping("/delete/{id}")
//	public ResponseEntity deleteParentById(@PathVariable("id") String parentId) {
//		service.deleteParent(parentId);
//		return new ResponseEntity<>(HttpStatus.OK);
//	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteParentById(@PathVariable("id") String parentId) {
	    try {
	        service.deleteParent(parentId);
	        return new ResponseEntity<>("Parent deleted successfully!", HttpStatus.OK);
	    } catch (RuntimeException e) {
	        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
	    }
	}

}















