package com.ma.Algorithm.DP;

import java.util.Scanner;
/**
 *
 * NowCoderϲ����ѩ����Ϊ��ѩ��ȷ�ܴ̼���Ϊ�˻���ٶȣ�����Ӹߴ����ʹ���������֪��ĳƬ����ĺ��Σ�������ʾ
 * 1  2  3  4 5
 * 16 17 18 19 6
 * 15 24 25 20 7
 * 14 23 22 21 8
 * 13 12 11 10 9
 * ���Դ�ĳ���㻬�����������ĸ������к��αȵ�ǰλ�õ͵ĵ㡣������ͼ��һ�����еĻ���Ϊ24-17-16-1����Ȼ25-24-23-...-3-2-1�����һ����
 * ���ڸ�������ĺ��Σ����ܰ�æ������Ļ����ж೤��
 * @author waller
 *
 */
public class ��ѩ {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNextInt()){
			int rows = sc.nextInt();
			int cols = sc.nextInt();
			int nums[][] = new int [rows][cols];
			int alcount[][] = new int[rows][cols];
			for(int i=0; i<rows; i++){
				for(int j=0; j<cols; j++){
					nums[i][j]= sc.nextInt();
					alcount[i][j]=0;
				}
			}
			int max = 0;
			for(int i=0; i<rows; i++){
				for(int j=0; j<cols; j++){
					int n = getMaxRoad(nums, rows, cols, i, j, alcount);
					if(max<n)
						max= n;
					System.out.print(alcount[i][j]+" ");
				}
				System.out.println();
			}
			System.out.println(max);
		}
		sc.close();
	}
	public static int  getMaxRoad(int[][] nums, int rows,int cols,int x,int y,int[][] alcount){
	
		if(alcount[x][y]!=0)
			return alcount[x][y];
		int left = 0,right=0,high=0,low=0;
		
		if(x-1>=0&&nums[x][y]>nums[x-1][y])
			left= getMaxRoad(nums, rows, cols, x-1, y,alcount);
		if(x+1<rows&&nums[x][y]>nums[x+1][y])
			right = getMaxRoad(nums, rows, cols, x+1, y,alcount);
		if(y-1>=0&&nums[x][y]>nums[x][y-1])
			high = getMaxRoad(nums, rows, cols, x, y-1,alcount);
		if(y+1<cols&&nums[x][y]>nums[x][y+1])
			low = getMaxRoad(nums, rows, cols, x, y+1,alcount);
		
		int n = getMaxNum(left, right, high, low)+1;
		alcount[x][y]=n;
		return n;
	}
	public static int getMaxNum(int a,int b, int c ,int d){
		a = a>b? a:b;
		c = c>d? c:d;
		a = a>c? a:c;
		return a;
	}
	
}
