package com.datast.trees;

import java.util.Arrays;

public class TrieTree {
	private int size = 26;
	private TrieNode root = new TrieNode();
	private  class TrieNode {
		private char value;
		private int num;
		private TrieNode[] sons;
		private boolean isEnd;
		public TrieNode(){
			num =1 ;
			sons = new TrieNode[size];
			isEnd = false;
		}
		public void setValue(char s){
			this.value = s;
		}
	}
	public void insert(String str){
		if(str==null||str.length()==0)
			return;
		TrieNode node = root;
		char chs[] =str.toCharArray();
		for (int i = 0; i < str.length(); i++) {
			int pos = chs[i] - 'a';
			//System.out.println(Arrays.toString(chs)+" : "+pos);
			if(node==null||node.sons[pos] == null){
				node.sons[pos] = new TrieNode();
				node.sons[pos].setValue(chs[i]);
			}else{
				node.sons[pos].num++;
			}
			node = node.sons[pos];
		}
		//node.isEnd = true;
	}
	public int getStringNum(String str){
		int rst = 0;
		if(str==null||str.length()==0)
			return rst;
		char[] chs = str.toCharArray();
		TrieNode node = root;
		for (int i = 0; i < str.length(); i++) {
			int pos = chs[i] - 'a';
			if(node.sons[pos] == null)
				return 0 ;
			node = node.sons[pos];
		}
		rst = node.num;
		return rst;
	}
	public static void main(String[] args) {
		String s1[] = {"test","testa","testb","tes","hahhahahah"};
		TrieTree tt=  new TrieTree();
		for (int i = 0; i < s1.length; i++) {
			tt.insert(s1[i]);
		}
		System.out.println(tt.getStringNum("tes"));
	}

}
