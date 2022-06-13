package com.lgx.spring.aop.cglib;


import org.springframework.cglib.proxy.Enhancer;

public class UserTest {

	public static void main(String[] args) {

		Enhancer enhancer = new Enhancer();

		enhancer.setSuperclass(User.class);
		enhancer.setCallback(new UserInterceptor());

		User user = (User) enhancer.create();
		user.eat();
	}
}
