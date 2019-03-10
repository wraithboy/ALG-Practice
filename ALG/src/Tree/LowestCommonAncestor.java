package Tree;

public class LowestCommonAncestor {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if(root==null)
            return null;

        if(root.val==p.val || root.val==q.val)
            return root;

        TreeNode right = lowestCommonAncestor(root.right,p,q);
        TreeNode left = lowestCommonAncestor(root.left,p,q);

        if(right!=null && left!=null)
        {
            return root;
        }
        else if(right==null && left==null)
        {
            return null;
        }

        return right==null?left:right;
    }

}
