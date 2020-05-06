/**
 *
 */
package com.ma.collections;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author waller ����HashSet��TreeSet��LinkedHashSet���洢������
 */
public class TypesForSet {

  static <T> Set<T> fill(Set<T> set, Class<T> type) {
    try {
      for (int i = 0; i < 10; i++) {
        set.add(type.getConstructor(int.class).newInstance(i));
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return set;
  }

  static <T> void test(Set<T> set, Class<T> type) {

    fill(set, type);
    fill(set, type);
    fill(set, type);
    System.out.println(set);
  }

  public static void main(String[] args) {

    test(new HashSet<HashType>(), HashType.class);
    test(new LinkedHashSet<HashType>(), HashType.class);
    test(new TreeSet<TreeType>(), TreeType.class);
    //don't work
    test(new HashSet<SetType>(), SetType.class);
    test(new HashSet<TreeType>(), TreeType.class);
    test(new LinkedHashSet<SetType>(), SetType.class);
    test(new LinkedHashSet<TreeType>(), TreeType.class);
    //may be wrong
    try {
      test(new TreeSet<SetType>(), SetType.class);
    } catch (Exception e) {
      e.printStackTrace();
    }
    try {
      test(new TreeSet<HashType>(), HashType.class);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}


class SetType {

  int i;
  String s;

  public SetType(int i) {
    this.i = i;
  }

  public boolean equals(Object o) {
    //instanceof ��֤ǿ��ת����&&ʹ�ü���
    return o instanceof SetType && (i == ((SetType) o).i);
  }

  public String toString() {
    return Integer.toString(i);
  }
}

class HashType extends SetType {

  public HashType(int n) {
    super(n);
  }

  public int hashCode() {
    return i;
  }

}

class TreeType extends SetType implements Comparable<TreeType> {

  public TreeType(int i) {
    super(i);
  }

  @Override
  public int compareTo(TreeType o) {

    return i < o.i ? -1 : (i == o.i ? 0 : 1);
  }
	
	/*@Override
	public int compareTo(TreeType o) {
		//�ȽϾ�������ʽ
		return (o.i < i?-1:(o.i== i? 0:1));
	}*/

}