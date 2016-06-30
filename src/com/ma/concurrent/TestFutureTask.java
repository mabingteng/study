package com.ma.concurrent;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

public class TestFutureTask {
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ExecutorService cached = Executors.newCachedThreadPool();
		FutureTask<String> futureTask = new FutureTask<String>(new MyCallable(1000));
		FutureTask<String> futureTask2 = new FutureTask<String>(new MyCallable(2000));
		cached.execute(futureTask);
		cached.execute(futureTask2);
		cached.shutdown();
		while(!futureTask.isDone() || !futureTask2.isDone()){
			if(futureTask.isDone()){
				System.out.println(futureTask.get());
			}
			if(futureTask2.isDone()){
				System.out.println(futureTask2.get());
			}
		}
	}

}
class MyCallable implements Callable<String>{

	private int waitTime;
	public MyCallable(int time){
		this.waitTime =time;
	}
	@Override
	public String call( ) throws Exception {
		try {
			System.out.println(Thread.currentThread().getName()+" start!");
			Thread.sleep(waitTime);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Thread.currentThread().getName();
	}
	
}