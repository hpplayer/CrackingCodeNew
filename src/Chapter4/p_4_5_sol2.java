/**
 * Copyright 2014 Author: hpPlayer
 *
 * All Right Reserved
 *
 * Created on Nov 6, 2014 10:09:21 PM
 */
package Chapter4;


import CtCILibrary.TreeNode;

public class p_4_5_sol2 {
	public static Integer last_printed = null;
	public static boolean checkBST(TreeNode n) {
		if (n == null) {
			return true;
		}
		
		// Check / recurse left
		if (!checkBST(n.left)) {
			return false;
		}
		
		// Check current
		if (last_printed != null && n.data <= last_printed) {
			return false;
		}
		last_printed = n.data;
		
		// Check / recurse right
		if (!checkBST(n.right)) {
			return false;
		}
		return true;
	}

	public static void main(String[] args) {
		int[] array = {0, 3, 5, 6, 10, 13, 15, 20};
		TreeNode node = TreeNode.createMinimalBST(array);

		node.left.right.data = 7;
		node.print();
		//node.left.right.data = 3;
		System.out.println(checkBST(node));
	}
}

