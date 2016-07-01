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
 *	使用同步器实现锁的示例，同样的示例还有TwinsLock
 */
public class MyLock implements Lock {

	private final Sync sync = new Sync();
	
	@Override
	public void lock() {
		sync.acquire(1);
	}

	@Override
	public void lockInterruptibly() throws InterruptedException {
		sync.acquireInterruptibly(1);
	}

	@Override
	public boolean tryLock() {
		return sync.tryAcquire(1);
	}


	@Override
	public boolean tryLock(long time, TimeUnit unit)
			throws InterruptedException {
		return 
		sync.tryAcquireNanos(1, unit.toNanos(time));
	}

	
	@Override
	public void unlock() {
		sync.release(1);
	}

	
	@Override
	public Condition newCondition() {
		return null;
	}

	public boolean isLocked(){
		return sync.isHeldExclusively();
	}
	public boolean hasQueuedThreads(){
		return sync.hasQueuedThreads();
	}
	
	
	@SuppressWarnings("unused")
	private static class Sync extends AbstractQueuedSynchronizer{
		public boolean tryAcquire(int arg){
			if(compareAndSetState(0, 1)){
				setExclusiveOwnerThread(Thread.currentThread());
				return true;
			}
			return false;
		}
		public boolean tryRelease(int releases){
			if(getState()==0)
				throw new IllegalMonitorStateException();
			setExclusiveOwnerThread(null);
			setState(0);
			return true;
		}
		protected boolean isHeldExclusively() {
			return getState()==1;
		}
	}
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {

	}

}
