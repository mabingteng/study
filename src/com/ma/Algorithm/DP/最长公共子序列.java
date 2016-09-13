package com.ma.Algorithm.DP;

import java.util.Arrays;
/**
 *  公共子序列
 */
public class 最长公共子序列 {
	
	public static void main(String[] args) {
		String s1 = "ttrmeoqrheqojqaxiobgmvmievtbbi";
		String s2 = "cxgzqczkjxjfyyzuhtgxrgfqojoogcxgluqzveuznczntawtbfov";
		System.out.println(getLCS(s1,s1.length(),s2,s2.length()));
		System.out.println(getLength(s2,30, s1,58));
	}
	
	public static int getLength(String s1, int n, String s2, int m){
		int rst = 0;
		if(s1==null||s2==null||s1.length()==0||s2.length()==0)
			return rst;
		int len = s1.length()>s2.length()?s1.length():s2.length();
		int d[] = new int[len];
		int index[] = new int[len];
		
		for (int i = 0; i < s1.length(); i++) {
			char c = s1.charAt(i);
			d[i] = s2.indexOf(c)>=0?1:0;  //s2 contains s1?
			index[i] = s2.indexOf(c)>=0?s2.indexOf(c):0;
			int num  =Integer.MAX_VALUE;
			int mx=d[i];
			int idx = -1;
			for (int j = 0; j < i; j++) {
				if(mx<d[j]+1&&( s2.substring(index[j]).indexOf(c))>0){
					if(mx<d[j]){
						mx = d[j];
						idx = j;
						num = s2.substring(index[j]).indexOf(c)+index[j];
					}else if (mx == d[j] && index[j]+s2.substring(index[j]).indexOf(c)<num){
						num = s2.substring(index[j]).indexOf(c)+index[j];
						idx = j;
					}
					//System.out.println("---");
				}
			}
			if(idx!=-1){
				index[i] = num; 
				d[i] = d[idx] + 1;
			}
			
		}
		Arrays.sort(d);
		//System.out.println(Arrays.toString(index));
		//System.out.println(Arrays.toString(d));
		rst = d[d.length-1];
		return rst;
	}
	public static int getLCS(String A ,int 	n, String B, int m){
		int rst = 0;
		if(A==null||B==null||A.length()!=n||B.length()!=m)
			return rst;
		int[][] table = new int[n+1][m+1];
		for(int i=0; i<n+1; i++)table[i][0]=0;
		for(int i=0; i<m+1; i++)table[0][i]=0;
		for (int i = 1; i < n+1; i++) {
			for (int j = 1; j < m+1; j++) {
				if(A.charAt(i-1)==B.charAt(j-1))
					table[i][j] = table[i-1][j-1]+1;
				else
					table[i][j] = table[i-1][j]>table[i][j-1]?table[i-1][j]:table[i][j-1];
			}
		}	
		return table[n][m];
	}
}
