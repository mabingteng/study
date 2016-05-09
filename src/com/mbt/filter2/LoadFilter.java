package com.mbt.filter2;
public class LoadFilter implements Filter {

	@Override
	public void dofilter(Request req , Response res,FilterChain fc) {
		// TODO Auto-generated method stub
		req.setStr(req.getStr()+"===LoadFilter Request===");
		fc.dofilter(req, res, fc);
		res.setStr(res.getStr()+"===LoadFilter Response===");
	}

}
