package com.mbt.reflect;

public class Test {
	public Test(){
		System.out.print("Test: public Test()");
	}
	private Test(String s){
		System.out.println("Test: private Test(String s)");
	}
	private String pmethod(String s){
		System.out.println("Test: private String pmethod(String s)");
		return s;
	}
	public String pub(String s){
		System.out.println("Test : public pub(String s)");
		return s;
	}
}
