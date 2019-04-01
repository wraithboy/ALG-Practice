package linkedList;

public class CopyRandomList {

    class Node {
        public int val;
        public Node next;
        public Node random;

        public Node() {}

        public Node(int _val,Node _next,Node _random) {
            val = _val;
            next = _next;
            random = _random;
        }
    }

    public Node copyRandomList(Node head) {

        if(head==null)
            return null;

        Node cur=head;

        // copy each node and insert between old node

        while(cur!=null)
        {
            Node tmp = new Node();

            tmp.val=cur.val;

            tmp.next=cur.next;

            cur.next=tmp;

            cur=tmp.next;

        }

        cur=head;

        while(cur!=null)
        {
            if(cur.random!=null)
            {
                cur.next.random=cur.random.next;
            }

            cur=cur.next.next;
        }


        cur=head;

        Node newHead=cur.next;

        while(cur!=null)
        {
            Node tmp=cur.next;

            cur.next=tmp.next;

            if(tmp.next!=null)
            {
                tmp.next=tmp.next.next;
            }

            cur=cur.next;
        }


        return newHead;
    }
}
