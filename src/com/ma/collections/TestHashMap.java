package com.ma.collections;
import java.util.*;
import java.util.Map.Entry;
public class TestHashMap {
    @SuppressWarnings({ "unchecked", "rawtypes" })
	public static void main(String[] args) {
        HashMap h2 = new HashMap();
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
        
        //start Ó³ÉäÅÅÐò -------------------------------------
        
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
        	li.previous();
        	System.out.println("game -over--");
        }
        
        //linked list
        
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