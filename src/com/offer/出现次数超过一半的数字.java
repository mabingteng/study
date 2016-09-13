package com.offer;

import java.util.*;
public class 出现次数超过一半的数字 {
	public static void main(String[] args) {
		int array[] = new int[30000000];
		for (int i = 0; i < array.length; i++) {
			if(i%2==0){
				array[i] = 13;
			}else{
				array[i] = i;
			}
			
		}
		System.out.println(MoreThanHalfNum_Solution1(array));
		System.out.println(MoreThanHalfNum_Solution2(array));

	//	System.out.println(MoreThanHalfNum_Solution(array));
	}
	//1000，0000 
    public static int MoreThanHalfNum_Solution(int [] array) {
    	long start = System.currentTimeMillis();
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int i=0;i<array.length;i++){
            if(map.containsKey(array[i])){
               int n = map.get(array[i]);
            	map.put(array[i],n+1);
            }else{
                map.put(array[i],1);
            }
            
        }
        int x = 0;
        for(Map.Entry<Integer,Integer> e : map.entrySet()){
            if(e.getValue()>array.length/2){
                 x = (Integer)e.getKey();
            	break;
            }
        }
        long u = System.currentTimeMillis()-start;
        System.out.println("MoreThanHalfNum_Solution "+u+" ms");
        return x;
        
    }
    public static int MoreThanHalfNum_Solution1(int [] array) {
    	long start = System.currentTimeMillis();
    	int rst = 0;
    	Arrays.sort(array);
    	int tmp = array[0],count = 0;
    	for (int i = 0; i < array.length; i++) {
    		if(tmp==array[i]){
				count++;
			}else{
				if(count>array.length/2){
					rst = tmp;
					//System.out.println(rst);
					break;
				}else{
					count = 1;
					tmp = array[i];
				}
					
			}
		}
    	long u = System.currentTimeMillis() -start;
    	System.out.println("MoreThanHalfNum_Solution1 "+u+" ms");
    	return rst;
    }
    public static int MoreThanHalfNum_Solution2(int [] array) {
    	long start = System.currentTimeMillis();
    	int rst = 0;
    	
    	int tmp = 0,count = 0;
    	for (int i = 0; i < array.length; i++) {
    		if(tmp==array[i]){
    			count++;
    		}else{
    			count--;
    		}
    		if(count<=0){
    			tmp =array[i];
    			count = 1;
    		}
		}
    	long u = System.currentTimeMillis() -start;
    	System.out.println("MoreThanHalfNum_Solution2 "+u+" ms");
    	return tmp;
    }    
    
}