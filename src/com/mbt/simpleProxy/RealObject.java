package com.mbt.simpleProxy;

public class RealObject implements Interface {

	//private Object proxid;
	@Override
	public void doSomething() {
		// TODO Auto-generated method stub
		System.out.println("doSomething");

	}

	@Override
	public void doSomethingElse(String args) {
		// TODO Auto-generated method stub
		System.out.println("somethingElse "+args);

	}
	public static void main(String[] args){
		SimpleProxyDemo.consumer(new RealObject());
		SimpleProxyDemo.consumer(new SimpleProxy(new RealObject()));
	}
	
}
class SimpleProxy implements Interface{
	private Interface proxied;
	public SimpleProxy(Interface proxied) {
		this.proxied = proxied;
	}
	@Override
	public void doSomething() {
		System.out.println("SimpleProxy doSomething");
		proxied.doSomething();
	}

	@Override
	public void doSomethingElse(String arg) {
		System.out.println("SimpleProxid somethingElse "+arg);
		proxied.doSomethingElse(arg);
	}
	
}
class SimpleProxyDemo{
	public static void consumer(Interface iface ){
		iface.doSomething();
		System.out.println("-----------------------------------------------");
		iface.doSomethingElse("bobobo");
		System.out.println("-----------------------------------------------");
		System.out.println("-----------------------------------------------");
	}
	
}


