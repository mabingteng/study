package com.ma.algorithm;

public class Insertion extends SortHelper{

	
	@Override
	public void sort(Comparable[] a) {
		int size = a.length;
		for(int i = 1; i < size; i++)
		    {
		        int j = i;
		        Comparable t = a[j];
		        for(; j > 0 && less(t,a[j-1]); j--)
		            a[j] = a[j - 1];
		        
		        a[j] = t;
		        show(a);
		    }
	}
	
	public static void  main(String args[]){
		Integer[] s = {5,4,3,2,1,6,8};
		show(s);
		//new Insertion().sort(s);
		insertion2(s);
		show(s);
	}

}
