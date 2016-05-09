package com.mbt.mylist;

import java.util.Arrays;
import java.util.List;
//asList（）的输出，其底层表示是数组。虽然可以当作List但不能调用引发数组长度改变的方法，如add delete
public class TestAsList {
	public static void main(String args[]){
		List l = Arrays.asList(1,2,3,4.1,5,6);
		//l.add(7);
		for(Object i : l){
			System.out.println(i);
		}
		Object []  os = new Object[10];
		System.out.println(l.toString());
		
	}
}
