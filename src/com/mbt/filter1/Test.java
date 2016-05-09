package com.mbt.filter1;

public class Test {
	public static void main(String args[]){
		FilterChain fc = new FilterChain();
		fc.add(new HTMLFilter());
		fc.add(new SensitiveFilter());
		fc.add(new LoadFilter());
		String str = " start ";
		str +=fc.dofilter(str);
		str +=" end ";
		System.out.println(str);
	}
}
