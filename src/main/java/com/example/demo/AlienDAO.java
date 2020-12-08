package com.example.demo;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class AlienDAO
{
	@Autowired
	AlienRepo alienRepo;
	public Alien save(Alien user)
	{
		return alienRepo.save(user);
	}
	
	public Optional<Alien> findOne(Integer id)
	{
		return alienRepo.findById(id);
	}
	

}
