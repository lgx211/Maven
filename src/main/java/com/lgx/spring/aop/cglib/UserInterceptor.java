package com.lgx.spring.aop.cglib;

import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class UserInterceptor implements MethodInterceptor {
	public Object intercept(Object o, Method method,
							Object[] objects,
							MethodProxy methodProxy) throws Throwable {

		System.out.println("===做菜===");

		methodProxy.invokeSuper(o, objects);

		System.out.println("===遛弯===");
		return null;
	}
}
