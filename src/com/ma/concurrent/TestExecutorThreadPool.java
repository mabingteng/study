package com.ma.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestExecutorThreadPool {

	
	public static void main(String[] args) {
		//ExecutorService executorService = Executors.newCachedThreadPool();
		ExecutorService executorService = Executors.newFixedThreadPool(5);
		//ExecutorService executorService = Executors.newSingleThreadExecutor();
		for(int i=0; i<5 ; i++ ){
			executorService.execute(new TestRunnable());
			System.out.println("-------------a"+i+"-------------");
		}
		executorService.shutdown();
	}
	
	  static class TestRunnable implements Runnable{
		
		@Override
		public void run(){
			System.out.println(Thread.currentThread().getName()+" 线程被执行了");
		}
	}

}
