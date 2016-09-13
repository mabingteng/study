package com.ma.reference;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentHashMap;

public class ReferenceTest {
	
	public static void main(String[] args) throws Exception {  
		  //soft();
		ConcurrentHashMap<String, String> map = new ConcurrentHashMap<>();
		
		  ThreadLocalMapWeakKey();
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
	@SuppressWarnings("unchecked")
	public static void soft() throws Exception  
	{  
	    Object obj = new Object();  
	    ReferenceQueue<Object> refQueue = new ReferenceQueue<Object>();  
	    
	    WeakReference<Object> softRef = new WeakReference<Object>(obj, refQueue);  
	    WeakReference<Object> weakRef= null;
	    System.out.println(softRef.get()); // java.lang.Object@f9f9d8  
	    System.out.println(refQueue.poll());// null  
	    
	    // ���ǿ����,����GC  
	    obj = null;  
	    System.gc();  
	  
	    System.out.println(softRef.get());  
	    
	    Thread.sleep(200);  
	    weakRef=(WeakReference<Object>) refQueue.poll();
	    System.out.println(refQueue.poll());  
	    System.out.println(weakRef == softRef);
	}
	public static void tstWeakHashMap(){
		  List<WeakHashMap<byte[][], byte[][]>> maps = new ArrayList<WeakHashMap<byte[][], byte[][]>>();  
		    HashMap<byte[][],byte[][]> map = new HashMap<>();
		    WeakHashMap<byte[][], byte[][]> d = new WeakHashMap<byte[][], byte[][]>();  
		    for (int i = 0; i < 1000; i++) {  
		        d.put(new byte[1000][1000], new byte[2000][2000]);  
		        maps.add(d);  
		        System.gc();  
		        System.err.println(i);  
		        
		        for (int j = 0; j < i; j++) {  
	                System.err.println(j+  " size " + maps.get(j).size());  
	            }  
		  
		    }  
		  
	}
	public static void ThreadLocalMapWeakKey() throws InterruptedException{
		ReferenceTest referent = new ReferenceTest();
		//WeakReference<ReferenceTest> ref = new WeakReference<ReferenceTest>(referent);
		End e = new End(1);
		WeakHashMap<ReferenceTest,End> weak = new WeakHashMap<>();
		weak.put(referent, e);
		referent = null;
		e = null;
		System.out.println(weak.size());
		//weak.clear();\
		referent = new ReferenceTest();
		e = new End(2);
		//weak.put(referent, e);
		
		System.gc();
		Thread.sleep(1000);
		//gc key  , if call expungeStaleEntries() e.value = null;
		//System.out.println(weak.size());
		System.gc();
		Thread.sleep(1000);
		//gc value ,depends expungeStaleEntries() called


	}
	 protected void finalize(){
	       System.out.println("Finalizing "+getClass().getSimpleName()+" ");
	    }
}
 class End{
	 private int x;
	 public End(int a){
		 this.x = a;
	 }
	 
	 protected void finalize(){
	       System.out.println("Finalizing "+getClass().getSimpleName()+" "+x);
	 }
}