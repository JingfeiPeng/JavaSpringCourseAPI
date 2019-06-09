package io.Jingfei.SpringBoot.course;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service                // marks as a Spring service
public class CourseService {
	
	// business service: are singletons
	// creates an instance of this service when App starts up
	// inject the instance to different classes
	
	// inject an instance of topicRepository when creating an instance of TopicService
	@Autowired
	private CourseRepository courseRespository;
	
	public List<Course> getAllCourses(String topicId){
		List<Course> courses = new ArrayList<>();
		courseRespository.findByTopicId(topicId)
		.forEach(courses::add);  // find courses with this id
		return courses;
	}
	
	public Optional<Course> getCourse(String id) {
		return courseRespository.findById(id);
	}
	
	public void addCourse(Course course) {
		courseRespository.save(course);
	}

	public void updateCourse(Course course) {
		courseRespository.save(course); // save can do both add and update
	}

	public void deleteCourse(String id) {
		// topics.removeIf(t -> t.getId().equals(id));
		courseRespository.deleteById(id);
	}
	

}
