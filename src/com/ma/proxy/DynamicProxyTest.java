package com.ma.proxy;

import java.lang.reflect.Proxy;

public class DynamicProxyTest {

	public static void main(String[] args) {
		System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
		Proxy hello = (Proxy) new DynamicProxy().bind(new DynamicHelloImpl("tt"));
		//hello.sayHello();
		System.out.println(hello);
	}

}
