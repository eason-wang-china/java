package com.eason.springboot.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Component
@PropertySource("classpath:config/project-settings.properties") // 加载配置文件
@ConfigurationProperties(prefix = "project") // 从所有的配置文件中加载配指定前缀的属性，SpringBoot5 废除了 locations 属性，需要利用 @PropertySource 加载配置文件
@Getter
@Setter
public class ProjectSettings {

	@Value("#{systemProperties['user.dir']}") // 记录日志可以使用这个路径
	private String userDir;
	
	@Value("#{systemProperties['catalina.base']}") // 记录日志可以使用这个路径
	private String catalinaDir;
	
	@Value("${i.want.say}") // 从 application.properties 直接获取数据
	private String saySomething;
	
	// 下面这三个属性来自 project-settings.properties， @ConfigurationProperties(prefix = "project") 负责配置
	private String name;
	private String createTime;
	private String author;
	
	public String toString() {
		return getName() + " - " + getCreateTime() + " - " + getAuthor() 
				+ " <br><br> " + "saySomething: " + getSaySomething() 
				+ " <br><br> " + "user.dir: " + getUserDir() 
				+ " <br><br> " + "catalina.base: " + getCatalinaDir();
	}

}
