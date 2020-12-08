package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AlienRepo extends JpaRepository<Alien, Integer>
{
	
}
