package io.Jingfei.SpringBoot.topic;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service                // marks as a Spring service
public class TopicService {
	
	// business service: are singletons
	// creates an instance of this service when App starts up
	// inject the instance to different classes
	
	// inject an instance of topicRepository when creating an instance of TopicService
	@Autowired
	private TopicRepository topicRespository;
	
	public List<Topic> getAllTopics(){
		List<Topic> topics = new ArrayList<>();
		topicRespository.findAll().forEach(topics::add);
		return topics;
	}
	
	public Optional<Topic> getTopic(String id) {
		return topicRespository.findById(id);
	}
	
	public void addTopic(Topic topic) {
		topicRespository.save(topic);
	}

	public void updateTopic(String id, Topic topic) {
		topicRespository.save(topic); // save can do both add and update
	}

	public void deleteTopic(String id) {
		// topics.removeIf(t -> t.getId().equals(id));
		topicRespository.deleteById(id);
	}
	

}
