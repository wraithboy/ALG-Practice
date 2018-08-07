package Tree;

import java.util.ArrayList;
import java.util.List;

public class MorrisInOrderTraversal {
	 public List<Integer> inorderTraversal(TreeNode root) {
		 
		 List<Integer> result = new ArrayList<Integer>();
		 
		 TreeNode curr=root;
		 TreeNode p;
		 while(curr!=null)
		 {
			 if(curr.left!=null)
			 {
				 TreeNode t = curr.left;
				 while(t.right!=null && t.right!=curr)
				 {
					 t=t.right;
				 }
				 
				 if(t.right==curr)
				 {
					t.right=null;
					result.add(curr.val);
					curr=curr.right;
				 }
				 else
				 {
					 t.right=curr;
					 curr=curr.left;
				 }
				 
			 }
			 else
			 {
				 result.add(curr.val);
				 
				 curr=curr.right;
			 }		 
		 }
		 
		 
	 }
}
