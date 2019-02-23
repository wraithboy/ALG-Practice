package Tree;

import java.util.ArrayList;
import java.util.List;

public class PathSumII {

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        pathSumHelper(root,sum,result,new ArrayList<Integer>());
        return result;
    }

    public void pathSumHelper(TreeNode root, int sum, List<List<Integer>> result,ArrayList<Integer> curr)
    {
        if(root==null)
            return;

        if(root.left==null && root.right==null)
        {
            if(root.val==sum)
            {
                result.add(new ArrayList(curr));
                result.get(result.size()-1).add(root.val);
                return;
            }
            else
            {
                return;
            }
        }
        int newSum=sum-root.val;
        curr.add(root.val);
        pathSumHelper(root.left,newSum,result,curr);
        pathSumHelper(root.right,newSum,result,curr);
        curr.remove(curr.size()-1);
    }

}
