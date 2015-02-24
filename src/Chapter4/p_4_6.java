/**
 * Copyright 2014 Author: hpPlayer
 *
 * All Right Reserved
 *
 * Created on Nov 7, 2014 7:26:44 PM
 */
package Chapter4;
import CtCILibrary.*;

public class p_4_6 {
	public static TreeNode solution(TreeNode n){
		if( n == null) return null;
		if (n.right != null) {//leftmost node in right subtree
			TreeNode temp = n.right;
			while(temp.left != null){
				temp = temp.left;
			}
			return temp;
		}else{
				TreeNode n3 = n;
				TreeNode n2 = n.parent;
				while(n2!= null && n2.left != n3){//recursively search until we have jump out of the right subtree
					n3 = n2;
					n2 = n2.parent;
			}
				return n2;
		}
		
	}
	
	public static void main(String[] args) {
		int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		TreeNode root = TreeNode.createMinimalBST(array);
		root.print();
		for (int i = 0; i < array.length; i++) {
			TreeNode node = root.find(array[i]);
			TreeNode next = solution(node);
			if (next != null) {
				System.out.println(node.data + "->" + next.data);
			} else {
				System.out.println(node.data + "->" + null);
			}
		}
	}
}
