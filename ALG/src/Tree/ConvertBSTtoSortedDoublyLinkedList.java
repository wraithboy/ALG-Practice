package Tree;

import java.util.Deque;
import java.util.Stack;

public class ConvertBSTtoSortedDoublyLinkedList {

    class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {}

        public Node(int _val,Node _left,Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }

    public Node treeToDoublyList(Node root) {

        if(root==null)
            return null;

        Stack<Node> stack = new Stack<>();

        Node head=null;
        Node prev=null;

        while(root!=null || !stack.empty())
        {
            while(root!=null)
            {
                stack.push(root);
                root=root.left;
            }

            root=stack.pop();

            if(head==null)
            head=root;

            if(prev!=null)
            {
                root.left=prev;
                prev.right=root;
            }

            prev=root;
            root=root.right;
        }

        head.left=prev;
        prev.right=head;

        return head;
    }
}
