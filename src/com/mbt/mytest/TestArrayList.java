package com.mbt.mytest;

import java.util.ArrayList;
import java.util.Iterator;

public class TestArrayList {
	public static void main(String[] args) {
		ArrayList<Integer> al = new ArrayList<Integer>();
		al.add(new Integer(0));
		al.add(new Integer(1));
		for(Iterator<Integer> it = al.iterator();it.hasNext();){
			int i = it.next();
			System.out.println(i);
		}
		//System.arraycopy();
		
	}
	//Entry<Integer> entry  = new Entry<Integer>(null,null,null);
}
