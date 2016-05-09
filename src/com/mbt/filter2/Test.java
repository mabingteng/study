package com.mbt.filter2;

public class Test {
	public static void main(String args[]){
		Request req = new Request();
		Response res = new Response();
		req.setStr("++++");
		res.setStr("++++");
		FilterChain fc = new FilterChain();
		fc.add(new HTMLFilter());
		fc.add(new SensitiveFilter());
		fc.add(new LoadFilter());
		
		fc.dofilter(req,res,fc);
		
		System.out.println(req.getStr());
		System.out.println(res.getStr());
	}
}
