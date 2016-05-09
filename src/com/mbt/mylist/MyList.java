package com.mbt.mylist;
@SuppressWarnings("unchecked")
public  class MyList<V> {
	private V[] array;
	private int size=0;
	public MyList(int capacity){
		//处理方法很关键
		//array = new V[capacity];
		array = (V[])new Object[capacity];
	}
	
	public  void add(V value){
		if(size==array.length)
			throw new IndexOutOfBoundsException(Integer.toString(size));
		else  if(value == null)
			throw new NullPointerException();
		array[size++] = value;
	}
	/**
	 * 遍历的处理很好
	 * @param value
	 */
	public  void remove (V value){
		int i,count = 0;
		for(i=0;i<size;i++){
			if(array[i]==value){
				count++;
			}else if(count!=0){
				array[i-count]=array[i];
				array[i]=null;
			}
		}
		size -= count;
	}
	public  V get(int index){
		if(index > size)
			throw new IndexOutOfBoundsException(index+"");
		return array[index] ;
	}
	public  int size(){
		return size;
	}

	public static void main(String args[]){
		String[] arr = new String[5];
		for(int i =0;i<5;i++){
			arr[i] = i+1+"";
			if(i==2)
				arr[i]=1+"";
		}
		
		int count = 0;
		for(int i=0;i<5;i++){
			if(arr[i]=="1"){
				count++;
			}else if(count>0){
				arr[i-count]=arr[i];
				arr[i]=null;
			}
		}
		MyList<Integer> lh = new MyList<Integer>(10);
		lh.add(1);
		lh.add(2);
		lh.add(3);
		lh.remove(2);
		for(int i = 0 ; i<lh.size();i++){
			System.out.println("index:"+i+"  value:"+lh.get(i));
		}
	}
}
