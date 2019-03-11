package tree;

import java.util.*;

public class BinaryTreeVerticalOrderTraversal {

    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        if(root==null)
        {
            return result;
        }

        int min=0,max=0;

        HashMap<Integer,List<Integer>> map = new HashMap<>();

        Queue<TreeNode> queue=new LinkedList<>();

        Queue<Integer> cols = new LinkedList<>();

        queue.add(root);
        cols.add(0);
        while(!queue.isEmpty())
        {
            TreeNode curr= queue.poll();
            int col = cols.poll();

            if(!map.containsKey(col))
            {
                map.put(col,new ArrayList<Integer>());
            }

            map.get(col).add(curr.val);

            if(curr.left!=null)
            {
                queue.add(curr.left);
                cols.add(col-1);
                min=Math.min(min,col-1);
            }

            if(curr.right!=null)
            {
                queue.add(curr.right);
                cols.add(col+1);
                max=Math.max(max,col+1);
            }
        }

        for(int i=min;i<=max;i++)
        {
            result.add(map.get(i));
        }

        return result;
    }
}
