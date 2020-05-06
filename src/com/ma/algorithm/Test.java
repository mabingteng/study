package com.ma.algorithm;

import java.util.PriorityQueue;

public class Test {

	public static void main(String[] args) {
		PriorityQueue<String> s =  new PriorityQueue<>();
		Integer i1 = 10;
		Integer i2 =10;
		Integer i3 =100;
		Integer i4 =200;
		//System.out.println(i1==i2);
		//System.out.println(i3==i4);
		//System.out.println(i4.equals(i3+i3));
		
		//System.out.println(2.00-1.10);
		//System.out.println(1.0f-0.9f);
		/*String s1 = "123";
		String s2 = new String("123");
		System.out.println(s1.equals(s2));
		System.out.println("s1 hashcode:"+s1.hashCode());
		System.out.println("s2 hashcode:"+s2.hashCode());*/

		/*String sa = "sss";
		System.out.println(sa==new A().get());
		int a = 127;
		int b  = 2;
		a  =a+ b;*/
		//String str = System.getProperties().toString().replaceAll(",", "\n");
		//System.out.println(str);
		System.out.println(3*0.1==0.3);
	
		//A ab = new A();
		//ab.run();
		System.out.println("----------------------------");
		A.run();
		//new B().test();
	}

}

class A{
	public A(){
		System.out.println("A init");
	}
	public String get(){
		return "sss";
	}
	public static void  run(){
		System.out.println("a.run");
	}
	public void test(){
		System.out.println("a test");
	}
}
class B extends A{
	{
		System.out.println("b {} ");
	}
	public B(){
		System.out.println("b init");
	}
	public static void run(){
		System.out.println("b.run");
	}
	
}
class C extends A{	
public C (){
	System.out.println("c init");
}
public static void run(){
	System.out.println("c.run");
}
}