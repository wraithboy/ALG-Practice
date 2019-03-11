package tree;


public class PopulatingNextRightPointersInEachNode {
    public void connect(TreeLinkNode root) {

        if (root == null)
            return;

        TreeLinkNode curr = root;

        while (curr != null) {

            TreeLinkNode ptr = curr;

            while (ptr != null) {
                if (ptr.left != null) {
                    ptr.left.next = ptr.right;
                    ptr.right.next = ptr.next == null ? null : ptr.next.left;
                }
                ptr = ptr.next;
            }

            curr = curr.left;
        }
    }
}