package com.ma.Algorithm.DP;

import java.util.ArrayList;
import java.util.Arrays;
/**
 * �����������
 * 
 * ��Ŀ���㳡��վ��һ֧���飬����������ȫ�����ص�Ť������ӣ����������ǵ�������ݣ�
 * �����æ�ҳ�������ε����������С� ����������������ǣ�1��7��3��5��9��4��8����
 * �������ε������������У�1��7������1��3��5��9������1��3��4��8���ȣ�������ĳ���Ϊ4��
 * @author waller
 *
 */
public class ��ǽ������� {

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
