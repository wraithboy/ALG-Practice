package linkedList;

public class ReorderList {

    public void reorderList(ListNode head) {

        if(head==null || head.next==null)
            return;


        ListNode slow=head;
        ListNode fast=head;
        ListNode prev=null;
        while(fast!=null || fast.next!=null)
        {
            prev=slow;
            fast=fast.next.next;
            slow=slow.next;
        }

        prev.next=null;

        //reverse second half

        ListNode cur=slow;
        prev=null;
        ListNode next=null;

        while(cur!=null)
        {
            next=cur.next;
            cur.next=prev;
            prev=cur;
            cur=next;
        }

        ListNode head2=prev;
        ListNode next2=null;
        next=null;
        while(head2!=null)
        {
            next=head.next;
            head.next=head2;
            head=head2;
            head2=next;
        }


    }

}
