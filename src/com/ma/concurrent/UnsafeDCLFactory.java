package com.ma.concurrent;

public class UnsafeDCLFactory {
	  private Singleton instance;//问题在这里，应该让其他线程看到instance是否被初始化

	  public Singleton get() {
	    if (instance == null) {  // check 1
	      synchronized (this) {
	        if (instance == null) { // check 2
	          instance = new Singleton();
	        }
	      }
	    }
	    return instance;
	 }
}

class Singleton{
	
}