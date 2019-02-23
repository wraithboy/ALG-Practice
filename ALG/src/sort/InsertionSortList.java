package Sort;

import datastructure.ListNode;

public class InsertionSortList {

    public ListNode insertionSortList(ListNode head) {

        if(head==null || head.next==null)
            return head;

        ListNode dumpHead=new ListNode(0);

        dumpHead.next=head;

        ListNode toInsert,prev;

        while(head!=null && head.next!=null)
        {
            if(head.val<=head.next.val)
            {
                head=head.next;
            }
            else
            {
                toInsert=head.next;

                head.next=toInsert.next;

                prev=dumpHead;

                while(prev.next!=null && prev.next.val<=toInsert.val)
                {
                    prev=prev.next;
                }

                toInsert.next=prev.next;
                prev.next=toInsert;
            }
        }


        return dumpHead.next;
    }
}
