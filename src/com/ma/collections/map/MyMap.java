/**
 * 
 */
package com.ma.collections.map;

/**
 * @author waller
 *	一个简单的Map 示例
 */
public class MyMap<K,V> {

	private Object [] []  pairs;
	private int index;
	private int size;
	public MyMap(int length){
		pairs =  new Object[length][2];
		index =	-1;
		size = length;
	}
	public void put(K key,V value){
		if(index >= size-1){
			throw new ArrayIndexOutOfBoundsException("too many emements!");
		}
		index++;
		pairs[index][0] = key;
		pairs[index][1] = value;
	}
	@SuppressWarnings("unchecked")
	public V get (K key){
		int i = 0;
		while(i<=index){
			if(pairs[i][0].equals(key)){
				return (V) pairs[i][1];
			}
			i++;
		}
		return null;
	}
	public void remove(K key){
		int i = 0;
		while(i<=index){
			if(pairs[i][0].equals(key)){
				Object[][] dest = new Object[size][2];
				System.arraycopy(pairs, 0, dest, 0, i);
				System.arraycopy(pairs, i+1, dest, i, index-i);
				pairs = dest;
				index --;
				break;
			}
			i++;
		}
	}
	public int size(){
		return index;
	}
	public String toString(){
		StringBuffer sb = new StringBuffer();
		sb.append("[");
		int i =	0;
		while(i<=index){
			sb.append(pairs[i][0]);
			sb.append(":");
			sb.append(pairs[i][1]);
			if(index!=i)
				sb.append(", ");
			i++;
		}
		sb.append("]");
		return sb.toString();
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MyMap<String, String> mm = new MyMap<String , String>(10);
		for(int i = 0 ; i <10 ; i ++){
			mm.put("key"+i, "value"+i);
		}
		mm.put("kkk","vvv");
		mm.remove("key2");
		mm.put("key11", "value11");
		mm.remove("key3");
		System.out.println(mm);
		System.out.println(mm.get("key1"));
	}

}
