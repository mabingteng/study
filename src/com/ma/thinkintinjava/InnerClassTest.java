/**
 * 
 */
package com.ma.thinkintinjava;

import com.ma.thinkintinjava.InnerClassTest.InnerClass.InnerInnerClass;
import com.ma.thinkintinjava.InnerClassTest.InnerClass.InnerInnerClassStatic;
import com.ma.thinkintinjava.InnerClassTest.InnerClassA.InnerInnerClassA;

/**
 * @author waller
 *	�����ڲ��༰Ƕ����
 *  ���ۣ�1���ڲ���Ȩ�����ⲿ����ͨ������ͬ���ɷ��ʾ�̬/�Ǿ�̬���������ܴ�����̬����
 *  	 2��Ƕ����Ȩ�����ⲿ��̬������ͬ�����Է��ʾ�̬������������̬/�Ǿ�̬����
 */
public class InnerClassTest {

	private String a = "aaa";
	private static String  ss = "sssss";
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
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
		//static int xx = 0; ���ܴ�����̬����
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
			//System.out.println(a);���ܷ��ʷǾ�̬����
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
