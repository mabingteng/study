/**
 * 
 */
package com.mbt.reflect;

/**
 * @author waller
 * Because reflection involves types that are dynamically resolved, certain Java virtual machine 
 * optimizations can not be performed. Consequently, reflective operations have slower performance
 * than their non-reflective counterparts, and should be avoided in sections of code which are 
 * called frequently in performance-sensitive applications.
 * 使用缓存优化
 */
public class ReflectPerformance {

		public static void main(String[] args) throws Exception
		{
		    doRegular();
		    doReflection();
		}

		public static void doRegular() throws Exception
		{
		    long start = System.currentTimeMillis();
		    for (int i=0; i<1000000; i++)
		    {
		        Test a = new Test();
		        a.pub();
		    }
		    System.out.println(System.currentTimeMillis() - start);
		}

		public static void doReflection() throws Exception
		{
		    long start = System.currentTimeMillis();
		    for (int i=0; i<1000000; i++)
		    {
		        Test a = (Test) Class.forName("com.mbt.reflect.Test").newInstance();
		        a.pub();
		    }
		    System.out.println(System.currentTimeMillis() - start);
		}
}
