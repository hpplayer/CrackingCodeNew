/**
 * Copyright 2014 Author: hpPlayer
 *
 * All Right Reserved
 *
 * Created on Nov 6, 2014 9:44:29 PM
 */
package Chapter4;
import CtCILibrary.*;

public class p_4_5 {
	/*my solution
	 * cant handle case where subtree is like 
	 *           6               
      			/ \       
     		   /   \      
    		  /     \     
             /       \    
    		 3       13       
  			/ \     / \   
 		   /   \   /   \  
 		   0   7 
	 *
	 * 
	 */
	public static boolean solution(TreeNode root){
			
			if(root == null  ){
				return true;
			}

			if (root.size() > 2) return false;
			if(root.left != null && root.left.data > root.data  ){
				return false;
			}
			else if(root.right != null && root.right.data <= root.data ){
				return false;
			}

			return (solution(root.left)&&solution(root.right));


	}
	

	

	
	/* Create a tree that may or may not be a BST */
	public static TreeNode createTestTree() {
		/* Create a random BST */
		TreeNode head = AssortedMethods.randomBST(10, -10, 10); 
		
		/* Insert an element into the BST and potentially ruin the BST property */
		TreeNode node = head;
		do {
			int n = AssortedMethods.randomIntInRange(-10, 10);
			int rand = AssortedMethods.randomIntInRange(0, 5);
			if (rand == 0) {
				node.data = n;
			} else if (rand == 1) {
				node = node.left;
			} else if (rand == 2) {
				node = node.right;
			} else if (rand == 3 || rand == 4) {
				break;
			}
		} while (node != null);	
		
		return head;
	}
	
	public static void main(String[] args) {
		/* Simple test -- create one */
		int[] array = {0, 3, 5, 6, 10, 13, 15, 20};
		TreeNode node = TreeNode.createMinimalBST(array);
		node.left.right.data = 7; // "ruin" the BST property by changing one of the elements
		node.print();
		boolean isBST = solution(node);
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
