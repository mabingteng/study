package com.ma.Algorithm;

public class Shell extends SortHelper {

	public static void main(String[] args) {
		Comparable[] a= {1,9,8,4,2,3,6,7,1};
		show(a);
		new Shell().sort(a);
		show(a);
		Shell s = new Shell();
		//Ano asa = new Ano();
		//asa.sort(a);
	
	}
	

	@Override
	public  void sort(Comparable[] a) {
		
		int N =a.length;
		int h =1;
		while(h<N/3)
			h=3*h+1;
		while(h>=1){
			for(int i = h;i < N ; i++){
				for(int j=i;j>=h && less(a[j],a[j-h]);j-=h){
					exch(a,j,j-h);
					show(a);
				}
			}
			h = h/3;
		}	
		
	}
	@SuppressWarnings("rawtypes")
	 class Ano extends SortHelper implements Comparable{

		@Override
		public void sort(Comparable[] a) {
			// TODO 自动生成的方法存根
			System.out.println("sort");
		}

		@Override
		public int compareTo(Object o) {
			// TODO 自动生成的方法存根
			System.out.println("compare");
			return 0;
		}
		
	}
}
