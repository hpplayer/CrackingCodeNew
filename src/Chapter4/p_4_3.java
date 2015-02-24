/**
 * Copyright 2014 Author: hpPlayer
 *
 * All Right Reserved
 *
 * Created on Nov 5, 2014 11:13:58 PM
 */
package Chapter4;
import java.util.Arrays;

import CtCILibrary.*;
public class p_4_3 {
	public static void main(String[] args) {
		int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		// We needed this code for other files, so check out the code in the library
		TreeNode root = solution(array);
		root.print();
		System.out.println("Root? " + root.data);
		System.out.println("Created BST? " + root.isBST());
		System.out.println("Height: " + root.height());
		
		TreeNode root2 = TreeNode.createMinimalBST(array);
		root2.print();
		System.out.println("Root? " + root2.data);
		System.out.println("Created BST? " + root2.isBST());
		System.out.println("Height: " + root2.height());
	}

	public static TreeNode solution(int[] ary){
		TreeNode curNode = null;
		if (ary.length == 1) {
		//	System.out.println(ary[0]);
			TreeNode cur = new TreeNode(ary[0]);
			return cur;
		//base case
		}
		/*
		 * hanle -1 case
		 */
		/*
		if(ary[ary.length-1] == -1){
			int[] temp = new int[ary.length-1];
			for(int i = 0; i < ary.length-1; i++){
				temp[i] = ary[i];
			}
			solution(temp);
		}
		*/
		//System.out.println(ary.length);
		if(ary.length%2 == 1){
			int mid = ary[(ary.length-1)/2];
			curNode = new TreeNode(mid);
			//System.out.println("arr2 " + Arrays.toString(ary));
			//System.out.println("mid" + mid);
			int[][] result = arySplit(ary, (ary.length-1)/2);
			TreeNode leftNode = solution(result[0]);
			TreeNode RightNode = solution(result[1]);
			curNode.setLeftChild(leftNode);
			curNode.setRightChild(RightNode);
			
		}
		else if(ary.length%2 == 0 ){
	
			if(ary.length ==2){
				curNode = new TreeNode(ary[0]);
				TreeNode RightNode =  new TreeNode(ary[1]);//we dont need use split method, cuz we have only 2 nodes left
				curNode.setRightChild(RightNode);
			}else{
				int mid =  ary[(ary.length/2-1)];
				curNode = new TreeNode(mid);
				int[][] result = arySplit2(ary, ary.length/2-1);
				TreeNode leftNode = solution(result[0]);
				TreeNode RightNode = solution(result[1]);
				curNode.setLeftChild(leftNode);
				curNode.setRightChild(RightNode);
			}

		}
	
		return curNode;
	}
	
	public static int[][] arySplit(int[] arr, int index){
		int[] leftary = new int[index];
		int[] rightary = new int[index];
		/*
		System.out.println("ary " +arr.length);
		System.out.println(Arrays.toString(arr));
		System.out.println("left " +leftary.length);
		System.out.println("index " + index);
		*/

		for(int i = 0; i < index; i++){
			leftary[i] = arr[i];
		}
		for(int j = 0; j < index; j++){
			rightary[j] = arr[index + j + 1];
		}
		
		int[][]result = new int [2][index];
		result [0] = leftary;
		result [1] = rightary;
		return result;
	}
	
	public static int[][] arySplit2(int[] arr, int index){
		int[] leftary = new int[index];
		int[] rightary = new int[index+1];
	
		int[][] result;


		for(int i = 0; i < index; i++){
			leftary[i] = arr[i];
		}
		for(int j = 0; j < index+1; j++){
			rightary[j] = arr[index+1 + j];
		}
		
		result = new int [2][index+1];
		
		result [0] = leftary;//not full
	
		//System.out.println("ary " +arr.length);
		//System.out.println("left " +leftary.length);
		//System.out.println("result0 " +result[0].length);
		//System.out.println("index+1 " + (index+1));
		
	//	result [0][index+1] = -1;

		result [1] = rightary;//full
		//System.out.println("result1 " +result[1].length);
		//System.out.println("left " + Arrays.toString(result[0]));
		//System.out.println("right " + Arrays.toString(result[1]));
		return result;
	}
}
