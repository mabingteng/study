package com.offer;

import java.util.ArrayList;
import java.util.Queue;
import java.util.Stack;

import com.ma.collections.list.LinkedList;

public class Three {

	public static void main(String[] args) {
		  	int[][] s = {{}};
		  	System.out.println(Find(s,16));
		  	Stack<String> a = new Stack<>();
		  	
	}
	public  static boolean Find(int [][] array,int target) {
		boolean rst = false;
        int lasty = array.length;
        if(lasty==0)
            return false;
        int lastx = array[0].length;
        if(lastx==0)
        	return false;
       	int x = 0,y=0;
        
        while(y<lasty){
              
            if( array[y][x]==target){
               return true;
            }
            if(array[y][x]>target){
                lastx=x;
                x=0;
                y++;   
                continue;            	   
            }
             if(x<lastx-1)
            	x++;
            else
                x=0;
            if(x==0)
                y++;
               
                  
                
        }
        return rst;
    }
	
	 public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
	        Queue<TreeNode> queue = new LinkedList<>();
	        ArrayList<Integer> list = new ArrayList<>();
	        if(root == null){
	            return list;
	        }
	        queue.offer(root);
	        while(!queue.isEmpty()){
	        	
	            TreeNode node = queue.poll();
	        	//System.out.println(node.val);
	            list.add(node.val);
	            if(node.left!=null)
	        		queue.offer(node.left);
	            if(node.right!=null)
	            	queue.offer(node.right);
	        }
	        return list;
	    }

}
