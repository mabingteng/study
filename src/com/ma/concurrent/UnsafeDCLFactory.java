package com.ma.concurrent;

public class UnsafeDCLFactory {
	  private Singleton instance;//���������Ӧ���������߳̿���instance�Ƿ񱻳�ʼ��

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