/**
 * Copyright 2014 Author: hpPlayer
 *
 * All Right Reserved
 *
 * Created on Nov 8, 2014 11:53:17 PM
 */
package Chapter4;
import CtCILibrary.*;
public class p_4_7_sol3 {
	public static void main(String[] args) {
		int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		TreeNode root = TreeNode.createMinimalBST(array);
		TreeNode n3 = root.find(7);
		//System.out.println(n3.data);
		TreeNode n7 = root.find(10);
	//	System.out.println(n7.data);
		root.print();
		TreeNode ancestor = solution(root, n3, n7);
		System.out.println(ancestor.data);
	}
	
	public static class Big{//subclass
		public TreeNode node;
		public boolean inTree;
		public Big(TreeNode n, boolean i){
			node = n;
			inTree = i;
		}
	}
	
	static public Big Helper(TreeNode root, TreeNode p, TreeNode q){
		if(root == null) return new Big(null, false);//base case
		if(root == p && root == q) return new Big( root, true);// case where P and q are same node
		
		Big lf= Helper(root.left, p , q);
		if(lf.inTree) return lf;//for nodes above common ancestor
		
		Big rt = Helper(root.right, p, q);
		if(rt.inTree) return rt;//for nodes above common ancestor
		
		if(rt.node != null && lf.node != null){//left and right subtree both have p/q value, so it is the common ancestor
			return new Big(root, true);
		}
		else if (root == p || root == q){
			//if either p/q is not null, and we are currently at q/p, then q/p is true common ancestor node
			//otherwise we dont have that p/q and of course we dont have common ancestor
			//if we dont have p/q in tree then we will return null, and the final output will looklike q/p
			//i.e. seems we have common ancestor q/p and p/q is a child of it, but actually we dont have p/q and should return null
			boolean bl = lf.node != null || rt.node != null ? true: false;
			return new Big(root, bl);
		}
		else{
			return new Big(lf.node != null? lf.node : rt.node, false);//case that not reach common ancestor yet
		}
	}
	
	static TreeNode solution(TreeNode root, TreeNode p, TreeNode q){
		Big result = Helper(root, p, q);
		if(result.inTree){
			return result.node;
		}else{
			System.err.println("Invalid value found !");
			System.exit(0);
			return null;
		}
		
		
	}
}
