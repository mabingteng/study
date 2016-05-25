package com.ma.Algorithm;

@SuppressWarnings("rawtypes")
public abstract class SortHelper {
	public abstract  void sort(Comparable[] a);
	@SuppressWarnings("unchecked")
	
	public static boolean less(Comparable a , Comparable b){
		return a.compareTo(b) < 0;
	}
	
	public static void exch(Comparable[] a , int x, int y){
		Comparable t = a[x];
		a[x] = a[y];
		a[y] = t;
	}
	public static void show(Comparable[] a ){
		int n = a.length;
		for(int i =0 ; i <n ; i++){
			System.out.print( a[i] +" ");
		}
		System.out.println();
	}
	public static boolean isSorted(Comparable [] s){
		for(int i = 1 ; i < s.length ; i++){
			if(less(s[i],s[i-1]))
				return false;
		}
		return true;
	
	}
	
	/**
	 * 对于长度为N的数组，选择排序需要N*N/2次比较和N次交换
	 * @param a
	 */
	public static void selectSort(Comparable[] a) {
		//System.out.println("============start select sort ==================");
		//System.out.println("对于长度为N的数组，选择排序需要N*N/2次比较和N次交换");
		for(int i = 0 ; i < a.length ; i++){
			int min = i ;
			for(int j = i ; j< a.length ; j++){
				min = less(a[i], a[j]) ? min : j;
			}
			exch(a, min, i);
			}
		//System.out.println("=============end select sort =======================");
	}
	/**
	 * 长度为N且不重复的数组，最多比较N*N/2次，交换 N*N/2次
	 * @param a
	 */
	public static void insertion(Comparable[] a){
		int N = a.length;
		for(int i = 1 ; i < N ; i ++){
			for(int j = i ; j >0 &&less(a[j],a[j-1]);j--){
				exch(a,j,j-1);
			}
		}
	}
	public static void insertion2(Comparable[] a){
		int N =a.length;
		for(int i = 1; i < N ; i++){
			Comparable t = a[i];
			int j = i;
			for( ; j > 0 && less(t ,a[j-1]); j --)
				a[j] = a[j-1];
			a[j] = t;
		}
	}
}
