package com.ma.test;
/**
 * Because reflection involves types that are dynamically resolved, certain Java virtual
 * machine optimizations can not be performed. Consequently, reflective operations have 
 * slower performance than their non-reflective counterparts, and should be avoided in 
 * sections of code which are called frequently in performance-sensitive applications.
 * @author root
 *
 */
/*
 * 反射涉及类型的动态解析，必然使得jvm无法对操作指令优化。因此反射操作性能比非反射较慢。避免频繁使用已影响性能。
 */
public class FeatureRef {
	

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
		        Father a = new Father();
		        a.f2();;
		    }
		    System.out.println(System.currentTimeMillis() - start);
		}

		public static void doReflection() throws Exception
		{
		    long start = System.currentTimeMillis();
		    for (int i=0; i<1000000; i++)
		    {
		        Father a = (Father) Class.forName("com.ma.test.Father").newInstance();
		        a.f2();
		    }
		    System.out.println(System.currentTimeMillis() - start);
		}
		
}
