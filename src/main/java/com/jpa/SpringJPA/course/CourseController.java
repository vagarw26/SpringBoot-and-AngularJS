package com.jpa.SpringJPA.course;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jpa.SpringJPA.topic.Topic;

@RestController
public class CourseController {
	
	@Autowired
	private CourseService courseservice;
	
	@RequestMapping(value="/topics/courses")
	public List<Course> getAllCourses()
	{
		return courseservice.getAllCourse();
		
	}
	
	@RequestMapping(value="/topics/{topicId}/courses")
	public List<Course> getCourse(@PathVariable String topicId)
	{
		return courseservice.getAllCoursePerTopic(topicId);
		
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/topics/{topicId}/courses")
	public void addCourses(@RequestBody Course c,@PathVariable String topicId) {
		c.setTopic(new Topic(topicId,"",""));
		
		courseservice.addCourse(c);
	}
	
	@RequestMapping(value="/topics/{topicId}/courses/{id}")
	public Course getOneCourse(@PathVariable String id)
	{
		return courseservice.getCourse(id);
	}
	
	@RequestMapping(method=RequestMethod.DELETE,value="/topics/{topicId}/courses/{id}")
	public void deleteOneCourse(@PathVariable String id) {
		
		courseservice.deleteCourse(id);
	}
	
	@RequestMapping(method=RequestMethod.PUT,value="/topics/{topicId}/courses")
	public void updateOneCourse(@RequestBody Course c,@PathVariable String topicId)
	
	{
		c.setTopic(new Topic(topicId,"",""));
		courseservice.updateCourse(c);

	}

}
