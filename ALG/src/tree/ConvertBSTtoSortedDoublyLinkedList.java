package tree;

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

    Node prev;

    Node first;

    public Node treeToDoublyList1(Node root) {

        DFS(root);
        prev.right=first;
        first.left=prev;
        return root;

    }

    private void DFS(Node node) {
        if (node != null) {
            DFS(node.left);

            if(prev!=null)
            {
                prev.right=node;
                node.left=prev;
            }
            else
            {
                first=node;
            }

            prev=node;

            DFS(node.right);
        }
    }

    public Node treeToDoublyList(Node root) {

        if(root==null)
            return null;

        Stack<Node> stack = new Stack<>();

        Node prev=null,first=null;

        while(root!=null || !stack.isEmpty())
        {

            while(root!=null)
            {
                stack.push(root);
                root=root.left;
            }

            root=stack.pop();

            if(first==null)
            {
                first=root;
            }

            if(prev!=null)
            {
                prev.right=root;
                root.left=prev;
            }

            prev=root;

            root=root.right;
        }


        prev.right=first;
        first.left=prev;

        return first;

    }
}
