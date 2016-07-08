/**
 * 
 */
package com.ma.collections.map;

import java.util.AbstractMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;

/**
 * @author waller
 *	 一个使用Hash表的简单Map，测试put/get/entrySet方法。理解HashMap结构
 */
public class SimpleMap<K,V>  extends AbstractMap<K, V> {

	private final static int SIZE = 997;
	@SuppressWarnings("unchecked")
	private LinkedList<MapEntry<K,V>> buckets []  = new LinkedList [SIZE];  
	private String str = "123";
	public V put(K key,V value){
		int hash = key==null? 0 : key.hashCode();   			//获取hash code
		int index = hash % SIZE;								//获取index
		if(buckets[index]==null){								//数组中该index为null，则new LinkedList， 并保存元素
			buckets[index] = new LinkedList<MapEntry<K,V>>();	
			buckets[index].add(new MapEntry<K,V>(key,value));
			return null;
		}
		LinkedList<MapEntry<K,V>> bucket = buckets[index];		//数组中该地址不为空，取出并遍历LinkedList，更新指定key的value，或添加
		Iterator<MapEntry<K,V>> it = bucket.iterator();
		while(it.hasNext()){
			MapEntry<K,V> me = it.next();
			if(hash==me.getKey().hashCode()&&(key==me.getKey()||me.getKey().equals(key))){		//list中是否包含了键值对
				V old = me.getValue();
				me.setValue(value);
				return old;
			}
		}
		bucket.add(new MapEntry<K,V>(key,value));
		return null;
	}
	public V get(Object o){
		LinkedList<MapEntry<K, V>> bucket = null;
		if(o == null){
			bucket = buckets[0];
			if(bucket==null)
				return null;
			Iterator<MapEntry<K, V>> it = bucket.iterator();
			while(it.hasNext()){
				MapEntry<K, V> me = it.next();
				K key = me.getKey();
				if(key==null)
					return me.getValue();
			}
		}
		int hash = o.hashCode();
		bucket = buckets[hash%SIZE];
		if(bucket == null)
			return null;
		Iterator<MapEntry<K, V>> it = bucket.iterator();
		while(it.hasNext()){
			MapEntry<K, V> me = it.next();
			K key = me.getKey();
			if((key.hashCode()==hash&&(key.equals(o))))
				return me.getValue();
		}
		return null;
	}

	@Override
	public Set<Entry<K, V>> entrySet() {
		Set<Entry<K,V>> set = new HashSet<Entry<K,V>>();
		for(LinkedList<MapEntry<K, V>> bucket : buckets){
			if (bucket==null)
				continue;
			for(MapEntry<K, V> mpair :bucket){
				set.add(mpair);
			}
		}
		return set;
	}

	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SimpleMap<Integer, String> map = new SimpleMap<Integer,String>();
		for(int i = 0 ; i < 1000; i++)
			map.put(i, "val"+i);
		map.put(1, "ssss");
		/*for(int i = 0 ; i < 1000 ; i ++){
			System.out.println("[ key = "+i+" , value = "+map.get(i)+" ]");
		}*/
		System.out.println();
	}
}
