package Tree;

public class LowestCommonAncestorBST {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if(root==null || p==null || q==null )
            return null;

        if(p.val>root.val && q.val>root.val)
        {
            return lowestCommonAncestor(root.right,p,q);
        }
        else if(p.val<root.val && q.val <root.val)
        {
            return lowestCommonAncestor(root.left,p,q);
        }
        else {
            return root;
        }
    }
}
