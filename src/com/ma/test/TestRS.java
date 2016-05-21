package com.ma.test;

import java.util.HashMap;

import com.mbt.filter1.Test;

class T1{
	void do1(){
		System.out.println(this);
		do2();
	}
	void do2(){
		System.out.println("T1 do2");
	}
}
public class TestRS extends T1{
	void do2(){
		System.out.println("TestRs do2");
	}
	public static void main(String args[]){
		
		/*new TestRS().do1();
		int [][] array = new int [2][3];
		System.out.println(array.length);
		for(int i=0;i<array.length;i++){
			int al[] = array[i];
			System.out.println(al.length);
		}
		*/
		/*ArrayList<Integer> list = new ArrayList<Integer>();
		for(int a = 0 ; a < 10 ; a++){
			list.add(a);
		}
		int [] a1 = {0,1,2,3,4,5,6,7,8,9};
		int [] a2 = new int[10];
		System.arraycopy(a1, 1, a2, 3, 3);
		
		for(int i = 0 ; i < 10 ; i++){
			System.out.println(a2[i]);
		}*/
		
		HashMap<Integer,String> map = new HashMap<Integer,String>();
		System.out.println("左移一位乘以2:");
		System.out.println(1<<30);
		
		Float f1 = new Float(-1.0 / 0.0);
		Float f2 = new Float(0.0 / 0.0);
		System.out.println(f1 +" :  "+ f1.isNaN());
		System.out.println(f2 + " : "+ f2.isNaN());
		for(int i =0 ; i<  1000; i++){
			new Test();
		}
		try {
			Thread.sleep(20000);
		} catch (InterruptedException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		System.gc();
		
		TestRS[] a = new TestRS [10000]; 
	}
}
