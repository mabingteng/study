package com.ma.concurrent;

public interface ThreadPool<Job extends Runnable> {
	//ִ��Job��Job��ʵ��Runnable�ӿ�
	void execute(Job job);
	//�ر��̳߳�
	void shutdown();
	//���ӹ������߳�
	void addWorks(int num);
	//���ٹ������߳�
	void removeWorker(int num);
	//�õ�����ִ�еĹ���������
	int getJobSize();
}
