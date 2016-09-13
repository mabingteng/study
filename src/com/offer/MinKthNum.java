package com.offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class MinKthNum {

	public static void main(String[] args) {
		int input[] = new int[10000000];	
		for (int i = 0; i < 10000000; i++) {
			input[i] = new  Random().nextInt(100000000);
		}
		GetLeastNumbers_Solution(input, 4);
	}
	 public static  ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
		 long start = System.currentTimeMillis();
		 int mid = 0;
		 int []A = input;
		 int left = 0;
		 int right = A.length-1;
		 ArrayList<Integer> list = new ArrayList<Integer>();
		 if(A.length<k)
			 return list;
		 mid = partition(A, left, right);
		 while(k-1!=mid){
			 if(k-1<mid){
				 right = mid-1;
				 mid = partition(A, left, right);
			 }else if(k-1>mid){
				 left = mid+1;
				 mid = partition(A, left, right);
			 }
		 }
		 for(int i=0; i<k; i++){
			 list.add(A[i]);
		 }
		 System.out.println(list);
		 System.out.println(System.currentTimeMillis()-start+" ms cost!");
		 return list;
	 }
	 public static  int partition(int[] A, int left, int right){
		 int key = A[left];
		 while(left<right){
			 while(left<right&&A[right]>=key)
				 right--;
			 A[left] = A[right];
			 while(left<right&&A[left]<=key)
				 left++;
			A[right] = A[left];
		 }
		 A[left] = key;
		 return left;
	 }

}
