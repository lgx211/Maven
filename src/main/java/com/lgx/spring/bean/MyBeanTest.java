package com.lgx.spring.bean;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyBeanTest {

	public static void main(String[] args) {
		//定义容器并初始化
		//ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-bean.xml");
		AbstractApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-bean.xml");
		applicationContext.getBean(MyBean.class);
		//只有关闭容器时，才会调用destroy方法
		applicationContext.registerShutdownHook();
	}

}
