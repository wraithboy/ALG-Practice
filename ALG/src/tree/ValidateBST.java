package tree;

public class ValidateBST {


    public boolean isValidBST(TreeNode root) {
        return helper(root,Integer.MAX_VALUE,Integer.MIN_VALUE);
    }

    public boolean helper(TreeNode root,long max, long min)
    {
        if(root==null)
            return true;

        if(root.val>=max || root.val<=min)
            return false;

        return helper(root.left,root.val,min) && helper(root.right,max,root.val);
    }
}
