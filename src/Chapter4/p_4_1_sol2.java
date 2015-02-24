package Chapter4;
import CtCILibrary.TreeNode;

public class p_4_1_sol2 {
	public static int checkHeight(TreeNode n){
		if(n == null) return 0;
		return  Math.max(checkHeight(n.left), checkHeight(n.right)) +1;
	}
	
	public static boolean solution(TreeNode n){
		if(n == null) return true;
		int heightDIff = checkHeight(n.left) - checkHeight(n.right);
		return (Math.abs(heightDIff) >1)? false : solution(n.left) && solution(n.right);
	}
	public static void main(String[] args) {
		// Create balanced tree
		int[] array = {0, 1, 2, 3, 5, 6, 7, 8, 9, 10};
		TreeNode root = TreeNode.createMinimalBST(array);

		
		System.out.println("Is balanced? " + solution(root));
		
		root.insertInOrder(4); // Add 4 to make it unbalanced

		System.out.println("Is balanced? " + solution(root));
	}
}
