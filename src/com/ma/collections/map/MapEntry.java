package com.ma.collections.map;

import java.util.Map;

public class MapEntry<K,V> implements Map.Entry<K,V> {

	private K key;
	private V value;
	public MapEntry(K key ,V value){
		this.key = key;
		this.value = value;
	}
	
	@Override
	public K getKey() {
		return  key;
	}

	@Override
	public V getValue() {
		return value;
	}

	@Override
	public V setValue(V value) {
		V old = this.value;
		this.value = value;
		return old;
	}
	public int hashCode(){
		return (key==null ? 0 : key.hashCode()) ^ (value==null? 0:value.hashCode()); 
	}
	@SuppressWarnings("rawtypes")
	public boolean eauals(Object o){
		if  (!(o instanceof MapEntry ))
			return false;
		MapEntry me = (MapEntry)o;
		//return me.getKey().equals(key) && me.getValue().equals(value);
		return (key==null? me.getKey()==null: me.getKey().equals(key)) 
				&& 
				(value==null?me.getValue()==null : me.getValue().equals(value));
	}

}
