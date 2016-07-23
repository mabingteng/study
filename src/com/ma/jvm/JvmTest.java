package com.ma.jvm;


public class JvmTest {

	public static void main(String[] args) throws  Exception {
		MyClassLoader mLoader  = new MyClassLoader();
		 
		ClassLoader clazz = mLoader.getClass().getClassLoader();
	//	System.out.println(clazz);
	//	System.out.println(clazz.getClass());
	//	System.out.println(clazz.getClass().getClassLoader());
	
		while(clazz!=null){
			System.out.println(clazz);
			clazz = clazz.getParent();
		}
		System.out.println(clazz);
		Object jt = mLoader.loadClass("com.ma.jvm.JvmTest").newInstance();
		System.out.println(jt.getClass());
		System.out.println(jt instanceof com.ma.jvm.JvmTest);
	}
	
}
