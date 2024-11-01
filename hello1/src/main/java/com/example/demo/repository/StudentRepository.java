package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.Student;

@Repository
public interface StudentRepository extends CrudRepository<Student ,Integer> 
//Student pachi space apvani nitar error avsa
{

	
}
