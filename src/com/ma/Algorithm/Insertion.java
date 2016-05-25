package com.ma.Algorithm;

public class Insertion extends SortHelper{

	
	@Override
	public void sort(Comparable[] a) {
		for(int i = 1;i<a.length ; i++){
			for(int j=i ; j>0&&less(a[j],a[j-1]); j--)
				exch(a,j,j-1);
		}
	}
	
	public static void  main(String args[]){
		Integer[] s = {1,3,4,5,7,66,5,4,33,2,11,3,4444,2,44,5,6,75,32};
		//new Insertion().sort(s);
		insertion(s);
		show(s);
	}

}
