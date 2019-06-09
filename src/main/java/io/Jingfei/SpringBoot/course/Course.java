package io.Jingfei.SpringBoot.course;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import io.Jingfei.SpringBoot.topic.Topic;

@Entity   // Convert topic instance to a row in Database, convert a row in DB to a topic instance
public class Course {
	
	@Id
	private String id; // primary key
	private String name;
	private String description;
	
	// many to one mapping
	@ManyToOne
	private Topic topic; // tie to a topic instance
	
	public Topic getTopic() {
		return topic;
	}

	public void setTopic(Topic topic) {
		this.topic = topic;
	}

	// null constructor
	public Course() {
	}
	
	public Course(String id, String name, String description, String topicID) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.topic = new Topic(topicID, "", "");
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
}
