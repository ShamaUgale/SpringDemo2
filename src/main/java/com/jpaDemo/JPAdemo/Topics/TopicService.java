package com.jpaDemo.JPAdemo.Topics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class TopicService {

	@Autowired
	private TopicRepository topicRepo;
	
	
	public List<Topic> getAlltopics(){
		List<Topic> t= new ArrayList<Topic>();
		topicRepo.findAll().forEach(t::add);
		return t;
	}
	
	public Topic getTopic(String id){
		return topicRepo.findOne(id);
	}

	public void addTopic(Topic topic) {
		// TODO Auto-generated method stub
		topicRepo.save(topic);
	}

	public void updateTopic(Topic topic, String id) {
		// TODO Auto-generated method stub
		topicRepo.save(topic);
	}

	public void dleteTopic(String id) {
		// TODO Auto-generated method stub
		topicRepo.delete(id);
	}
}
