package com.mbt.filter1;
public class SensitiveFilter implements Filter {

	@Override
	public String dofilter(String str) {
		// TODO Auto-generated method stub
		str += "===SensitiveFilter===";
		return str;
	}

}
