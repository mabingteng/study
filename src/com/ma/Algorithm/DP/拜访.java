package com.ma.Algorithm.DP;

import java.util.Arrays;

public class 拜访 {
	public static void main(String[] args) {
		int[][] map = {{0,0,0,0,0},{0,0,0,0,0},{0,0,0,1,0},{0,0,0,0,0},{0,0,0,-1,0},{0,0,0,0,0},{0,0,0,0,2}};
		int n = 7;
		int m = 5;
		
		int[][] map2 = {{0,1,0},{2,0,0}};
		//n = 2;
		//m = 3;
		int ns = new 拜访().countPath(map, n, m);
		System.out.println(ns);
		
	}
	
	public int countPath(int[][] map, int n, int m){		
		int x = -1,y=-1;	//经理位置
		int x0=-1,y0=-1;	//商家位置
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if(map[i][j]==1){
					x = j;
					y = i;	
				}else if(map[i][j]==2){
					x0=j;
					y0=i;
				}						
			}
		}
  		int[][] dp = new int[n][m];
		int fa = x>x0?-1:1;
		int fb = y>y0?-1:1;
		for (int i = 0; i < dp.length; i++) {
			System.out.println(Arrays.toString(dp[i]));
			
		}
		return counter(map,  dp, x,  y,  fa, fb);
	}
	
	private int counter(int[][] map, int[][] dp, int x, int y, int fa, int fb){
		int n = map.length;
		int m = map[0].length;
		if(x>=m||y>=n||x<0||y<0)
			return 0;			
		if(map[y][x]==-1)
			return 0;		
       if(dp[y][x]!=0)
            return dp[y][x];
		if(map[y][x]==2)
			return 1;			
		System.out.println("x:"+x+" ,y:"+y);
		int r = counter(map, dp,x+fa, y, fa, fb);			
		int d = counter(map, dp,x, y+fb, fa, fb);			
		dp[y][x] = r+d;
		
        return r+d;
	}
	
	
}

 class Visit {
    public int countPath(int[][] map, int n, int m) {
        // write code here
        int x1 = -1,y1 = -1;//经理的坐标
        int x2 = -1,y2 = -1;//商家的坐标
        for(int i = 0;i<n;i++){
            for(int j = 0; j<m;j++){
                if(map[i][j]==1){
                    x1 = j;
                    y1 = i;
                }else if(map[i][j]==2){
                    x2 = j;
                    y2 = i;
                }
            }
        }
        int xto = x1>x2?-1:1;//根据经理和商家的方向判断向左还是向右走
        int yto = y1>y2?-1:1;//向上还是向下
        //动态规划的思想 map[y][x]记录着经理到x,y点最多的路程数
        for(int y = y1;y!=(y2+yto);y+=yto){
            for(int x = x1;x!=(x2+xto);x+=xto){
                if(y==y1||x==x1){
                    map[y][x] = 1;
                    continue;
                }
                map[y][x] = map[y-yto][x]+map[y][x-xto];
            }
        }
        return map[y2][x2];
    }
}