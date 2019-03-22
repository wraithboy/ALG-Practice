package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeRightSideView {

    public List<Integer> rightSideView(TreeNode root) {

        List<Integer> result = new ArrayList<>();

        if(root==null)
            return result;

        DFS(root,result,0);

        return result;
    }


    private void DFS(TreeNode root,List<Integer> result,int level)
    {
        if(root==null)
        {
            return;
        }

        if(result.size()==level)
        {
            result.add(root.val);
        }

        DFS(root.right,result,level+1);
        DFS(root.left,result,level+1);
    }

    public List<Integer> BFS(TreeNode root)
    {
        List<Integer> list = new ArrayList<>();
        if(root==null) return list;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty())
        {
            int size = q.size();
            for(int i=0; i<size; i++)
            {
                TreeNode n = q.poll();
                if(n.left!=null) q.add(n.left);
                if(n.right!=null) q.add(n.right);
                if(i==size-1) list.add(n.val);
            }
        }
        return list;
    }

}
