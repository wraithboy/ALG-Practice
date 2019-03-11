package tree;

public class DiameterOfBinaryTree {

    int ans=0;

    public int diameterOfBinaryTree(TreeNode root) {

        ans=1;

        diameter(root);

        return ans-1;

    }

    private int diameter(TreeNode root)
    {
        if(root==null)
            return 0;

        int l=diameter(root.left);
        int r=diameter(root.right);
        ans=Math.max(ans,l+r+1);
        return Math.max(l,r)+1;
    }

}
