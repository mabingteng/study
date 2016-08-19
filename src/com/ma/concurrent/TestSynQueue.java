package com.ma.concurrent;

import java.util.concurrent.locks.ReentrantLock;

public class TestSynQueue {

	public static void main(String[] args) {
		Thread[] ts = new Thread[100];
		Work work  = new Work();
		
		for (int i = 0; i < 100; i++) {
			ts[i] = new Thread(new Task(work,(1)*1000));
		}
		for (int i = 0; i < ts.length; i++) {
			try {
				Thread.sleep(1);
			} catch (Exception e) {
				// TODO: handle exception
			}
			ts[i].start();
		}
		System.out.println("all thread start!");
		
	}
	static  class Task implements Runnable{
		private Work work;
		private long mi;
		public Task(Work work,long mi){
			this.work = work;
			this.mi=mi;
		}
		@Override
		public void run() {
			work.dosth(mi);			
		}
		
	}
	static class Work{
		ReentrantLock lock = new ReentrantLock();
		public void dosth(long mi){
			lock.lock();
			try {
				Thread.sleep(mi);
				System.out.println(Thread.currentThread().getName());
			} catch (Exception e) {
			}finally{
				lock.unlock();
			}
		}
	}

}
