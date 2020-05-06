/**
 * 
 */
package com.ma.collections;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
/**
 * @author waller
 *
 */
public class SlowMap<K,V> extends AbstractMap<K, V> {

	ArrayList<K> keys = new ArrayList<K>();
	ArrayList<V> values = new ArrayList<V>();
	
	public V put(K key ,V value){
		V old = get(key);
		if(!keys.contains(key)){
			values.set(keys.indexOf(key), value);
		}else{
			keys.add(key);
			values.add(value);
		}
		return old;
	}
	public V get(Object key){
		if(keys.contains(key))
			return values.get(keys.indexOf(key));
		return null;
	}
	

	@Override
	public Set<Map.Entry<K, V>> entrySet() {
		/*
			Set<Map.Entry< K, V>> set = new HashSet<Map.Entry<K,V>>();
			Iterator<K> ki = keys.iterator();
			Iterator<V> vi = values.iterator();
			while(ki.hasNext()){
				set.add(	new MapEntry<K, V>(ki.next(),vi.next())	);
			}
		*/
		return null;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ArrayList alist = new ArrayList<String>();
		alist.add("St");
		//alist.get(2);
		Map map = new HashMap<String, String>();
		map.put("st1", "val1");
		System.out.println(map.get("ss"));
	}
}
