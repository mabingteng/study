package com.ma.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

interface ITest{
	public void say();
}
class ITestImp implements ITest{

	@Override
	public void say() {
		System.out.println(" code 4 what ?");
	}
}

class Invocation implements InvocationHandler{

	Object o;
	public Invocation(Object o){
		this.o = o;
	}
	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		System.out.println("before proxy");
		Object rst = null;
		try{
			rst = method.invoke(o, args);
		}catch ( RuntimeException e){
			e.printStackTrace();
		}
		
		System.out.println("after proxy");
		return rst;
	}
	
}
public class MyTest {

	public static void main(String[] args) {
		ITestImp test = new ITestImp();
		ITest tt = (ITest)Proxy.newProxyInstance(test.getClass().getClassLoader(), 
				test.getClass().getInterfaces(), new Invocation(test));
		tt.say();
	}

}
