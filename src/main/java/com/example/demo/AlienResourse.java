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
	public List<Alien> getAliens()
	{
		List<Alien> l1= new ArrayList<>();
			Alien a1=new Alien();
			a1.setId(7000);
			a1.setName("prem");
			a1.setPoints(70);
			
			Alien a2=new Alien();
			a2.setId(8000);
			a2.setName("ritik");
			a2.setPoints(50);
				l1.add(a1);
				l1.add(a2);
				
				aliendao.save(a1);
				aliendao.save(a2);
				
				
				return l1;
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
