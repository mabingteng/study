package com.ma.reference;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;

public class ReferenceTest {
	
	public static void main(String[] args) throws Exception {
		soft();
	}
	/** 
	 * ֻ�е��ڴ治����ʱ�򣬲Ż��������ڴ棬������ڴ��㹻��ʱ������ͨ���������� 
	 *  
	 * <pre> 
	 * �����Ƿ���GC,ִ�н������: 
	 * java.lang.Object@f9f9d8 
	 * null 
	 * java.lang.Object@f9f9d8 
	 * null 
	 * </pre> 
	 *  
	 * ���Կ���:ֻ�з�����GC,�����ڴ��ڴ����ͷŵ�ʱ��,JVM�ŻὫreference�������ö��� 
	 */  
	public static void soft() throws Exception  
	{  
	    Object obj = new Object();  
	    ReferenceQueue<Object> refQueue = new ReferenceQueue<Object>();  
	    SoftReference<Object> softRef = new SoftReference<Object>(obj, refQueue);  
	    System.out.println(softRef.get()); // java.lang.Object@f9f9d8  
	    System.out.println(refQueue.poll());// null  
	  
	    // ���ǿ����,����GC  
	    obj = null;  
	    System.gc();  
	  
	    System.out.println(softRef.get());  
	  
	    Thread.sleep(200);  
	    System.out.println(refQueue.poll());  
	}
}
