package com.jpaDemo.JPAdemo.Topics;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class TopicsController {

	@Autowired
	private TopicService topicService;
	
	@RequestMapping("/topics")
	public List<Topic> getAllTopics(){
		return topicService.getAlltopics();
	}
	
	@RequestMapping("/topics/{foo}")
	public Topic getTopic(@PathVariable("foo") String id){
		return topicService.getTopic(id);
	}
	
	@RequestMapping(method= RequestMethod.POST, value="/topics")
	public void addTopic(@RequestBody Topic topic){
		topicService.addTopic(topic);
	}
	
	@RequestMapping(method= RequestMethod.PUT, value="/topics/{id}")
	public void updateTopic(@RequestBody Topic topic,@PathVariable("id") String id){
		topicService.updateTopic(topic,id);
	}
	
	@RequestMapping(method= RequestMethod.DELETE, value="/topics/{foo}")
	public void deleteTopic(@PathVariable("foo") String id){
		 topicService.dleteTopic(id);
	}
}

