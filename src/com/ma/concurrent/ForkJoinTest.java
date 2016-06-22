/**
 * 
 */
package com.ma.concurrent;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.TimeUnit;

/**
 * @author mbt
 *	测试fork join框架的使用，快速排序
 */
@SuppressWarnings("serial")
public class ForkJoinTest extends RecursiveAction {
	final int array[];
	final int threshold = 10;
	final int hi;
	final int lo;

	public ForkJoinTest(int[] array) {
		this.array =array;
		this.lo =0 ;
		this.hi = array.length-1;
	}
	public ForkJoinTest(int[] array ,int lo , int hi){
		this.array =array;
		this.lo = lo;
		this.hi = hi;
	}
	@Override
	protected void compute() {
		if(hi-lo<threshold){
			arraySort(array, lo, hi);
		}else {
			int pivot = partition(array, lo, hi);
			ForkJoinTest f1 = new ForkJoinTest(array, lo, pivot-1);
			ForkJoinTest f2 = new ForkJoinTest(array, pivot+1, hi);
			f1.fork();
			f2.fork();
			f1.join();
			f2.join();
			
		}
		
	}
	private int partition(int[] a , int lo, int hi){
		int key = a[hi];
		int i = lo -1;
		for(int j = lo; j<=hi; j++){
			if(a[j]<=key){
				i++;
				swap(a,i,j);
			} 
		}
		swap(a,i+1,hi);
		return i+1;
	}
	private void swap(int[] a , int m, int n ){
		if(m!=n){
			int k = a[m];
			a[m] = a[n];
			a[n]=k;
		}
	}
	private void arraySort(int[] array, int lo, int hi ){
		Arrays.sort(array, lo, hi);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void main(String[] args) throws InterruptedException {
		int array[] = new int[1000];
		Random rand = new Random();
		for (int i = 0; i<array.length; i++) {
			array[i] = array.length-i;;
		}
		System.out.println(Arrays.toString(array));
		ForkJoinTask task = new ForkJoinTest(array);
		ForkJoinPool fjPool = new ForkJoinPool();
		fjPool.submit(task);
		fjPool.shutdown();
		fjPool.awaitTermination(60, TimeUnit.SECONDS);
		System.out.println(Arrays.toString(array));
	}
}
