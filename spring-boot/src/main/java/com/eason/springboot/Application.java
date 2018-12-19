package com.eason.springboot;

import org.springframework.boot.Banner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ImportResource;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication(/*exclude={DataSourceAutoConfiguration.class}*/)
@EnableAsync // 启动异步支持
@ImportResource(locations = {"classpath:config/beans.xml"}) // 如果需要通过配置文件配置时，可以导入配置文件，目前已经不再推荐这种做法
@ServletComponentScan // 扫描 @WebServlet、 @WebFilter、 @WebListener 并将该类实例化
public class Application {

	public static void main(String[] args) {
		new SpringApplicationBuilder(Application.class)
				.bannerMode(Banner.Mode.CONSOLE) // 控制 banner 显示与否，以及显示在哪儿
				.run(args);
	}
}
