package com.mbt.mylist;
public class MainTest {
	DateSorter ds = new DateSorter();
	public void mSort(int[] a){
		int x= 1;
		for(int i=0;i<a.length-1;i++){
					for(int j = 0 ;j<a.length-x;j++){
						if(a[j]>a[j+1]){
							int c  = a[j];
							a[j] = a[j+1];
							a[j+1] =c;
						}
					}
			x++;
		}
	}
	public  static void main(String args[]){
		int[] a = {5,78,12,34,56,6,7,8,9,9,6,4334,5,23,1};
		//Arrays.sort(a);
		MainTest mt = new MainTest();
		mt.mSort(a);
		for(int i : a)
			System.out.println(i);
	}
}
