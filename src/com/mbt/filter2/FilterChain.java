package com.mbt.filter2;

import java.util.ArrayList;
import java.util.List;


public class FilterChain implements Filter {
   private 	List<Filter> filters = new ArrayList<Filter>();
   private int size = -1;
	public List<Filter> getFilters() {
			return filters;
	}
	public void setFilters(List<Filter> filters) {
		this.filters = filters;
	}
	public boolean add(Filter f){
		return filters.add(f);
	}
	public boolean remove(Filter f){
		return filters.remove(f);
	}
	@Override
	public void dofilter(Request req, Response res,FilterChain fc) {
		size++;
		if(size==filters.size())
			return ;
		
		fc.getFilters().get(size).dofilter(req, res, fc);
		
	}
	

}
