/**
 *
 */
package com.ma.test.collections;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author waller
 */
public class MapTypeTest {

  static <K, V> Map<K, String> fill(Map<K, String> map, Class<K> type) {
    try {
      for (int i = 0; i < 10; i++) {
        map.put(type.getConstructor(int.class).newInstance(i), "value" + i);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return map;
  }

  static <T> void test(Map<T, String> map, Class<T> type) {

    fill(map, type);
    fill(map, type);
    fill(map, type);
    System.out.println(map);
  }

  @SuppressWarnings("unchecked")
  public static void main(String[] args) {
		
		/*HashMap map = new HashMap<HashType, String> ();
		MapType m1 = new MapType(1);
		MapType m2 = new MapType(1);
		MapType m3 = new MapType(1);
		map.put(m1, "value1");
		map.put(m2, "value2");
		System.out.println(map);
		System.out.println(m1.equals(m2));
		System.out.println(map.get(m3));*/
    //System.out.println(map.get(new MapType(0)));
    //System.out.println(new MapType(0).hashCode());
    test(new HashMap<HashType, String>(), HashType.class);
    test(new LinkedHashMap<HashType, String>(), HashType.class);
    test(new TreeMap<TreeType, String>(), TreeType.class);
    //don't work
    test(new HashMap<MapType, String>(), MapType.class);
    test(new HashMap<TreeType, String>(), TreeType.class);
    test(new LinkedHashMap<MapType, String>(), MapType.class);
    test(new LinkedHashMap<TreeType, String>(), TreeType.class);
    //may be wrong
    try {
      test(new TreeMap<MapType, String>(), MapType.class);
    } catch (Exception e) {
      e.printStackTrace();
    }
    try {
      test(new TreeMap<HashType, String>(), HashType.class);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

}

/**
 * 参数i相同则两对象equals，未覆盖hashCode()方法，因此两对象hashCode不同
 */
class MapType {

  int i;
  String s;

  public MapType(int i) {
    this.i = i;
  }

  public boolean equals(Object o) {
    //instanceof 保证强制转化，&&使用技巧
    return o instanceof MapType && (i == ((MapType) o).i);
  }

  public String toString() {
    return Integer.toString(i);
  }
}

class HashType extends MapType {

  public HashType(int n) {
    super(n);
  }

  public int hashCode() {
    return i;
  }

}

class TreeType extends MapType implements Comparable<TreeType> {

  public TreeType(int i) {
    super(i);
  }

  @Override
  public int compareTo(TreeType o) {

    return i < o.i ? -1 : (i == o.i ? 0 : 1);
  }
	
	/*@Override
	public int compareTo(TreeType o) {
		//比较决定排序方式
		return (o.i < i?-1:(o.i== i? 0:1));
	}*/

}