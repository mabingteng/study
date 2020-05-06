/**
 *
 */
package com.ma.collections;

import java.util.Collections;
import java.util.Iterator;
import java.util.Queue;
import java.util.TreeSet;

/**
 * @author waller
 *	SortedSet��֤Ԫ�ش�������״̬,subSet(low,high)�ȷ����������Ԫ�ض����������Ԫ��
 */
public class MySortedSet {
	Queue q =null;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		java.util.SortedSet<String> ss = new TreeSet<String>();
		Collections.addAll(ss, "one two three four five six seven eight".split(" "));
		System.out.println(ss);
		String low = ss.first();
		String high = ss.last();
		System.out.println(low);
		System.out.println(high);
		Iterator<String> it = ss.iterator();
		for(int i =0 ; i <=6 ; i++){
			if(i==3) low = it.next();
			if(i==6) high = it.next();
			else System.out.println(i +" : "+it.next());
		}
		System.out.println(low);
		System.out.println(high);
		System.out.println(ss.subSet(low, high));
		System.out.println(ss.headSet(high));
		System.out.println(ss.tailSet(low));
	}

}
