package com.ma.test;

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
		new TestRS().do1();
		int [][] array = new int [2][3];
		System.out.println(array.length);
		for(int i=0;i<array.length;i++){
			int al[] = array[i];
			System.out.println(al.length);
		}
	}
}
