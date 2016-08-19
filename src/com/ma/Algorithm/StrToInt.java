/**
 * 
 */
package com.ma.Algorithm;

/**
 * @author waller
 *	×Ö·û´®×ªÕûÊý
 */
public class StrToInt {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String str = (1<<31)-1 +"";  //2147483647
		str = (1<<31) +"";	//-2147483648  
		System.out.println(strToInt(str));
	}
	public static int strToInt(String str){
		if(str.isEmpty())
			return 0;
		int rst=0,s=1;
		char[] cs = str.toCharArray();
		if(cs[0]=='-')
			s = -1;
		for(int i = cs[0]=='-'||cs[0]=='+'?1:0;i<str.length();i++){
			rst = (rst<<1) + (rst << 3) + (cs[i]-'0');
		}
		return rst*s;
	}

}
