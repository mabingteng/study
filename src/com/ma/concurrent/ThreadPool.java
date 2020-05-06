package com.ma.concurrent;

public interface ThreadPool<Job extends Runnable> {
	//执行Job，Job需实现Runnable接口
	void execute(Job job);
	//关闭线程池
	void shutdown();
	//增加工作者线程
	void addWorks(int num);
	//减少工作者线程
	void removeWorker(int num);
	//得到正在执行的工作者数量
	int getJobSize();
}
