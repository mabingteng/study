package com.ma.DynimicProxy;

public class DynamicProxyTest {

	public static void main(String[] args) {
		IHello hello = (IHello)new DynamicProxy().bind(new Hello());
		hello.sayHello();
	}

}
