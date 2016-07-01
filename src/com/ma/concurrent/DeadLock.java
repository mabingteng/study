package com.ma.concurrent;

public class DeadLock {

	class MThread implements Runnable{
		private Object a = null;
		private Object b = null;
		public MThread(Object a,Object b){
			this.a =a;
			this.b = b;
		} 
		@Override
		public void run() {
			synchronized (a) {
				try {
					Thread.sleep(5000);
					synchronized(b){
						Thread.sleep(1000);
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
	public static void main(String[] args) {
		DeadLock dl = new DeadLock();
		Object A = new Object();
		Object B = new Object();
		MThread mt1 = dl.new MThread(A,B );
		MThread mt2 = dl.new MThread(B,A);
		new Thread(mt1).start();
		new Thread(mt2).start();
	}

}
