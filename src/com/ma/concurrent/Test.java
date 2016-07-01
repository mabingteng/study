package com.ma.concurrent;

import java.util.concurrent.ConcurrentHashMap;

public class Test {
	volatile static int []a = {1,2,3,4,5,6,7,6}; 
	public static void main(String args[]){
			a[0] = 0;
			int[] b = a;
			b[0] = 100;
			ConcurrentHashMap<String, String> cmap = new ConcurrentHashMap<String, String>();
			// cmap.put("s", null);
			
	}
}

/*class ReorderExample {
	int a = 0;
	boolean flag = false;
	
	public void writer() {
	    a = 1;                   //1
	    flag = true;             //2
	}
	
	public void reader() {
	    if (flag) {                //3
	        int i =  a * a;        //4
	       
	    }
	}
}
*/

/*class VolatileFeaturesExample {
    //使用volatile声明64位的long型变量
    volatile long vl = 0L;

    public void set(long l) {
        vl = l;   //单个volatile变量的写
    }
    public void getAndIncrement () {
        vl++;    //复合（多个）volatile变量的读/写
    }
    public long get() {
        return vl;   //单个volatile变量的读
    }
}*/

	/*class VolatileFeaturesExample {
	    long vl = 0L;   // 64位的long型普通变量
	
	    //对单个的普通 变量的写用同一个锁同步
	    public synchronized void set(long l) {             
	       vl = l;
	    }
	
	    public void getAndIncrement () { //普通方法调用
	        long temp = get();           //调用已同步的读方法
	        temp += 1L;                  //普通写操作
	        set(temp);                   //调用已同步的写方法
	    }
	    public synchronized long get() { 
	        //对单个的普通变量的读用同一个锁同步
	        return vl;
	    }
	}*/
	
/*class VolatileExample {
    int a = 0;
    volatile boolean flag = false;

    public void writer() {
        a = 1;                   //1
        flag = true;               //2
    }

    public void reader() {
        if (flag) {                //3
            int i =  a;           //4
            
        }
    }
}*/
	