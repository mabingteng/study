package com.ma.test.concurrent;

import com.ma.concurrent.BoundedQueue;

public class TestBoundedQueue {
	static class MThread extends Thread{
		public BoundedQueue<String> bq = null;
		public MThread(BoundedQueue<String> bq){
			this.bq =bq;
		}
		@Override
		public void run(){
			for (int i = 0; i < 10; i++) {
				bq.add("str"+i);
				System.out.println("bq has added "+i +" elementd");
				System.out.println(bq);
				try {
					sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	static class RemThread extends Thread{
		public BoundedQueue<String> bq = null;
		public RemThread(BoundedQueue<String> bq){
			this.bq = bq;
		}
		@Override
		public void run(){
			for (int i = 0; i < 10; i++) {
				bq.remove();
				System.out.println("bq "+i+"th element has removed!" );
				System.out.println(bq);
				try {
					sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	@SuppressWarnings("static-access")
	public static void main(String[] args) throws InterruptedException {
		BoundedQueue<String> bq = new BoundedQueue<String>(5);
		new MThread(bq).start();
		Thread.currentThread().sleep(11000);
		new RemThread(bq).start();
	}

}
