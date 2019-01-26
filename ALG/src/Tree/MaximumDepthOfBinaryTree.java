package Tree;

public class MaximumDepthOfBinaryTree {

    public int maxDepth(TreeNode root) {

        if(root==null)
            return 0;

        if(root.left==null && root.right==null)
            return 1;

        else return Math.max(maxDepth(root.left),maxDepth(root.right)) + 1;

    }
}
