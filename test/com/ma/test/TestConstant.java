package com.ma.test;

public class TestConstant {
	public String publicstr ;
	private String privatestr;
	public TestConstant(String s){
		this.publicstr =s ;
		this .privatestr = s;
	}
	public void say(){
		System.out.println(publicstr);
	}
}
