package com.ma.Algorithm;

import java.lang.reflect.Array;
import java.util.Arrays;

@SuppressWarnings("unchecked")
public class PriorityQueue<key extends Comparable<key>> {

	private key[] pq;
	private int size;
	private  int csize = 0;
	public PriorityQueue(int size){
		pq = (key[]) new Comparable[size+1];
		this.size=size+1;
	}
	public PriorityQueue(Class<key> clazz,int size){
		pq = (key[]) Array.newInstance(clazz, size+1);
		this.size = size + 1;
	}
	
	public void insert(key ins) throws Exception{
		if(csize+1==size)
			throw  new IndexOutOfBoundsException("out of index") ;
		csize++;
		pq[csize] = ins;
		swim(csize);
	}
	public key delMax(){
		if(csize==0)
			return null;
		key rst = pq[1];
		if (csize>1){
				pq[1] = pq[csize];
				sink(1);
		}
		csize --;
		return rst;
	}
	private void swim(int k){
		while(k>1&&less(k/2,k)){
			swap(k/2,k);
			k = k/2;
		}
	}
	private void sink(int k){
		while(k*2<=csize){
			int j = 2 * k;
			if(j<csize && less(j,j+1)) j++;
			if(less(j,k)) break;
			swap(k,j);
			k = j;
		}
	}
	private boolean less(int a, int b){
		return pq[a].compareTo(pq[b])<0;
	}
	private void swap(int a, int b){
		key t = pq[a];
		pq[a] = pq[b];
		pq[b] = t;
	}
	public String toString(){
		return Arrays.toString(pq);
	}
	
	public static void main(String[] args) throws Exception {
		 PriorityQueue<Integer> pq = new PriorityQueue<>(10);
		 System.out.println(pq.csize);
		 for(int i =0 ; i< 10 ; i++){
			 pq.insert(i);
		 }
		 System.out.println(pq);
		 for(int i=0; i<10; i++){
			 System.out.println(pq.delMax());
		 }
	}

}
