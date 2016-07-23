/**
 * 
 */
package com.ma.concurrent;

import java.lang.Thread.UncaughtExceptionHandler;

/**
 * @author mbt
 *  测试多线程中运行时异常如何处理
 */
public class TestExceptions {
	public static void main(String[] args) {
		Thread.currentThread().setName("main_thread");
		Thread t = new Thread(new Task());
		t.setUncaughtExceptionHandler(new ExceptionHandler());
		t.setName("thread_test");
		System.out.println("start thread");
		t.start();
		System.out.println("end thread");
		try {
			Thread.sleep(5000);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
class Task implements Runnable{
	@Override
	public void run(){
		while(true){
			System.out.println("inner thread +");
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
			}
			throw new RuntimeException("12345cuowu");
		}
	}
}
/**
 * 	异常捕获器
 */
class ExceptionHandler implements UncaughtExceptionHandler{

	@Override
	public void uncaughtException(Thread t, Throwable e) {
			System.out.println(Thread.currentThread().getName());
			System.out.println(t.getName());
			System.out.println(e.getMessage()+ " 线程错误！");
			int i = 10;
			while(i>=0){
				try {
					Thread.sleep(1000);
					System.out.println("sleep ..."+ i);
					i--;
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
	}
	
	
}