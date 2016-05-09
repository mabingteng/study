package com.mbt.mylist;

import java.util.List;

public class Fxtest {
	void printList(List<?> l){
		for(Object o : l )
			System.out.println(o);
	}
}
