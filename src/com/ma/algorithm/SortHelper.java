package com.ma.algorithm;

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
	/**
	 * 较常用的插入排序
	 * @param a
	 */
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
	/**
	 * 希尔排序:使数组中任意间隔为h的元素是有序的，如果h很大我们可以将元素移到很远的地方，为实现更小的h有序创造方便
	 * 希尔排序更高效（相比选择排序/插入排序）的原因是它权衡了数组的规模和有序性。
	 * @param a
	 */
	public static void shell(Comparable[] a){
		int N =a.length;
		int h =1;
		while(h<N/3)
			h=3*h+1;
		while(h>=1){
			for(int i = h;i < N ; i++){
				for(int j=i;j>=h && less(a[j],a[j-h]);j-=h){
					exch(a,j,j-h);
				}
			}
			h = h/3;
		}
	}
	
	/**
	 * 自上而下的归并排序。所需时间和NlgN成正比，适合数据规模庞大的情况
	 * 主要缺点：辅助数组所需的额外空间和N的大小成正比	 
	 */
	public static void merge(Comparable[] a){
		merge(a, 0, a.length-1);
	}
	private static void merge(Comparable[]a,int lo ,int hi){
	    	if(lo>=hi)
	    		return ;
	    	int mid = lo+(hi-lo)/2;
	    	merge(a,lo,mid);
	    	merge(a,mid+1,hi);
	    	mergeHelper(a, lo, mid, hi);
	}
	public static void mergeBU(Comparable[]a){
		int N = a.length;
		for(int sz=1; sz < N ;sz=sz+sz){
			for(int lo = 0;lo < N-sz ; lo += sz+sz){
				mergeHelper(a, lo, lo+sz-1, Math.min(lo+sz+sz-1, N-1));
				show(a);
			}
		}
	}
	public static void mergeHelper(Comparable[]a,int lo,int mid,int hi){
		int sz1 = lo;
		int sz2 = mid+1;
		Comparable[] b = new Comparable[a.length];
		for(int i=lo;i<=hi;i++){
			b[i] = a[i];
		}
		for(int s = lo; s<=hi;s++){
			if(sz1>mid)
				a[s] = b[sz2++];
			else if(sz2>hi)
				a[s] = b[sz1++];
			else if(less(b[sz1],b[sz2]))
				a[s] = b[sz1++];
			else a[s] = b[sz2++];
			//show(a);

		}    
	}
}
