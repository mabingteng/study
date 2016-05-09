package com.mbt.reflect;

import java.lang.reflect.Constructor;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
@SuppressWarnings("unchecked")
/**
 * 测试使用java的反射能否调用私有方法或私有构造器
 * @author mbt
 *
 */
public class TestPrivate {
	public static void main(String args[]) throws NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		
		Class<Test> clz  = Test.class;
		Constructor<Test> c =  clz.getDeclaredConstructor(String.class);
		c.setAccessible(true);
		Test t = c.newInstance("s");
		//调用私有构造器，实例对象成功
	
		
		Method m = clz.getDeclaredMethod("pmethod", String.class);
		m.setAccessible(true);
		m.invoke(clz.newInstance(), "s");
		//执行私有方法成功
	}
}
