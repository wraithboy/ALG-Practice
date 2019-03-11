package tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class LevelOrderTraversal {
    
	public List<List<Integer>> levelOrder(TreeNode root) {
        
        List<List<Integer>> result = new ArrayList<>();
        
        if(root==null)
            return result;
        
        Deque<TreeNode> deque = new LinkedList<>();
        
        deque.add(root);
        
        Boolean b=true;
        
            while(deque.size()!=0)
            {
                List<Integer> list = new ArrayList<Integer>();
                int j=deque.size();
                for(int i=0;i<j;i++)
                {
                    TreeNode t;

                        t = deque.removeFirst();
                        if(t.left!=null)
                            deque.add(t.left);
                        if(t.right!=null)
                            deque.add(t.right);

                    if(b)
                    list.add(t.val);
                    else
                    list.add(0,t.val);

                }            
        b=!b;

        result.add(list);
            
        }
        
        return result;
    }
}
