package io.Jingfei.SpringBoot.topic;

import org.springframework.data.repository.CrudRepository;

                                                      //object type, primary key type
public interface TopicRepository extends CrudRepository<Topic, String>{
	
	// Spring Data JPA framework comes with these methods, your repository gets them by being a child
	// getAllTopics()
	// getTopic(String id)
	// updateTopic(Topic t)
	
	
}
