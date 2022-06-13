package com.lgx.spring.aop.jdk;

import java.lang.reflect.Proxy;

public class UserTest {

	public static void main(String[] args) {

		UserHandle userHandle = new UserHandle();

		IUser user = (IUser) Proxy.newProxyInstance(
				User.class.getClassLoader(),
				User.class.getInterfaces(), userHandle);

		user.eat();

	}
}
