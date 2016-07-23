package com.ma.jvm;

import java.io.InputStream;

public class MyClassLoader extends ClassLoader{
	@Override
	public Class<?> loadClass(String name) throws ClassNotFoundException{
		try {
			String fileName = name.substring(name.lastIndexOf(".")+1)+".class";
			//System.out.println(fileName);
			InputStream is = getClass().getResourceAsStream(fileName);
			if(is == null){
				//System.out.println("is == null");
				return  super.loadClass(name);
			}
			
			byte[] b = new byte[is.available()];
			is.read(b);
			return defineClass(name, b, 0, b.length);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ClassNotFoundException(name);
		}
		//return null;
	}
}
