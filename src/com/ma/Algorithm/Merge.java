/**
 * 
 */
package com.ma.Algorithm;

/**
 * @author waller
 *
 */
public class Merge extends SortHelper {
	@SuppressWarnings("rawtypes")
	private static Comparable[] aux;
	/* £¨·Ç Javadoc£©
	 * @see com.ma.Algorithm.SortHelper#sort(java.lang.Comparable[])
	 */
	@Override
	public void sort(Comparable[] a) {
		aux = new Comparable[a.length];
		sort(a,0,a.length-1);
	}
	public static void sort(Comparable[] a,int lo,int hi){
		if(hi <= lo)
			return;
		int mid = lo+(hi-lo)/2;
		sort(a,lo,mid);
		sort(a,mid+1,hi);
		merge(a,lo,mid,hi);
	}
	public static void merge(Comparable[] a,int lo,int mid,int hi){
		int s = lo;
		int m = mid+1;
		for(int i=lo;i<=hi;i++){
			aux[i] = a[i];
		}
		for(int k=lo;k<=hi;k++){
			if(s>mid)
				a[k] = aux[m++];
			else if(m>hi)
				a[k] = aux[s++];
			else if(less(aux[s],aux[m]))
				a[k] = aux[s++];
			else
				a[k] = aux[m++];
		}
		
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Comparable[] a = {9,8,7,6,5,4,3,2,1,0};
		//new Merge().sort(a);
		SortHelper.mergeBU(a);
		show(a);
	}

}
