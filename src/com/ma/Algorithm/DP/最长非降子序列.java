package com.ma.Algorithm.DP;

import java.util.ArrayList;
import java.util.Arrays;
/**
 * 最长上升子序列
 * 
 * 题目：广场上站着一支队伍，她们是来自全国各地的扭秧歌代表队，现在有她们的身高数据，
 * 请你帮忙找出身高依次递增的子序列。 例如队伍的身高数据是（1、7、3、5、9、4、8），
 * 其中依次递增的子序列有（1、7），（1、3、5、9），（1、3、4、8）等，其中最长的长度为4。
 * @author waller
 *
 */
public class 最长非降子序列 {

	public static void main(String[] args) {
		int arr[] = {186,186, 150, 200, 160, 130, 197, 200};
		System.out.println(getMaxLIS(arr));
		System.out.println(tst(arr));
		//printMaxLIS(arr);
	}
	
	public static int getMaxLIS(int arr[]){
		if(arr==null||arr.length==0)
			return 0;
		int len = arr.length;
		int[] d = new int [len];
		d[0] = 1;
		for (int i = 1; i < len; i++) {
			d[i] = 1;
			for (int j = 0; j < i; j++) {
				if(arr[j]<=arr[i]){
				  d[i] = d[i]>d[j]+1? d[i]: d[j]+1;
				}
			}
		}
		Arrays.sort(d);
		return d[len-1];
	}
	public static void printMaxLIS(int arr[]){
		if(arr==null||arr.length==0)
			return;
		int len = arr.length;
		ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
		for(int i=0; i<len; i++){
			ArrayList<Integer> lst = new ArrayList<Integer>();
			int max=0;
			for(int j=0; j<i; j++){
				if(arr[j]<=arr[i]){
					if(max<list.get(j).size())
						max = list.get(j).size();
						lst =  new ArrayList<>(list.get(j));
				}
			}
			lst.add(arr[i]);
			list.add(lst);
		}
		int index = 0;
		int max = list.get(index).size();
		for(int i=0; i<len; i++){
			System.out.println(list.get(i));
			if(max<list.get(i).size())
				index = i;
		}	
		System.out.println(list.get(index).toString());
		
	}

	public static int tst(int arr[]){
		int len = arr.length;
		int d[] = new int[len];
		for (int i = 0; i < len; i++) {
			d[i] = 1;
			for (int j = 0; j < i; j++) {
				if(arr[i]>arr[j]&&d[i]<d[j]+1)
					d[i] = d[j]+1;
			}
		}
		Arrays.sort(d);
		return d[len-1];
	}
}
