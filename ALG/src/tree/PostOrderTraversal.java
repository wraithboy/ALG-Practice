package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PostOrderTraversal {
    public List<Integer> postorderTraversal(TreeNode root) {
        
    	List<Integer> result = new ArrayList<Integer>();
    	
    	postOrder(root,result);
    	
    	return result;
    	
    }
    
    public void postOrder(TreeNode root, List<Integer> result)
    {
    	if(root==null)
    	{
    		return;
    	}
    	
    	postOrder(root.left,result);
    	postOrder(root.right,result);
    	result.add(root.val);
    }
    
    public List<Integer> postorderTraversalIterative(TreeNode root) {
    	
    	List<Integer> result = new ArrayList<Integer>();
    	
    	Stack<TreeNode> s1 = new Stack<>();
    	Stack<TreeNode> s2 = new Stack<>();
    	
    	if(root!=null)
    	{
    		s1.push(root);
    	}
    	
    	while(!s1.isEmpty())
    	{
    		TreeNode t = s1.pop();
    		if(t.left!=null)
    			s1.push(t.left);
    		if(t.right!=null)
    			s1.push(t.right);
    		s2.push(t);
    	}
    	
    	while(!s2.isEmpty())
    	{
    		result.add(s2.pop().val);
    	}
    	
    	return result;
    }
}
