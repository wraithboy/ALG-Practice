package tree;

public class closetValueInBST {

    public int closestValue(TreeNode root, double target) {

        TreeNode child=root.val<target?root.right:root.left;

        if(child==null)
            return root.val;

        int k=closestValue(child,target);

        return Math.abs(target-root.val)<Math.abs(target-k)?root.val:k;

    }

}
