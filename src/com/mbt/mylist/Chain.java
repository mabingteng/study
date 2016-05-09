package com.mbt.mylist;

public class Chain{
	private Object o;
	private Chain c =null;
	public Object getO() {
		return o;
	}
	public void setO(Object o) {
		this.o = o;
	}
	public Chain getC() {
		return c;
	}
	public void setC(Chain c) {
		this.c = c;
	}
	public Chain next(){
		return c;
	}
}