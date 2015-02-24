/**
 * Copyright 2014 Author: hpPlayer
 *
 * All Right Reserved
 *
 * Created on Nov 6, 2014 2:33:43 PM
 */
package Chapter4;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

import CtCILibrary.*;

public class p_4_4 {
	public static void main(String[] args) {
		int[] nodes_flattened = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		TreeNode root = AssortedMethods.createTreeFromArray(nodes_flattened);
		ArrayList<LinkedList<TreeNode>> list = solution(root);
		//System.out.println(list.size());
		//System.out.println("im done here");
		printResult(list);
	}
	
	public static ArrayList<LinkedList<TreeNode>> solution(TreeNode root){
		ArrayList<LinkedList<TreeNode>> result = new ArrayList<LinkedList<TreeNode>>();
		LinkedList<TreeNode> temp = new LinkedList<TreeNode>();
		temp.add(root);
		result.add(temp);
		while(!temp.isEmpty()){
			temp = BFS(temp);
			if(temp.isEmpty()) break;
			result.add(temp);
		}
		return result;
	
	}
	
		public static LinkedList<TreeNode> BFS(LinkedList<TreeNode> ll){
			LinkedList<TreeNode> result = new LinkedList<TreeNode>();
			for (TreeNode n: ll){
				if (n.left != null) result.add(n.left);
				if (n.right != null) result.add(n.right);
			}
			return result;
	}
		
		public static void printResult(ArrayList<LinkedList<TreeNode>> result){
			int depth = 0;
			for(LinkedList<TreeNode> entry : result) {
				Iterator<TreeNode> i = entry.listIterator();
				System.out.print("Link list at depth " + depth + ":");
				while(i.hasNext()){
					System.out.print(" " + ((TreeNode)i.next()).data);
				}
				System.out.println();
				depth++;
			}
		}
}
