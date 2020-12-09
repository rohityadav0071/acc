package com.example.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class AlienResourse 
{
	@Autowired
	AlienDAO aliendao;
	
	
	@RequestMapping("demo")
	public void getAliens()
	{
				System.out.println("hello");
	}
	
	@PostMapping(value = "register", consumes = "application/json")
	public Alien createUser(  @RequestBody Alien user)
	{
		return aliendao.save(user);
	}
	
	@GetMapping("users/{id}")
	public ResponseEntity<Optional<Alien>> getEmployeeById(@PathVariable(value="id") Integer id){
		
		Optional<Alien> user=aliendao.findOne(id);
		
		if(user==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(user);
		
	}
}
