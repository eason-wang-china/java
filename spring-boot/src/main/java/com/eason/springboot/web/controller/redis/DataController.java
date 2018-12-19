package com.eason.springboot.web.controller.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.eason.springboot.redis.Person;
import com.eason.springboot.redis.PersonDao;

@RestController
@RequestMapping("/redis")
public class DataController {

	@Autowired
	PersonDao personDao;

	@RequestMapping("/set") // 1
	public void set(
			@RequestParam(defaultValue = "1") int id, 
			@RequestParam(defaultValue = "我的名字是？") String name, 
			@RequestParam(defaultValue = "36") int age) {
		
		Person person = new Person(id, name, age);
		personDao.save(person);
		personDao.stringRedisTemplateDemo();
	}

	@RequestMapping("/getStr") // 2
	public String getStr() {
		
		return personDao.getString();
	}

	@RequestMapping("/getPerson") // 3
	public Person getPerson() {
		
		return personDao.getPerson();
	}
}
