package tree;

import java.util.ArrayList;
import java.util.List;

public class UniqueBSTII {

    public List<TreeNode> generateTrees(int n) {

        if(n==0)
            return new ArrayList<TreeNode>();

        return generateTreeHelper(1,n);
    }

    public List<TreeNode> generateTreeHelper(int start, int end)
    {
        List<TreeNode> list = new ArrayList<>();

        if(start>end)
        {
            list.add(null);
            return list;
        }

        for(int i=start;i<=end;i++)
        {
            List<TreeNode> left= generateTreeHelper(start,i-1);
            List<TreeNode> right=generateTreeHelper(i+1,end);

            for(TreeNode l : left)
            {
                for(TreeNode r: right)
                {
                    TreeNode n = new TreeNode(i);
                    n.left=l;
                    n.right=r;
                    list.add(n);
                }
            }

        }

        return list;
    }

}
