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
    //ʹ��volatile����64λ��long�ͱ���
    volatile long vl = 0L;

    public void set(long l) {
        vl = l;   //����volatile������д
    }
    public void getAndIncrement () {
        vl++;    //���ϣ������volatile�����Ķ�/д
    }
    public long get() {
        return vl;   //����volatile�����Ķ�
    }
}*/

	/*class VolatileFeaturesExample {
	    long vl = 0L;   // 64λ��long����ͨ����
	
	    //�Ե�������ͨ ������д��ͬһ����ͬ��
	    public synchronized void set(long l) {             
	       vl = l;
	    }
	
	    public void getAndIncrement () { //��ͨ��������
	        long temp = get();           //������ͬ���Ķ�����
	        temp += 1L;                  //��ͨд����
	        set(temp);                   //������ͬ����д����
	    }
	    public synchronized long get() { 
	        //�Ե�������ͨ�����Ķ���ͬһ����ͬ��
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
	