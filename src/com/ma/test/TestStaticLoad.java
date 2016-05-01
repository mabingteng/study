package com.ma.test;
class Parent{
	static int a  =1 ;
	static{
		System.out.println("parent static block");	
	}
	static void dosom(){
		System.out.println("parent static method!");
	}
}
class Child1  extends Parent{
	static {
		System.out.println("child1 static block");
	}
}
class Child2 extends Parent{
	
	static int a = 2;
	static{
		
		System.out.println("child2 static block");
	}
	
	static void dosom(){
		
	}
}
public class TestStaticLoad {

	public TestStaticLoad(String string) {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) throws ClassNotFoundException {
		//Class<?> clazz = ClassLoader.getSystemClassLoader().loadClass("com.ma.test.Child2");
		//Class<?> cc =  Class.forName("com.ma.test.");
		//Child2 c1 = new Child2();
		/*for(int b= 0;true;b++){
			//int a = 10;
			int [][] a = new int [1024][1024];
			//a[b] = new int [1024*100];
			System.out.println("XXXXXX");
			
		}*/
		TestConstant a =  new TestConstant("s");
		//c1.dosom();
	}

}
