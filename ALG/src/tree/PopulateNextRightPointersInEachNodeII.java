package tree;


class TreeLinkNode {
      int val;
      TreeLinkNode left, right, next;
      TreeLinkNode(int x) { val = x; }
  }

public class PopulateNextRightPointersInEachNodeII {

    public void connect(TreeLinkNode root) {

        TreeLinkNode childHead=new TreeLinkNode(0);
        TreeLinkNode cur=childHead;

        while(root!=null)
        {

            while(root!=null)
            {
                if(root.left!=null)
                {
                    cur.next=root.left;
                    cur=cur.next;
                }

                if(root.right!=null)
                {
                    cur.next=root.right;
                    cur=cur.next;
                }

                root=root.next;
            }

            root=childHead.next;
            cur=childHead;
            childHead.next=null;
        }

    }

}
