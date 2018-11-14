package com.eason.spring4.config.annotation;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.eason.spring4.config.annotation") // 注解接受的是一個數組，因爲只有一個包可以直接賦值一個字符串，因爲只用了一個默認屬性，可以不用加屬性名
//@ComponentScan({ "com.eason.spring4.config.annotation" })
//@ComponentScan({ "com.eason.spring4.config.annotation", "com.eason.spring4.config.java" }) // 數組用法
public class DiConfig {

}
