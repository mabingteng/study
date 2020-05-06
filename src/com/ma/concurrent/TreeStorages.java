package com.ma.concurrent;

import java.util.HashSet;
import java.util.Set;

public final class TreeStorages {
	private final Set<String> storages = new HashSet<String>();
	public TreeStorages (String a,String b, String c) {
		storages.add(a);
		storages.add(b);
		storages.add(c);
	}
	
	public boolean isStorage (String name){
		return storages.contains(name);
	}
}
