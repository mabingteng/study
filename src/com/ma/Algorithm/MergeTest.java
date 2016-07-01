package com.ma.Algorithm;

@SuppressWarnings("rawtypes")
public class MergeTest extends SortHelper{

	private  static Comparable[] b = null;
	
	public static void main(String[] args) {
		Comparable[] a = {1,2,3,4,5,3,2,1,12,3,3,243,34,2,12,};
		new MergeTest().sort(a);
		show(a);
	}

	@Override
	public void sort(Comparable[] a) {
		 b = new Comparable[a.length];
		 sort(a,0,a.length-1);
	}
	public static void sort(Comparable[]a , int lo ,int hi){
		if(lo>=hi)
			return;
		int mid = lo + (hi-lo)/2;
		
		sort(a,lo,mid);
		sort(a,mid+1,hi);
		merge(a, lo, mid, hi);
	}
	public static void merge(Comparable[] a ,int lo , int mid , int hi){
	
		int i = lo;
		int j = mid+1;
		for(int k = lo ;k <= hi; k++){
			b[k] = a[k];
		}
		for( int m = lo; m <= hi ; m++ ){
			if(i>mid)
				 a[m] = b[j++];
			else if (j > hi)
				 a[m] = b[i++];
			else if (less(b[i],b[j]))
				 a[m] = b[i++];
			else 
				 a[m] = b[j++];
			}
		}

	public static void sortBT(){
		
	}

}
