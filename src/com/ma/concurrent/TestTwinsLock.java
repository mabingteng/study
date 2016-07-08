package com.ma.concurrent;

import java.util.concurrent.locks.Lock;

public class TestTwinsLock {
	final  Lock  lock = new TwinsLock();

	class Worker extends Thread{
		@SuppressWarnings("finally")
		@Override
		public void run(){
			while(true){
				lock.lock();
				lock.lock();
				//lock.lock();
				try{
					sleep(1000);
					System.out.println(Thread.currentThread().getName());
					sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}finally{
					lock.unlock();
					lock.unlock();
					//lock.unlock();
					//break;
				}
			}
		}
	}
	@SuppressWarnings("static-access")
	public void test(){
		for(int i=10;i>0;i--){
			Worker w = new Worker();
			w.setDaemon(true);
			w.start();
		}
		for (int i = 0; i < 100; i++) {
			try {
				Thread.currentThread().sleep(1000);
				System.out.println();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		new TestTwinsLock().test();
	}

}
