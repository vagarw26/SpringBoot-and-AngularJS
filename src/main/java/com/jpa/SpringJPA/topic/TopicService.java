package com.jpa.SpringJPA.topic;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicService {
	
	@Autowired
	private TopicRepository topicrepo;
	
	
	public List<Topic> getAllTopic(){
		
		List<Topic> topics=new ArrayList<Topic>();
		for (Topic t:topicrepo.findAll()) {
			topics.add(t);
			
		}
		return topics;
		
	}
	
	public void addTopic(Topic topic)
	{
		topicrepo.save(topic);
	}
	
	public Topic getTopic(String id)
	{
		return topicrepo.findById(id).get();
	}
	
	public void updateTopic(Topic t) {
		
		topicrepo.save(t);
	}
	
	public void deleteTopic(String s) {
		topicrepo.deleteById(s);
	}

}
