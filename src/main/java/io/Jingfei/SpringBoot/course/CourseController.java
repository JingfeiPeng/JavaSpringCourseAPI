package io.Jingfei.SpringBoot.course;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.Jingfei.SpringBoot.topic.Topic;

@RestController
public class CourseController {
	
	@Autowired   // marks as it needs dependency injection
	private CourseService courseService;

	@RequestMapping("/topics/{id}/courses")
	public List<Course> getAllCourses(@PathVariable String id) {
		// converted to json automatically
		return courseService.getAllCourses(id);
	}
	
	@RequestMapping("/topics/{TopicId}/courses/{id}") // id is a variable
	public Optional<Course> getCourse(@PathVariable String TopicId, @PathVariable String id) {
		return courseService.getCourse(id);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/topics/{topicId}/courses")
	public String addCourse(@RequestBody Course course, @PathVariable String topicId) {
		course.setTopic(new Topic(topicId, "", ""));
		courseService.addCourse(course);
		return "Success";
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/topics/{topicId}/courses/{id}")
	public String updateTopic(@RequestBody Course course, @PathVariable String topicId, @PathVariable String id) {
		course.setTopic(new Topic(topicId,"",""));
		courseService.updateCourse(course);
		return "Success";
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value= "/topics/{topicId}/courses/{id}") // id is a variable
	public void deleteTopic(@PathVariable String id) {
		courseService.deleteCourse(id);
	}
}
