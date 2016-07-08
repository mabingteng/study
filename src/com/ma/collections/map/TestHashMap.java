package com.ma.collections.map;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Random;
import java.util.TreeMap;
public class TestHashMap {
    @SuppressWarnings({ "unchecked", "rawtypes" })
	public static void main(String[] args) {
      /*  HashMap h2 = new HashMap();
        for (int i = 0; i < 10; i++) {
            h2.put(new Element(i), new Figureout());
        }
        Element test = new Element(3);
        if (h2.containsKey(test)) {System.out.println((Figureout) h2.get(test));} 
        else {
            System.out.println("Not found");
        }
       
       
        System.out.println(h2);
        Element tes2 = new Element(3);
        System.out.println(test.hashCode());
        System.out.println(tes2.hashCode());
        System.out.println( test.hashCode() == tes2.hashCode());
        
        h2.put(test, "123");
        h2.put(test, "456");
        h2.put("1", "1212");
        System.out.println(h2.get("1"));
        
        //start 映射排序 -------------------------------------
        
        TreeMap<Integer,String> tm = new TreeMap<Integer,String>();
        tm.put(12,"A" );
        tm.put(14, "G");
        tm.put(13, "D");
       
        for (Integer st :  tm.keySet()) {
			System.out.print(st +" : ");
			System.out.println(tm.get(st));
		} 
        for(Entry<Integer, String> s : tm.entrySet()){
        	System.out.println(s.getKey() +" : "+s.getValue());
        }
        System.out.println(tm);
        
        //end ----------------------------------------
       
        
        // list sort
        ArrayList<Integer> list = new ArrayList<Integer>();
        for(int i = 10 ; i > 0 ; i --){
        	list.add(i);
        }
        Collections.sort(list);
        System.out.println(list);
        for(Iterator<Integer> a = list.iterator();a.hasNext();){
        	Integer ls =  a.next();
        }
        for(ListIterator li = list.listIterator(); li.hasNext();){
        	li.next();
        	//li.previous();
        	System.out.println("game -over--");
        }
        */
        //linked list
    	
        HashMap<String ,String> map = new HashMap<String, String>();
        for(int i =0 ; i < 10 ; i++){
        	map.put("key"+i, "value"+i);
        }
        Iterator<Entry<String, String>> it = map.entrySet().iterator();
        while(it.hasNext()){
        	it.next();
        	it.remove();
        }
        System.out.println(map);
        String h1 = new String("hello");
        String h2 = new String("holle");
        //字符串相同的两个String对象使用一块内存
        //System.out.println(h1.equals(h2));
        
        //testPriority(1000000000);
        TreeMap<String,String> tmap = new TreeMap<String, String>();
        tmap.put("1", "1");
        tmap.put("1", "2");
        System.out.println(tmap);
    }
    
    public static void testPriority(int i){
         long start = System.currentTimeMillis();
         int n=i;
         while(i>=0){
         	i--;
         	//int a = i & (8-1);
         	int a =  (i<<5)-i;
         }
         long used = System.currentTimeMillis()-start;
         System.out.println(used +" ms");
         long start2 = System.currentTimeMillis();
         
         while(n>=0){
         	n--;
         	//int a = n % (8);
         	int a = 3 * i;
         }
         long used2 = System.currentTimeMillis()-start2;
         System.out.println(used2 +" ms");
    }
}
    
  class Element {
        int number;
        public Element(int n) {
            number = n;
            }
    }
  class Figureout {
    Random r = new Random();
    boolean possible = r.nextDouble() > 0.5;
    public String toString() {
	    if (possible) 
	    return "OK!";
	    else 
	    	return "Impossible!";
	    
    	}
    }