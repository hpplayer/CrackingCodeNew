package Chapter4;
import CtCILibrary.*;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class p_4_8 {
	/*my solution is incorrect initially (this version should be ok)
	 * when we say Ta is a subtree of Tb we mean 
	 * the subtree(from leaves to root) is identical 
	 * which means if ta is in middle of tree structure and its leaves are not the leaves
	 * of bigger tree, then ta is not a subtree of bigger tree
	 * we can fix this problem by checking if bigger tree still has nodes unvisited, if yes then return false
	 * else return true 
	 * 
	 * MARK: similar idea as official solution, difference is official one uses recursive approach, here I use iterative approach
	 */
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
	
	public static boolean solution(TreeNode b, TreeNode s){
		if(b == null) return false;
		ArrayList<TreeNode> result = BFS(b,s);
		System.out.println(result.size());
		for(int i = 0; i < result.size(); i++){
			TreeNode temp = result.remove(i);
			if(compare(temp, s)) return true;
		}
		return false;


	}
	public  static boolean compare(TreeNode b, TreeNode s){
		Queue<TreeNode> queB = new LinkedList<TreeNode>();
		Queue<TreeNode> queS = new LinkedList<TreeNode>();
		
		queB.add(b);
		queS.add(s);
		TreeNode tempS = s;
		TreeNode tempB = b;
		while(!queS.isEmpty()){
			tempS = queS.remove();
			tempB = queB.remove();
			if(tempS.data != tempB.data) return false;
			if(tempS.left != null) queS.add(tempS.left);
			if(tempB.left != null) queB.add(tempB.left);
			if(tempS.right != null) queS.add(tempS.right);
			if(tempB.right != null) queB.add(tempB.right);
		}
		if(tempB.left != null || tempB.right != null) return false;
		return true;
	}
	
	
	public  static ArrayList<TreeNode> BFS(TreeNode b, TreeNode s){
		Queue<TreeNode> queB = new LinkedList<TreeNode>();
		ArrayList<TreeNode> result = new ArrayList<TreeNode>();
		queB.add(b);
		while(!queB.isEmpty()){
			TreeNode tempB = queB.remove();
			if(tempB.data == s.data) result.add(tempB);
			if(tempB.left != null) queB.add(tempB.left);
			if(tempB.right != null) queB.add(tempB.right);
		}
		return result;
	}
	
	
}
