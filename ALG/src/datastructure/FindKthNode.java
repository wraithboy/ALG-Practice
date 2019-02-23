package datastructure;

public class FindKthNode {

	
	
	public static ListNode findKthToLastNode(int k,ListNode head)
	{
				
		ListNode it=head;
		ListNode kth=head;
		int i=0;
		while(i<=k&&it!=null)
		{
			it=it.next;
			i++;
		}
		
		if(it==null&&i!=k)
			return null;
		
		while(it!=null)
		{
			it=it.next;
			kth=kth.next;
		}
		
		return kth;
	}
	

}
