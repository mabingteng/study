package com.ma.proxy;

public class SimpleRealObject implements SimpleProxy {

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
    SimpleProxyDemo.consumer(new SimpleRealObject());
    SimpleProxyDemo.consumer(new MySimpleProxy(new SimpleRealObject()));
	}
	
}

class MySimpleProxy implements SimpleProxy {

  private SimpleProxy proxied;

  public MySimpleProxy(SimpleProxy proxied) {
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

  public static void consumer(SimpleProxy iface) {
		iface.doSomething();
		System.out.println("-----------------------------------------------");
		iface.doSomethingElse("bobobo");
		System.out.println("-----------------------------------------------");
		System.out.println("-----------------------------------------------");
	}
	
}


