package com.ma.algorithm;

public class QuickSort {
	static int array[] = {3,1,4,5,8,7,9,10,10,23,14,15,78,10};
	public  static void findpoint(int [] a ,int left , int right){
		if(left < right){
		int key = a[left];
		int low = left;
		int high = right;
		while(low < high){
			while(low < high && key <= a[high]){
				high --;
			}
			
			a[low] = a[high];
			
			while(low < high && key >= a[low]){
				low ++;
			}
			a[high] = a[low];	
		}
		a[low] = key;
		
		findpoint(a,left,low-1);
		findpoint(a,low+1,right);
	 }
   }
	
	public static void main(String[] args) {
		findpoint(array,0,array.length-1);
		for(int i = 0 ; i < array.length ; i ++){
			System.out.print(" "+ array[i]);
		}
		
	}
}
