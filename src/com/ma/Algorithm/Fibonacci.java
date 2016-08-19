package com.ma.Algorithm;

public class Fibonacci {

	public static void main(String[] args) {
		System.out.println(F1(1));
	}
	 public static int F(int n) {
			if(n==0||n==1)
	            return n;
	        return  F( n -1 )+  F( n -2);
	 }
	 public static int F1(int n){
		 int s=1,f=0;
		 while(--n>0){
			 s += f;
			 f= s-f;
		 }
		 return s;
	 }
}
