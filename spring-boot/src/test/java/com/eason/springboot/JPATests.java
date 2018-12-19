package com.eason.springboot;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.eason.springboot.dao.jpa.PersonRepository;

import lombok.extern.slf4j.Slf4j;

@RunWith(SpringRunner.class) // SpringRunner extends SpringJUnit4ClassRunner 和
								// @RunWith(SpringJUnit4ClassRunner.class) 使用的是用一个类
@SpringBootTest

@Transactional // 因为下面测试的是dao，有可能没有加事务，所以这儿需要加，否则报异常，当然也可以加在测试方法上，或者被测试的类/方法上
@Rollback(false) // 是否回滚可以被方法上的注解设置覆盖

@Slf4j
public class JPATests {

	@Autowired
	private PersonRepository dao;
	
	// private SimpleJpaRepository<T, ID> sJpa;

	@Test
	public void testFindAndGet() {

//		Person p = dao.getOne(1);
//		log.info(p.toString());
//
//		List<Person> p_1_List = dao.findByName("eason");
//		log.info(p_1_List.toString());
//
//		List<Person> p_2_List = dao.findByNameLike("王");
//		log.info(p_2_List.toString());
		
//		Person p_3_List = dao.findByNameAndAge("eason", 32);
//		log.info(p_3_List.toString());
		
//		Page<Person> p_4_List = dao.findByNameLikeOrAge("eason", 32, PageRequest.of(0, 10, new Sort(Direction.ASC, "id")));
//		p_4_List.forEach((Person p) -> {
//			log.info(p.toString());
//		});
		
//		List<Person> p_5_List = dao.findByAge(32);
//		log.info(p_5_List.toString());
//		
//		List<Person> p_6_List = dao.findBySex('男');
//		log.info(p_6_List.toString());
//		
//		List<Person> p_7_List = dao.findPersonList('男');
//		log.info(p_7_List.toString());
		
		int flag = dao.setName("jack wang", 1);
		log.info("result is : " + flag);
		
//		throw new IllegalArgumentException("");

	}

}
