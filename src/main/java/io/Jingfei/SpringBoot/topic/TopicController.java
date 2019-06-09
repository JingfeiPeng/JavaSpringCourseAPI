package io.Jingfei.SpringBoot.topic;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TopicController {
	
	@Autowired   // marks as it needs dependency injection
	private TopicService topicSerivce;

	@RequestMapping("/topics")
	public List<Topic> getAllTopics() {
		// converted to json automatically
		return topicSerivce.getAllTopics();
	}
	
	@RequestMapping("/topics/{id}") // id is a variable
	public Optional<Topic> getTopic(@PathVariable String id) {
		return topicSerivce.getTopic(id);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/topics")
	public String addTopic(@RequestBody Topic topic) {
		topicSerivce.addTopic(topic);
		return "Success";
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/topics/{id}")
	public String updateTopic(@RequestBody Topic topic, @PathVariable String id) {
		topicSerivce.updateTopic(id, topic);
		return "Success";
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value= "/topics/{id}") // id is a variable
	public void deleteTopic(@PathVariable String id) {
		topicSerivce.deleteTopic(id);
	}
}
