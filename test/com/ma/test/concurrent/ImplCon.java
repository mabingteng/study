package com.ma.test.concurrent;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ImplCon {
	

	public static void main(String[] args) {
		Thread thread = new Thread();
		ExecutorService executor = Executors.newCachedThreadPool();
		//executor.submit(task)
	}
	
	
}







class Ac implements Callable<String>{

	@Override
	public String call() throws Exception {
		// TODO 自动生成的方法存根
		return null;
	}
	
}

class Ar implements Runnable{

	@Override
	public void run() {
		// TODO 自动生成的方法存根
		
	}
	
}