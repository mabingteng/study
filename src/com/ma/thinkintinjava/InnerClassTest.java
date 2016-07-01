/**
 * 
 */
package com.ma.thinkintinjava;

import com.ma.thinkintinjava.InnerClassTest.InnerClass.InnerInnerClass;
import com.ma.thinkintinjava.InnerClassTest.InnerClass.InnerInnerClassStatic;
import com.ma.thinkintinjava.InnerClassTest.InnerClassA.InnerInnerClassA;

/**
 * @author waller
 *	测试内部类及嵌套类
 *  结论：1，内部类权限与外部类普通方法相同，可访问静态/非静态变量，不能创建静态变量
 *  	 2，嵌套类权限与外部静态方法相同，可以访问静态变量，创建静态/非静态变量
 */
public class InnerClassTest {

	private String a = "aaa";
	private static String  ss = "sssss";
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		//System.out.println(a);		
		//InnerClass ic = new InnerClass();
		//InnerInnerClass iic  = ic.new InnerInnerClass();
		//iic.iictest();
		
		
		InnerClassTest ict = new InnerClassTest();
		InnerClassA ica = ict.new InnerClassA();
		ica.iictest();
		//InnerInnerClassA iica = ica.new InnerInnerClassA();
		//System.out.println(ss);
		//InnerInnerClassStatic iics = new InnerInnerClassStatic();
		//iic.iictest();
	}
	public void testMethod(){
		//static int s =1;
		System.out.println(a);
		System.out.println(ss);
	}
	public class InnerClassA{
		String  ss ="innerclass ss";
		//static int aaa = 0;
		{
			System.out.println(a);
			System.out.println(ss);
		}
		//static int xx = 0; 不能创建静态变量
		private int b =1;
		public void iictest(){
			System.out.println("print in iictest");
			System.out.println(ss);
		}
		public class InnerInnerClassA{
			public void iictest(){
				System.out.println("print in iictest");
				System.out.println(ss);
			}
		}
	}
	public static class InnerClass{
		{
			//System.out.println(a);不能访问非静态变量
			System.out.println(ss);
		}
		private	int x =1;
		static int y =1;
		public class InnerInnerClass{
			
			public void iictest(){
				System.out.println(x);
				System.out.println(ss);
			}
		}
		public static class InnerInnerClassStatic{
			
			public void iictest(){
				//System.out.println(x);
				System.out.println(ss);
			}
		}
	}

}
