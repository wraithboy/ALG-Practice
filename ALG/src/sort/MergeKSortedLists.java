package sort;

import datastructure.ListNode;

public class MergeKSortedLists {

    public ListNode mergeKLists(ListNode[] lists) {
        return mergeKListsHelper(lists,0,lists.length-1);
    }

    ListNode mergeKListsHelper(ListNode[] lists,int start,int end)
    {
        if(lists==null && lists.length==0)
        {
            return null;
        }

        if(lists.length==1){
            return lists[0];
        }

        if(start==end)
        {
            return lists[start];
        }

        int mid = start+ (end - start)/2;

        ListNode left=mergeKListsHelper(lists,start,mid);
        ListNode right=mergeKListsHelper(lists,mid+1,end);

        return merge(left,right);

    }

    ListNode merge(ListNode left,ListNode right)
    {
        ListNode head=new ListNode(0);
        ListNode cur=head;

        while(left!=null && right !=null)
        {
            if(left.val<right.val)
            {
                cur.next=left;
                left=left.next;
            }else
            {
                cur.next=right;
                right=right.next;
            }

            cur=cur.next;
        }

        if(left!=null)
        {
            cur.next=left;
        }

        if(right!=null)
        {
            cur.next=right;
        }

        return head.next;
    }
}
