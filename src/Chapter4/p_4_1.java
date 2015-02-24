package Chapter4;
import CtCILibrary.TreeNode;

public class p_4_1 {
	public static void main(String[] args) {
		// Create balanced tree
		int[] array = {0, 1, 2, 3, 5, 6, 7, 8, 9, 10};
		//int[]array = {0, 1};
		TreeNode root = TreeNode.createMinimalBST(array);

		
		System.out.println("Is balanced? " + solution(root));
		root.print();
		root.insertInOrder(4); // Add 4 to make it unbalanced

		System.out.println("Is balanced? " + solution(root));
	}
	
	public static boolean solution(TreeNode n){
		return (checkHeight(n)==-1)? false : true;	
	}
	
	public static int checkHeight(TreeNode n){
		if(n == null) return 0;
		
		int leftheight =checkHeight(n.left);
		if(leftheight == -1) return -1;
		int rightheight = checkHeight(n.right);
		if(rightheight == -1) return -1;
		
		int heightDiff = leftheight - rightheight;
		return Math.abs(heightDiff) > 1? -1 : Math.max(leftheight, rightheight) +1;

	}
	
}
