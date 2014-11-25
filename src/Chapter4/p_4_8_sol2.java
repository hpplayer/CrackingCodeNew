/**
 * Copyright 2014 Author: hpPlayer
 *
 * All Right Reserved
 *
 * Created on Nov 13, 2014 1:23:23 AM
 */
package Chapter4;

import CtCILibrary.TreeNode;

public class p_4_8_sol2 {
	public void main(String [] args){
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(3);
		root.right = new TreeNode(1);
		root.left.left = new TreeNode(4);
		root.left.left.left = new TreeNode(-1);
		root.left.right = new TreeNode(8);
		root.left.left.right = new TreeNode(10);
		root.right.left = new TreeNode(2);
		root.right.right = new TreeNode(6);
		root.print();
		long start = System.nanoTime();    
		solution(root, 10);
		//long end = System.nanoTime();    
		long elapsedTime = System.nanoTime() - start;
		System.out.println(elapsedTime);
	}
	void findsum(TreeNode root, int sum, int[] path, int level){
		if(root == null) return;
		
		path[level] = root.data;
		
		int sum2 = 0;
		for(int i = 0; i < path.length; i++){
			sum2 += path[i];
			if(sum2 == sum) print(path, i, level);
		}
		
		findsum(root.left, sum, path, level+1);
		findsum(root.right, sum, path, level +1);
		
		path[level] = Integer.MAX_VALUE;//cuz we are summing backward, we should have done summing at this step, 
		//and it does not matter what current value in this path
	}
	
	void print(int[] path, int start, int end){
		for(int i = start; i <= end; i++){
			System.out.println(path[i] + " ");
		}
		System.out.println();
	}
	
	void solution(TreeNode node, int sum){
		int depth = depth(node);
		int[] path = new int[depth];
		findsum(node, sum, path, 0);
	}
	int depth(TreeNode root){
		if(root == null){
			return 0;//reach bottom, counter = 0
		}else{
			return 1+Math.max(depth(root.left), depth(root.right)); // counter += 1 everytime
		}
	}
}
