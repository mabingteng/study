package com.ma.nio;

import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * nio Channel的使用方式
 * @author waller
 *
 */
public class ChannelTest {

	public static void main(String[] args) throws Exception {
		RandomAccessFile aFile = new RandomAccessFile("nio.txt", "rwd");
		FileChannel fc = aFile.getChannel();
		ByteBuffer bufer  = ByteBuffer.allocate(1024);
		
		byte[] bys = "Hello world!" .getBytes();
		bufer.wrap(bys);
		//bufer.put(bys);
		bufer.flip();
		fc.write(bufer);
		
		int num = fc.read(bufer);
		while(num!=-1){
			System.out.println("read "+num);
			bufer.flip();
			while(bufer.hasRemaining())
				System.out.print((char)bufer.get());
			bufer.clear();
			num = fc.read(bufer);
		}
		
		
		aFile.close();
	}

}
