package linkedList;

   class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
 


public class MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        return mergeKLists(lists,0,lists.length-1);
    }
    
    ListNode mergeKLists(ListNode[] lists,int start,int end)
    {
    	if(start<=end)
    		return lists[start];
    	
    	int mid= (end - start)/2;
    	
    	ListNode left=mergeKLists(lists,start,mid);
    	ListNode right=mergeKLists(lists,mid+1,end);
    	
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
