package com.ma.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
/**
 * copy file
 * @author waller
 *
 */
public class NIOBufferTest {
	public static void main(String[] args) throws Exception {
		FileInputStream  fin = new FileInputStream("nio.txt");
		FileOutputStream fout = new FileOutputStream("tst.txt");
		FileChannel fcin = fin.getChannel();
		FileChannel fcout = fout.getChannel();
		
		ByteBuffer bb = ByteBuffer.allocate(24);
		
		byte[] bb1 = null;
		while(true){
			int rnum = fcin.read(bb);
			if(rnum==-1)
				break;
			bb.flip();
			System.out.println("before get "+bb.position());
			bb1 = new byte[rnum];
			//bb.get(bb1);
			
			System.out.println("after get "+bb.position());
			fcout.write(bb);
			bb.clear();
		}	
		
		int i  = 0;
		while(i<bb1.length){
			
			System.out.print((char)bb1[i]);
			i++;
		}
		fcin.close();
		fcout.close();
		fin.close();
		fout.close();
	}
		
}




