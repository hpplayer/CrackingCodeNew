package Chapter4;
import CtCILibrary.*;
import java.util.LinkedList;
import java.util.Queue;

public class p_4_8 {
	public boolean compare(TreeNode b, TreeNode s){
		Queue<TreeNode> queB = new LinkedList<TreeNode>();
		Queue<TreeNode> queS = new LinkedList<TreeNode>();
		
		queB.add(b);
		queS.add(s);
		
		while(!queS.isEmpty()){
			TreeNode tempS = queS.remove();
			TreeNode tempB = queB.remove();
			if(tempS != tempB) return false;
			if(tempS.left != null) queS.add(tempS.left);
			if(tempB.left != null) queB.add(tempB.left);
			if(tempS.right != null) queS.add(tempS.right);
			if(tempB.right != null) queB.add(tempB.right);
		}
		return true;
	}
	
}
