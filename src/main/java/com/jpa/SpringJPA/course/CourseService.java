package com.jpa.SpringJPA.course;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {
	
	@Autowired
	private CourseRepository courserepo;
	
public List<Course> getAllCourse(){
		
		List<Course> courses=new ArrayList<Course>();
		for (Course t:courserepo.findAll()) {
			courses.add(t);
			
		}
		return courses;}
	
	
	public List<Course> getAllCoursePerTopic(String topicId){
		
		List<Course> courses=new ArrayList<Course>();
		for (Course t:courserepo.findByTopicId(topicId)) {
			courses.add(t);
			
		}
		return courses;
		
	}
	
	public void addCourse(Course course)
	{
		courserepo.save(course);
	}
	
	public Course getCourse(String id)
	{
		return courserepo.findById(id).get();
	}
	
	public void updateCourse(Course c) {
		
		courserepo.save(c);
	}
	
	public void deleteCourse(String s) {
		courserepo.deleteById(s);
	}

}
