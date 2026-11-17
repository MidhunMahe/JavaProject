package com.sms.repository;

import java.util.ArrayList;
import java.util.List;

import com.sms.model.Student;

public class StudentRepository {
	
	private final List<Student> students = new ArrayList<>();
	private Student update;
	
	public boolean add(Student student) {
		if(findById(student.getStudentid()) != null || findByEmail(student.getEmail()) != null) {
			return false;
			
		}
		return students.add(student);
	}
	
	public Student findById(int id) {
		for(Student student: students) {
			if(student.getStudentid() == id) {
				return student;
			}
		}
		return null;
	}
	
	public Student findByEmail(String email) {
		for(Student student: students) {
			if(student.getEmail().equalsIgnoreCase(email)) {
				return student;
			}
		}
		return null;
	}
	
	public List<Student> findAll(){
		return new ArrayList<>(students);
	}
	
	public boolean update(int id, Student student) {
		Student existing = findById(id);
		if(existing == null) {
			return false;
		}
		
		Student emailOwner = findByEmail(update.getEmail());
		if(emailOwner != null && emailOwner.getStudentid() != id) {
			return false;
		}
	}
	
    existing.setName(student.getName());
    existing.setEmail(student.getEmail());
    existing.setAge(student.getAge());
    existing.setCourse(student.getCourse());
	
	public boolean delete(int id) {
		Student existing = findById(id);
		return existing != null && students.remove(existing);
	}
}
