package com.ma.test;
/**
 * 总结：常量池中的字面量和符号引用。字面量为所有字符串和final常量值。
 * 		符号引用为类和接口全限定名，方法和字段的名称和描述符
 * 注意：String strobj = new String（"str"） 的存储。 str和对象引用在常量池中，对象在堆中。
 * 		常量池中的str如何处理的？就存者，strobj创建对象的时候用一下。
 */
public class Father {
	//ab都没存入常量池，存入常量池须加final
	public  int a=5;
	private  int b=5;
	//常量值减一保存在了常量池
	public int stnum=Integer.MAX_VALUE-1;
		public static void f1(int number){
			System.out.println("Father-f1()");
		}
	public final void f2(){
		    //常量池存在123.455
		    String  strobj = new String ("str obj test");
		    String  str = "str obj test";
		   // System.out.println(strobj == str); //false
			int f2a = 12345;                         
			//常量池不存在12345，字面量的概念？ 字符串/final  
			// 局部变量为什么会在常量池中？ 局部变量是常量
			//s3 和 s4 如何存放？ 
			String  s1 = "ab";
			String s2 = "cde";
			//常量池存放了abcde
			String s3= "ab"+"ced";
			//使用StringBuilder组合
			String s4 = s1+s2;
			
		}
}