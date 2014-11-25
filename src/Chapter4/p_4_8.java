/**
 * Copyright 2014 Author: hpPlayer
 *
 * All Right Reserved
 *
 * Created on Nov 11, 2014 3:14:21 PM
 */
package Chapter4;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

import CtCILibrary.*;

public class p_4_8 {
	/* Successfully run !!!! cheers!
	 * Basic idea: we need BFS to traversal the whole tree to check every node that has value < sum, since we dont know if this small
	 * node will be included in our final set
	 * Then the problem becomes simpler, since for each small node, we just need to consider the cases that each path rooted at this 
	 * small node. We have other two methods, one for print the output and another one for recursively checking the sum of each path
	 * we change input to (sum-current_node.data) for each call, so if the series of call finally give sum = 0 then we know we found such
	 * path.
	 * 
	 * MARK: my solution cant handle negative case
	 * UPDATE: my solution now can handle negative case
	 * but the time and space complexity is not ideal
	 */
	public static void main(String [] args){
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
		long elapsedTime = System.nanoTime() - start;
		System.out.println(elapsedTime);
	}
	
	
	
	public static void solution(TreeNode root, int sum){
		BFS(root, sum);
	}
	
	public static void BFS(TreeNode n, int sum){
			Queue<TreeNode> q = new LinkedList<TreeNode>();
			q.add(n);
			while(!q.isEmpty()){
				TreeNode temp = q.remove();
				ArrayList<Integer> ary = new ArrayList<Integer>();
				search(temp, sum, ary);
				/*code below is still work, but has constraint that nodes must be non-negative
				if (temp.data <= sum) {
					ArrayList<Integer> ary = new ArrayList<Integer>();
					search(temp, sum, ary);
				}
				*/
				if(temp.left != null) q.add(temp.left);
				if(temp.right != null) q.add(temp.right);
			}

	}
	public static boolean sumChecker(int sum, ArrayList<Integer> ary){
		Iterator<Integer> n = ary.iterator();
		int sum2 = 0;
		while(n.hasNext()){
			sum2 +=n.next();
		}
		return (sum2 == sum);
		
	}
public static TreeNode search(TreeNode root, int sum, ArrayList<Integer> ary){//we start find path start with this node
		ary.add(root.data);// assume we need this data
		ArrayList<Integer> ary2 = (ArrayList<Integer>) ary.clone();
		//System.out.println(ary.toString());
		if(sumChecker(sum, ary)) {
			print(ary);
		}
		if(root.right!= null) {
			search(root.right, sum, ary);
		}
		//System.out.println(ary == ary2);
		if(root.left != null) {
			search(root.left, sum, ary2);
		}
		if(root.left == null && root.right == null){
			//ary.clear();
		}
		return null;//we dont care what to return, we only care if it printout the result
	
 	}
/* code below is still work, but has constraint that nodes must be non-negative
	public static TreeNode search(TreeNode root, int sum, ArrayList<Integer> ary){//we start find path start with this node
		
		if(root.data > sum) {//impossible to going down
			return null;
		}
	
		ary.add(root.data);// assume we need this data
		if (sum - root.data == 0){
			print(ary);
		}
		
		if(root.right!= null) {
			search(root.right, sum - root.data, ary);
		}
		if(root.left != null) {
			search(root.left, sum - root.data, ary);
		}
		return null;//we dont care what to return, we only care if it printout the result
	
 	}
	*/
  public static void print(ArrayList<Integer> ary){
	  System.out.println(ary.toString());
  }
	

	
}
