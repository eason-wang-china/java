package com.eason.springboot.web.controller.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.eason.springboot.dao.jpa.PersonRepository;
import com.eason.springboot.domain.jpa.Person;

@Controller("JpaPersonController") // 在不同包名下存在同名类的情况，需要给他 Bean 指定name属性
@RequestMapping("/jpa/persons")
public class PersonController {

	@Autowired
	private PersonRepository dao;
	
	@RequestMapping("/{id}")
	@ResponseBody
	String getPerson(@PathVariable("id") Integer id) throws Exception {
		
		System.out.println("person id is " + id);

		Person p = dao.getOne(1);
		
		return p.toString();
	}
}
