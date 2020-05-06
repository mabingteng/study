package com.ma.reference;
/**
 * 引用或是新建
 * 对象和数组的 “=” 是浅层的复制了引用
 * @author mbt
 *
 */
public class ReferenceOrNew {
	public String a = "asdf";
	String b = a;
	public ReferenceOrNew(){
		super();
	}
	public ReferenceOrNew(String s){
		this.a = s;
	}
	public static void main(String args[]){
		String c = "1";
		String d =c;
		c= "2";
		System.out.println(d);//1  new
		
		ReferenceOrNew m1 = new ReferenceOrNew();  
		ReferenceOrNew m2 = m1 ;
		m1.a="1";
		System.out.println(m2.a);//1 复制引用
		
		ReferenceOrNew m3 = new ReferenceOrNew(); 
		ReferenceOrNew m4 = m3;
		m3 = new ReferenceOrNew("2");
		System.out.println(m4.a);//asdf 复制了对象的引用
		
		int [] int1 = {1,2,3}; 
		int [] int2 = int1 ;
		int1[0] = 2;
		System.out.println(int2[0]);//2   复制引用
		
		int[] i1 ={1,2,3};
		int[] i2 = i1.clone();
		i1[0] = 2;
		System.out.println(i2[0]); //1  new
	}
}
