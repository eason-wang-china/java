package com.eason.spring4.el;

import java.io.IOException;
import java.nio.charset.Charset;

import javax.inject.Inject;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.Resource;

@Configuration
@ComponentScan("com.eason.spring4.el")
@PropertySource("classpath:com/eason/spring4/el/my-values.properties")
// @PropertySource(value = "classpath:my-values.properties", encoding = "utf-8", ignoreResourceNotFound = true)
public class ElConfig {

	@Inject
	private My my;

	@Value("${my.name}")
	private String name;

	@Value("${my.age}")
	private int age;

	@Value("#{systemProperties['os.name']}")
	private String osName;

	@Value("#{T(java.lang.Math).random() * 100}")
	private double random;

	@Value("#{my.name}")
	private String myName;

	@Value("classpath:com/eason/spring4/el/my-values.properties")
	private Resource rFile;
	
	@Value("http://www.baidu.com")
	private Resource urlFile;

	public void outputResult() throws IOException {

		System.out.println(my.getName() + " -- " + my.getAge());
		System.out.println(name + " -- " + age);
		System.out.println(osName);
		System.out.println(random);
		System.out.println(myName);
		
		System.out.println("--local file--");
		System.out.println(IOUtils.toString(rFile.getInputStream(), Charset.defaultCharset()));

		System.out.println("--www file--");
		System.out.println(IOUtils.toString(urlFile.getInputStream(), Charset.forName("UTF-8")));
		
	}
}
