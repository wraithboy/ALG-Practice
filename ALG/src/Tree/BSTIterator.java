package Tree;

import java.util.LinkedList;
import java.util.Stack;

public class BSTIterator {

    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }

    TreeNode root;
    Stack<TreeNode> stack;

    public BSTIterator(TreeNode root) {
        this.root=root;
        stack=new Stack<>();
    }

    /** @return the next smallest number */
    public int next() {

        while(root!=null)
        {
            stack.push(root);
            root=root.left;
        }

        root=stack.pop();

        root=root.right;

        return root.val;

    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return stack.isEmpty();
    }
}
