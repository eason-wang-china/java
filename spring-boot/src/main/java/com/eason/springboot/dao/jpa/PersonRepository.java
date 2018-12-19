package com.eason.springboot.dao.jpa;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.eason.springboot.domain.jpa.Person;

@Transactional // 可以加在这个接口上，也可以只加在 service 类上，也可以加在方法上
public interface PersonRepository extends JpaRepository<Person, Integer> {

	/**
	 * 根据方法名查询，方法名要和实体类的属性名匹配才可以
	 * find, findBy, read, readBy, query, queryBy, get, getBy
	 */
	
	// 相等查询 from tb_person p where p.name=?
	List<Person> findByName(String name);

	// Like查询 from tb_person p where p.name like ?
	List<Person> findByNameLike(String name);
	
	// @Transactional(readOnly = true)
	// from tb_person p where p.name=? and p.age=?
	Person findByNameAndAge(String name, Integer age);
	
    // from tb_person p where p.name like ? or p.age=? 如果只能查出一个结果，则返回值可以直接是一个实体，但是如果查出了多个结果会报错
	Page<Person> findByNameLikeOrAge(String name, Integer age, Pageable pageable);

	// 匹配到 @NamedQuery(name = "Person.findByAge", query = "select p from Person p where p.age = ?1"), 这个时候方法名字还是需要和类属性对应的，否则报错
	List<Person> findByAge(Integer age);
	
	@Query("select p from Person p where p.sex = ?1") 
	List<Person> findBySex(Character sex);
	
	@Query("select p from Person p where p.sex = ?1") // 方法名字可以自定义
	List<Person> findPersonList(Character sex);
	
	@Modifying
	@Transactional
	@Query("update Person p set p.name = :name where p.id = :id")
	int setName(@Param("name") String name, @Param("id")Integer id);
}
