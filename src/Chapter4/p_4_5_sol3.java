/**
 * Copyright 2014 Author: hpPlayer
 *
 * All Right Reserved
 *
 * Created on Nov 6, 2014 11:45:36 PM
 */
package Chapter4;

import CtCILibrary.TreeNode;

public class p_4_5_sol3 {
	static boolean checkBST(TreeNode root, Integer max, Integer min){
		if(root == null){
			return true;
		}
		
		//if((min != null && min > root.data) ||(max != null && max < root.data)){
		if(min > root.data || max < root.data){
			return false;
		}
		
		if(!checkBST(root.left, root.data, min) || !checkBST(root.right, max, root.data)) return false;
		return true;
	}
	static boolean checkBST(TreeNode root){
		return checkBST(root, Integer.MAX_VALUE, Integer.MIN_VALUE);
	}
	
	public static void main(String[] args) {
		/* Simple test -- create one */
		int[] array = {0, 3, 5, 6, 10, 13, 15, 20};
		TreeNode node = TreeNode.createMinimalBST(array);
		node.left.left.data = 7; // "ruin" the BST property by changing one of the elements
		node.print();
		boolean isBST = checkBST(node);
		System.out.println(isBST);
		//System.out.println(isBst);
		/* test createTestTree(), failed;
		boolean isBST = false;
		while(isBST != true){
		TreeNode node = createTestTree();
		//node.print();
		isBST = solution(node);
		//System.out.println(isBST);
		}
		*/

		
		/* More elaborate test -- creates 100 trees (some BST, some not) and compares the outputs of various methods. */
		/*for (int i = 0; i < 100; i++) {
			TreeNode head = createTestTree();
			
			// Compare results 
			boolean isBst1 = checkBST(head);
			boolean isBst2 = checkBSTAlternate(head);
			
			if (isBst1 != isBst2) {
				System.out.println("*********************** ERROR *******************");
				head.print();
				break;
			} else {
				System.out.println(isBst1 + " | " + isBst2);
				head.print();
			}
		}*/
	}
}
