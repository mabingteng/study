package com.ma.collections;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class MapLoop {

	public static void main(String[] args) {
		HashMap<Integer,String> map = new HashMap<Integer,String>();
		for(int i =0; i < 5; i++){
			map.put(i, i+" ");
		}
		System.out.println("method1: ");
		for(Map.Entry<Integer, String> entry : map.entrySet()){
			System.out.println("key : "+entry.getKey()+" , value :"+entry.getValue());
		}
		System.out.println("method2 :");
		for(Integer i : map.keySet()){
				System.out.println("key :"+i+" , value :"+map.get(i));
		}
		System.out.println("method3 :");
		for(Iterator<Map.Entry<Integer,String>> it = map.entrySet().iterator();it.hasNext();){
			Map.Entry<Integer, String> entry = it.next();
			System.out.println("key :"+entry.getKey()+" , value :" +entry.getValue());
		}
		System.out.println("a test:");
		for(Iterator<Integer> it = map.keySet().iterator();it.hasNext();){
			Integer i = it.next();
			System.out.println("key :"+i +" , value :"+map.get(i));
		}
	}

}
