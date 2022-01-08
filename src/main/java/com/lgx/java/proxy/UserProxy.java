package com.lgx.java.proxy;

public class UserProxy implements IUser {

	public void eat() {
		System.out.println("===做菜===");

		User user = new User();
		user.eat();

		System.out.println("===遛弯===");
	}
}



