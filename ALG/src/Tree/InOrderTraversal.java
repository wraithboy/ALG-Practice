package Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InOrderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        
    	List<Integer> result =new ArrayList<>();
    	
    	TreeNode curr=root;
    	
    	Stack<TreeNode> stack = new Stack<>();
    	
    	while(stack.size()!=0 || curr!=null )
    	{
    		if(curr!=null)
    		{
    			stack.push(curr);
    			curr=curr.left;
    		}
    		else
    		{
    			TreeNode t= stack.pop();
    			result.add(t.val);
    			curr=t.right;
    		}
    	}
    	
    	return result;
    	
    }
}
