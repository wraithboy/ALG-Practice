package Tree;

import java.util.LinkedList;
import java.util.Queue;

public class MinimumDepthOfBinaryTree {

    public int minDepth(TreeNode root) {

        if(root==null)
            return 0;

        int height=1;

        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);

        while(!queue.isEmpty())
        {

            int size=queue.size();

            for(int i=0;i<size;i++)
            {
                TreeNode t = queue.poll();
                if(t.left==null&&t.left==null)
                    return height;
                else
                {
                    if(t.left!=null)
                    queue.add(t.left);

                    if(t.right!=null)
                        queue.add(t.right);
                }

            }

            height++;
        }

        return height;

    }
}
