package com.ma.test.load.order;

public class StaticFunction {
	public StaticFunction() {
		System.out.println("init statictest class ! ");
	}
	public static void  Test(){
		System.out.println("test function");
	}
	public static void main(String[] args) {
		StaticFunction.Test();
		StaticFunction sFunction  = new StaticFunction();
	}
}
