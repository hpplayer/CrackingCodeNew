/**
 * Copyright 2014 Author: hpPlayer
 *
 * All Right Reserved
 *
 * Created on Nov 8, 2014 8:48:29 PM
 */
package Chapter4;

import CtCILibrary.TreeNode;
/*This official method has limitations:
 * 1. input p and q can not be same side, like input 9/10 or 2/3 will give error
 * 2. input must in order like 2/4 give 2 while 4/2 give error
 * 
 */
public class p_4_7_sol2 {
	public static void main(String[] args) {
		int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		TreeNode root = TreeNode.createMinimalBST(array);
		TreeNode n3 = root.find(4);
		TreeNode n7 = root.find(2);
		TreeNode ancestor = commonAncestor(root, n3, n7);
		root.print();
		System.out.println(ancestor.data);
	}
	public static boolean covers(TreeNode root, TreeNode p) { 
		if (root == null) return false;
		if (root == p) return true;
		return covers(root.left, p) || covers(root.right, p); 
	}
		
	public static TreeNode commonAncestorHelper(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null) {
			return null;
		}
		boolean is_p_on_left = covers(root.left, p);
		boolean is_q_on_left = covers(root.left, q);
		if (is_p_on_left != is_q_on_left) { // Nodes are on different side
			return root;
		}
		TreeNode child_side = is_p_on_left ? root.left : root.right;
		return commonAncestorHelper(child_side, p, q);
	}
	
	public static TreeNode commonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if (!covers(root, p) || !covers(root, q)) { // Error check - one node is not in tree
			return null;
		}
		return commonAncestorHelper(root, p, q);
	}	
	

}
