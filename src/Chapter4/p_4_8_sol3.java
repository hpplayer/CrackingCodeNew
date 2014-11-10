package Chapter4;

import CtCILibrary.AssortedMethods;
import CtCILibrary.TreeNode;

public class p_4_8_sol3 {
	public static boolean matchTree(TreeNode r1, TreeNode r2){
		if(r1 == null && r2 == null) return true;// both tree have been visited throughly
		
		if(r1 == null || r2 == null) return false;//either one tree has not been fully traversal
		
		if(r1.data != r2.data) return false;
		
		return matchTree(r1.left, r2.left) && matchTree(r1.right, r2.right);
		
	}
	
	public static boolean subtree(TreeNode r1, TreeNode r2){
		if(r1 == null) return false; //r1 has been visited throughly and we have not return true(found r2) yet
		
		if(r1.data == r2.data){
			if(matchTree(r1, r2)) return true;
		}
		
		return (subtree(r1.left, r2)||subtree(r1.right, r2));
	}
	
	public static boolean solution(TreeNode r1, TreeNode r2){
		if(r2 == null) return true;// if r2 is empty tree
		
		return(subtree(r1, r2));
	}
	public static void main(String[] args) {
		// t2 is a subtree of t1
		int[] array1 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
		int[] array2 = {2, 4, 5, 8, 9, 10, 11};
		
		TreeNode t1 = AssortedMethods.createTreeFromArray(array1);
		TreeNode t2 = AssortedMethods.createTreeFromArray(array2);
		//t1.print();
		//t2.print();
		if (solution(t1, t2))
			System.out.println("t2 is a subtree of t1");
		else
			System.out.println("t2 is not a subtree of t1");

		// t4 is not a subtree of t3
		int[] array3 = {1, 2, 3};
		TreeNode t3 = AssortedMethods.createTreeFromArray(array1);
		TreeNode t4 = AssortedMethods.createTreeFromArray(array3);
		//t3.print();
		//t4.print();
		if (solution(t3, t4))
			System.out.println("t4 is a subtree of t3");
		else
			System.out.println("t4 is not a subtree of t3");
	}
	
	
}
