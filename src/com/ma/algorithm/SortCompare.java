package com.ma.algorithm;

public class SortCompare {
	
	
	@SuppressWarnings("rawtypes")
	public static double time(String alg,Comparable[] a){
		StopWatch timer = new StopWatch();
		if(alg.equals("select"))
			SortHelper.selectSort(a);
		if(alg.equals("insert"))
			SortHelper.insertion(a);
		if(alg.equals("insert2"))
			SortHelper.insertion2(a);
		if(alg.equals("shell")){
			SortHelper.shell(a);
		}
		return timer.elapsedTime();
	}
	public static double timeRandomInput(String alg , int N , int T){
		double total = 0.0;
		Double [] a = new Double[N];
		for(int t =0 ; t< T;t ++){
			for(int n=0;n<N;n++)
				a[n] = StdRandom.uniform(100);
			total += time(alg, a);
		}
		return total;
	}
	public static void main(String[] args) {
		//插入排序比选择排序快些，他们的比是一个较小的常数
		String alg1= "shell";
		String alg2 = "insert";
		int N = 100000;
		int T =100;
		double t1 = timeRandomInput(alg1, N, T);
		double t2 = timeRandomInput(alg2, N, T);
		System.out.print("For "+N+" random Double \n  "+alg1+" is");
		System.out.println(" "+ t2/t1 +" times faster than "+alg2);
	}

}

class StdRandom{
	public static double uniform(double a, double b){
		return a+random()*(b-a);
	}
	public static Double uniform(int N){
		return random()*(N);
	}
	
	public static double random(){
		return Math.random();
	}
}

class StopWatch {
	private final long start;
	public StopWatch(){
		start = System.currentTimeMillis();
	}
	public double elapsedTime(){
		long now = System.currentTimeMillis();
		return (now -start)/1000.0;
	}
}
