package tst.concurrent;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import com.ma.collections.list.LinkedList;

public class DefaultThreadPool<Job extends Runnable> implements ThreadPool<Job> {

	private final static int  MAX_THREAD_NUM=10;
	private static final int DEFAULT_THREAD_NUM = 5;
	private final  static int MIN_THREAD_NUM = 1;
	
	private AtomicInteger threadNum = new AtomicInteger();
	private LinkedList<Job> jobs = new LinkedList<>();
	
	private final List<Worker> workers =  Collections.synchronizedList(new ArrayList<Worker>());
	
	public DefaultThreadPool(){
		initWorkers(DEFAULT_THREAD_NUM);
	}
	public DefaultThreadPool(int num){
		if(num<MIN_THREAD_NUM)
			num = MIN_THREAD_NUM;
		if(num>MAX_THREAD_NUM)
			num = MAX_THREAD_NUM;
		initWorkers(num);
	}
	
	@Override
	public void execute(Job job) {
		synchronized (jobs) {			
			jobs.add(job);
			jobs.notify();
			threadNum.set(jobs.size());
		}
	}

	@Override
	public void shutdown() {
		boolean flag = true;
		while(flag){
			synchronized (jobs) {
				System.out.println("jobs.size() "+jobs.size());
				if(jobs.size()==0){
					for (Worker worker : workers) {
						worker.shutdown();
					}
					threadNum.set(0);
					jobs.notifyAll();
					flag = false;
				}
			}
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
	}

	@Override
	public void addWorks(int num) {
		synchronized(workers){
			if(num>MAX_THREAD_NUM)
				num = MAX_THREAD_NUM;
			if(num<0)
				throw new IllegalArgumentException("添加线程数不得小于0");
			initWorkers(num);
			threadNum.set(workers.size());
		}
	}

	@Override
	public void removeWorker(int num) {
		synchronized(workers){
			if (num>workers.size()-MIN_THREAD_NUM)
				num = workers.size() - MIN_THREAD_NUM;
			for(int i=0; i<num; i++){
				Worker w = workers.get(i);
				w.shutdown();
				workers.remove(w);
			}
			threadNum.set(workers.size());
		}
	}

	@Override
	public int getJobSize() {
		return threadNum.intValue();
	}

	private void initWorkers(int num){
		if(num<0){
			throw  new IllegalArgumentException("线程个数不能小于0");
		}
		int i=workers.size();
		for(int j = i; j<num+i; j++){
			Worker worker = new Worker();
			workers.add(worker);
			Thread thread = new Thread(worker,"Thread-woker-"+workers.size());
			thread.start();
		}
	}
	
	 class Worker implements Runnable{
		
		volatile boolean flag = true;
		@Override
		public void run() {
			while(flag){
				Job job =null;
				synchronized (jobs) {
					if(!jobs.isEmpty())
						job =  jobs.removeFirst();
					else{
						try {
							jobs.wait();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}
				if(job!=null){
					try {	
						System.out.println(Thread.currentThread().getName() +" execute task!");
						job.run();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		}
		public void shutdown(){
			this.flag = false;
		}
	}
}

