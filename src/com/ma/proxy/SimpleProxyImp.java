package com.ma.proxy;

public class SimpleProxyImp implements SimpleProxy {

	@Override
	public void doSomething() {
		// TODO Auto-generated method stub
		System.out.println("InterfaceImp dosomething");
		
	}

	@Override
	public void doSomethingElse(String arg) {
		// TODO Auto-generated method stub
		System.out.println("InterfaceImp dosomething else");
		
	}

}
