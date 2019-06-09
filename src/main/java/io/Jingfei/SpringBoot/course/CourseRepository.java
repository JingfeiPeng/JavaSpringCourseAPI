package io.Jingfei.SpringBoot.course;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

                                                      //object type, primary key type
public interface CourseRepository extends CrudRepository<Course, String>{
	
	// Spring Data JPA framework comes with these methods, your repository gets them by being a child
	// getAllTopics()
	// getTopic(String id)
	// updateTopic(Topic t)
	
	// methods are automically completed due to their name
	public List<Course> findByName(String name);
	public List<Course> findByDescription(String desc);
	// find by Topic property on the course and then Id property
	public List<Course> findByTopicId(String topicId);
	
	
}
