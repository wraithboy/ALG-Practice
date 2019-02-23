package Tree;

public class BinaryTreeMaximumPathSum {

    public int maxPathSum(TreeNode root) {

        Integer max=Integer.MIN_VALUE;

        int[] maxPath=new int[]{Integer.MIN_VALUE};

        max(root,maxPath);

        return maxPath[0];

    }

    public int max(TreeNode root,int[] max)
    {
        if(root==null)
        {
            return 0;
        }

        int maxLeft=max(root.left,max);
        int maxRight=max(root.right,max);

        if(maxLeft<0 && maxRight<0)
        {
            if(root.val>max[0])
                max[0]=root.val;
            return root.val;
        }
        else if(maxLeft<0)
        {
            if(maxLeft+root.val>max[0])
                max[0]=root.val+maxRight;
            return root.val+maxRight;
        }
        else if(maxRight<0)
        {
            if(maxRight+root.val>max[0])
                max[0]=maxLeft+root.val;
            return root.val+maxLeft;
        }
        else
        {
            if(maxLeft+maxRight+root.val>max[0])
                max[0]=maxLeft+maxRight+root.val;
            return root.val+maxLeft+maxRight;
        }
    }

}
