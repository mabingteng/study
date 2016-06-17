package com.mbt.filter1;

import java.util.ArrayList;
import java.util.List;


public class FilterChain implements Filter {
   private 	List<Filter> filters = new ArrayList<Filter>();
	public List<Filter> getFilters() {
			return filters;
	}
	public void setFilters(List<Filter> filters) {
		this.filters = filters;
	}
	public FilterChain add(Filter f){
		 filters.add(f);
		 return this;
		 }
	public FilterChain remove(Filter f){
		 filters.remove(f);
		 return this;
	}
	@Override
	public String dofilter(String str) {
		// TODO Auto-generated method stub
		for(Filter f : filters){
			str = f.dofilter(str);
		}		
		return str;
	}

}

