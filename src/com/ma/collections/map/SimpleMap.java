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
 *	 һ��ʹ��Hash��ļ�Map������put/get/entrySet���������HashMap�ṹ
 */
public class SimpleMap<K,V>  extends AbstractMap<K, V> {

	private final static int SIZE = 997;
	@SuppressWarnings("unchecked")
	private LinkedList<MapEntry<K,V>> buckets []  = new LinkedList [SIZE];  
	private String str = "123";
	public V put(K key,V value){
		int hash = key==null? 0 : key.hashCode();   			//��ȡhash code
		int index = hash % SIZE;								//��ȡindex
		if(buckets[index]==null){								//�����и�indexΪnull����new LinkedList�� ������Ԫ��
			buckets[index] = new LinkedList<MapEntry<K,V>>();	
			buckets[index].add(new MapEntry<K,V>(key,value));
			return null;
		}
		LinkedList<MapEntry<K,V>> bucket = buckets[index];		//�����иõ�ַ��Ϊ�գ�ȡ��������LinkedList������ָ��key��value�������
		Iterator<MapEntry<K,V>> it = bucket.iterator();
		while(it.hasNext()){
			MapEntry<K,V> me = it.next();
			if(hash==me.getKey().hashCode()&&(key==me.getKey()||me.getKey().equals(key))){		//list���Ƿ�����˼�ֵ��
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
