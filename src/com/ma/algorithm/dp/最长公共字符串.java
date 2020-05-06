package com.ma.algorithm.dp;

public class 最长公共字符串 {
	public static void main(String[] args) {
		String A = "1AB2345CD";
		String B = "12345EF";
		System.out.println(getMaxLength(A, B));
	}
	public static int getMaxLength(String A, String B){
		int lena = A.length();
		int lenb = B.length();
		int max = 0;
		int[][] count = new int [lena+1][lenb+1];
		for(int i=0; i<lena+1;i++) count[i][0] = 0;
		for(int i=0; i<lenb+1;i++) count[0][i] = 0;
		for(int i=1; i<lena+1; i++){
			for(int j=1; j<lenb+1; j++){
				if(A.charAt(i-1)==B.charAt(j-1)){
					count[i][j] = count[i-1][j-1]+1;
					max = max>count[i][j]?max:count[i][j];
				}
				else
					count[i][j] = 0;
			}
		}
		return max;
	}
}
