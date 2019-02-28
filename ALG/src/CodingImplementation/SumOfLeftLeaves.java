package CodingImplementation;




 

public class SumOfLeftLeaves {

	
    public int sumOfLeftLeaves(TreeNode root) {
        
    	//return sum(root.left,true)+sum(root.right,false);
    	
        if (root == null) return 0;
        if (root.left != null && root.left.left == null && root.left.right == null)
        {
            return root.left.val + sumOfLeftLeaves(root.right);
        }
        else {
            return sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
        }
    }
    
    
    public int sum(TreeNode root,boolean isLeft)
    {
    	if(root.left==null && root.right==null)
    	{
    		if(isLeft)
    		return root.val;
    		else
    		return 0;
    	}
    	
    	return (root.left==null?0:sum(root.left,true)) + (root.right==null?0:sum(root.right,false));   	
    }
    
    
//  Definition for a binary tree node.
  private static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
}
