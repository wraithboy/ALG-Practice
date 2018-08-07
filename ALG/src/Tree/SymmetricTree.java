package Tree;

public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        boolean result;
        
        if(root==null)
            return true;
        else
        {
            return helper(root.left,root.right);
        }       
    }
    
    public boolean helper(TreeNode p, TreeNode q)
    {
        if(p==null && q==null)
        {
            return true;
        }
        
        if(p==null || q==null)
        {
            return false;
        }
        
        return helper(p.left,q.right)&&(p.val==q.val)&&helper(p.right,q.left);
    }
}
