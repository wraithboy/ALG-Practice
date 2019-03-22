package linkedList;

public class InsertIntoACyclicSortedList {

    class Node {
        public int val;
        public Node next;

        public Node() {}

        public Node(int _val,Node _next) {
            val = _val;
            next = _next;
        }
    }

    public Node insert(Node head, int insertVal) {

        if(head==null)
        {
            Node n=new Node(insertVal,null);
            n.next=n;
            return n;
        }

        Node cur=head;

        while(true)
        {
            // case 1: still climbing
            if(cur.val<cur.next.val)
            {
                if(cur.val<=insertVal && insertVal<=cur.next.val)
                {
                    Node tmp=cur.next;
                    cur.next=new Node(insertVal,tmp);
                    break;
                }
            } // next node is min node
            else if(cur.val>cur.next.val)
            {
                if(cur.val<=insertVal || insertVal<=cur.next.val) {
                    Node tmp = cur.next;
                    cur.next = new Node(insertVal, tmp);
                    break;
                }
            }
            else
            {
                if(cur.next==head)
                {
                    cur.next=new Node(insertVal,head);
                    break;
                }
            }

            cur=cur.next;
        }

        return head;
    }

}
