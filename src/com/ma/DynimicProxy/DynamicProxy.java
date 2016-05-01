package com.ma.DynimicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DynamicProxy implements InvocationHandler {

	Object ori;
	public Object  bind(Object o){
		this.ori = o;
		return Proxy.newProxyInstance(o.getClass().getClassLoader(),
				o.getClass().getInterfaces(),  this);
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		
		System.out.println("dynamic  proxy ");	
		Object ob = method.invoke(ori, args);
		return ob;
	}

}
