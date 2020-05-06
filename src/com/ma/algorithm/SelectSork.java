package com.ma.algorithm;

public class SelectSork  extends SortHelper{

	public static void main(String[] args) {
		Comparable[] s = {3,5,6,7,8,4,2,12};
		selectSort(s);
		show(s);
		}

	@Override
	public void sort(Comparable[] a) {
		for(int i = 0 ; i < a.length ; i++){
			int min = i ;
			for(int j = i ; j< a.length ; j++){
				min = less(a[i], a[j]) ? min : j;
			}
			exch(a, min, i);
		}
	}
	
/*	public static void select_sort(int[] a){
		int n = a.length;
		for(int i=0;i<n;i++){
			int min =i;
			for(int j= i ; j < n ;j++){
				if(a[i] > a[j]){
					min = j;
				}
			}
			int x = a[i];
			a[i] = a[min];
			a[min] = x;
		}
	}*/

}
