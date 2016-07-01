/**
 * 
 */
package com.ma.concurrent;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * @author waller
 *	同一时刻，最多有两个线程同时访问，超过两个线程将被阻塞
 */
public class TwinsLock implements Lock {

	private final static Sync sync = new Sync(2);
	@Override
	public void lock() {
		//sync.tryAcquireShared(1);
		sync.acquireShared(1);
	}

	@Override
	public void lockInterruptibly() throws InterruptedException {

	}

	@Override
	public boolean tryLock() {
		return sync.tryAcquireShared(1)>0;
	}

	@Override
	public boolean tryLock(long time, TimeUnit unit)
			throws InterruptedException {
		return false;
	}

	@Override
	public void unlock() {
		//sync.tryReleaseShared(1);
		sync.releaseShared(1);
	}

	
	private static  class Sync extends AbstractQueuedSynchronizer{
		
		public Sync(int arg){
			setState(arg);
		}
		@Override
		protected int tryAcquireShared(int arg){
		//	for(;;){
				int status = getState();
				int newStatus = status - 1;
				if(newStatus>=0 && compareAndSetState(status, newStatus)){
					return 1;
				}
				return -1;
			//}
		}
		@Override
		protected boolean tryReleaseShared(int arg){
			for(;;){
				int status = getState();
				if(compareAndSetState(status, status+1)){
					return true;
				}
			}
			//return false;
		}
	}


	@Override
	public Condition newCondition() {
		return null;
	}
}
