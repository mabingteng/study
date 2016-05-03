package com.ma.DynimicProxy;

public class Hello implements IHello,IHello2 {
	private String ts;
	public Hello(String ts){
		this.ts = ts;
	}
	@Override
	public void sayHello() {
		System.out.println("say hello "+ts);

	}
	public void doSomething(){
		System.out.println("do something");
	}

}
