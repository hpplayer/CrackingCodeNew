/**
 * Copyright 2014 Author: hpPlayer
 *
 * All Right Reserved
 *
 * Created on Nov 8, 2014 8:30:14 PM
 */
package Chapter4;
import CtCILibrary.*;
public class p_4_7 {
	
	public static void main(String[] args) {
		int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		TreeNode root = TreeNode.createMinimalBST(array);
		TreeNode n3 = root.find(4);
		//System.out.println(n3.data);
		TreeNode n7 = root.find(1);
	//	System.out.println(n7.data);
		root.print();
		TreeNode ancestor = solution(root, n3, n7);
		System.out.println(ancestor.data);
	}
	

	public static TreeNode solution(TreeNode root, TreeNode p, TreeNode q){
		//System.out.println(isLeft(root, p));
		//System.out.println(isRight(root, p));
		
		if(!isLeft(root, p) && !isRight(root, p)) {
			System.err.println("Invalid value found !");
			System.exit(0);
		}
		if(!isLeft(root, q) && !isRight(root, q)) {
			System.err.println("Invalid value found !");
			System.exit(0);
		}
		return help(root, p, q);
	}
	public static TreeNode help(TreeNode root, TreeNode p, TreeNode q){
		if(root == null) {
			return null;
		}

	
		if(isLeft(p, q) || isRight(p,q)){
			return p;
		}
		else if (isLeft(q, p) || isRight(p,q)){
			return q;
		}

		
		boolean pb = isLeft(root, p);
		boolean pq = isLeft(root, q);
		/*
		if(root.data == 5){
			System.out.println(isLeft(root, p));
			System.out.println(isLeft(root, q));
		}
		 */
		if(pb != pq){
			return root;
		}
		TreeNode temp= pb? root.left : root.right;

		return solution(temp, p, q);
	}
	
	public static boolean isLeft(TreeNode root, TreeNode n){//Notice: purly left is incorrect, cuz left.right is also left


		if (root == null) return false;
		if (root == n) return true;//found node n
		TreeNode temp = root.left;
			return (isLeft(temp, n) || isRight(temp, n));
	

	}
	public static boolean isRight(TreeNode root, TreeNode n){
	

		if (root == null) return false;
		if (root == n) return true;//found node n
		TreeNode temp = root.right;
		return (isLeft(temp, n) || isRight(temp, n));

		/*
		System.out.println("root " + root.data + " n " + n.data);
		while(temp.left != null){
			if(temp == n) return true;
			temp = temp.left;
		}

		return false;
		*/
		
	}
	
}
