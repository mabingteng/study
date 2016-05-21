package com.ma.jvm;

public class TestVmArgs {

	public static void main(String[] args) {
		/*byte[] bt= new byte[20*1024*1024];
		System.out.print("Xmx = ");
		System.out.println(Runtime.getRuntime().maxMemory()/1024.0/1024+" M");
		System.out.print("free mem = ");
		System.out.println(Runtime.getRuntime().freeMemory()/1024.0/1024+" M");
		System.out.print("total mem = ");
		System.out.println(Runtime.getRuntime().totalMemory()/1024.0/1024+" M");*/
		
		//-Xmx20M -Xms20M -Xmn5M -XX:+PrintGCDetails
		byte[] b = null;
		for(int i = 0 ; i < 10 ; i++){
			b = new byte[25*1024*1024];
		}
		
	}

}
