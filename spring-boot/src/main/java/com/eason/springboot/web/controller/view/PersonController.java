package com.eason.springboot.web.controller.view;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.eason.springboot.web.vo.PersonVO;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
@RequestMapping("/persons")
public class PersonController {

	@RequestMapping({ "", "/" })
	String list(Model model) {
		PersonVO single = new PersonVO("eason wang", 11);

		List<PersonVO> people = new ArrayList<PersonVO>();
		people.add(new PersonVO("xx", 11));
		people.add(new PersonVO("yy", 22));
		people.add(new PersonVO("zz", 33));

		model.addAttribute("singlePerson", single);
		model.addAttribute("people", people);

		return "people-list";
	}

	@RequestMapping("/{id}")
	@ResponseBody
	String getPerson(@PathVariable("id") Integer id) throws Exception {
		System.out.println("person id is " + id);

		PersonVO result = new PersonVO("eason wang!!!", 36);
		ObjectMapper mapper = new ObjectMapper();

		return mapper.writeValueAsString(result);
	}
}
