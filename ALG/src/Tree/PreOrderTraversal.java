package Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
}


public class PreOrderTraversal {
	
    public List<Integer> preorderTraversal(TreeNode root) {
        
        List<Integer> result= new ArrayList<>();
        
        preorder(root,result);
        
        return result;
        
    }
	
    public void preorder(TreeNode root, List<Integer> result)
    {
    	if(root==null)
    		return;
    	result.add(root.val);
    	preorder(root.left,result);
    	preorder(root.right,result);
    }
    
    public List<Integer> preorderTraversalIterative(TreeNode root) {  
    			
        List<Integer> result= new ArrayList<>();
        
        Stack<TreeNode> stack = new Stack<>();
        
        if(root!=null)
        stack.push(root);
        
        while(!stack.isEmpty())
        {
        	
        	TreeNode t=stack.pop();
        	
        	result.add(t.val);
        	
        	if(t.right!=null)
        	stack.push(t.right);
        	
        	if(t.left!=null)
        	stack.push(t.left);
        }
        
        return result;
        
    }
    
    
}
