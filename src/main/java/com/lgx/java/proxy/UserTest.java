package com.lgx.java.proxy;

public class UserTest {

	public static void main(String[] args) {
		IUser user = new UserProxy();
		//UserProxy user = new UserProxy();
		user.eat();
	}

}



