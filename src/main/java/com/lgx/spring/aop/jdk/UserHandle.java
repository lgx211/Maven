package com.lgx.spring.aop.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class UserHandle implements InvocationHandler {

	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {

		Object User = new User();

		System.out.println("===做菜===");

		method.invoke(User, args);

		System.out.println("===遛弯===");
		return null;
	}
}
