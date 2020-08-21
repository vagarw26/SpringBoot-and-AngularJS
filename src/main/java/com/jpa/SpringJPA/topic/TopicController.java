package com.jpa.SpringJPA.topic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@Controller
@CrossOrigin(origins = "http://localhost:4200")
public class TopicController {
	
	
	
	@Autowired
	private TopicService topicservice;
	
	@RequestMapping("/index")
	public ModelAndView view(ModelAndView m,Topic t)
	{
//		Topic t=new Topic(id,name,description);
//		Topic t=topicservice.getTopic(id);
		m.addObject("myName",t);
		m.setViewName("index");
		return m;
	}
	
	@RequestMapping(method=RequestMethod.GET,value="/topics")
	public @ResponseBody List<Topic> getTopics()
	{
		return topicservice.getAllTopic();
		
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/topics")
	public @ResponseBody void addTopics(@RequestBody Topic t) {
		
		topicservice.addTopic(t);
	}
	
	@RequestMapping(value="/getOneTopic/{id}")
	public @ResponseBody Topic getOneTopic(@PathVariable String id)
	{
		return topicservice.getTopic(id);
	}
	
	@RequestMapping(method=RequestMethod.DELETE,value="topics/{id}")
	public @ResponseBody void deleteOneTopic(@PathVariable String id) {
		
		topicservice.deleteTopic(id);
	}
	
	@RequestMapping(method=RequestMethod.PUT,value="/topics")
	public @ResponseBody void udateOneTopic(@RequestBody Topic t)
	{
		topicservice.updateTopic(t);

	}

}
