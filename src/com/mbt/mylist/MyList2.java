package com.mbt.mylist;

public class MyList2 {
	Object[] objects = new Object[10];
	private int size = 0;
	
	public void add(Object o){
		if(size == objects.length){
			Object[] newObj = new Object[objects.length+10];
			System.arraycopy(objects, 0, newObj, 0, objects.length);
			objects = newObj;
		}
		objects[size++] = 0; 
	}
	public int size(){
		return size;
	}
	public void remove(Object o){
		int count =0;
		for(int i=0;i<objects.length;i++){
			if(objects.equals(o)){
				count++;
			}else if(count!=0){
				objects[i-count] = objects[i];
				objects[i] = null;
			}
		}
		size -=count;
	}
}
