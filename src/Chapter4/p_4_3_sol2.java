/**
 * Copyright 2014 Author: hpPlayer
 *
 * All Right Reserved
 *
 * Created on Nov 6, 2014 1:32:39 AM
 */
package Chapter4;

import CtCILibrary.TreeNode;

public class p_4_3_sol2 {

	public static void main(String[] args) {
		int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		// We needed this code for other files, so check out the code in the library
		TreeNode root = solution(array);
		root.print();
		System.out.println("Root? " + root.data);
		System.out.println("Created BST? " + root.isBST());
		System.out.println("Height: " + root.height());
		
		TreeNode root2 = TreeNode.createMinimalBST(array);
		root2.print();
		System.out.println("Root? " + root2.data);
		System.out.println("Created BST? " + root2.isBST());
		System.out.println("Height: " + root2.height());
	}
	//start, end is the index in the array
	public static TreeNode createTree(int ary[], int start, int end){
		if(end < start){
			return null;
		}
		int mid = (start + end) /2;
		TreeNode cur = new TreeNode(ary[mid]);
		cur.left = createTree(ary, start, mid-1);
		cur.right = createTree(ary, mid+1, end);
		return cur;
	}
	
	public static TreeNode solution(int ary[]){
		return createTree(ary, 0, ary.length -1);
	}
}
