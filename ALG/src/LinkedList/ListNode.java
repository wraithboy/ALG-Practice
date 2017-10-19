package LinkedList;

public class ListNode {
	int value;
	ListNode next;
	
	public static ListNode reverse (ListNode head)
	{
		ListNode prev=null;
		
		while(head!=null)
		{
			ListNode next=head.next;
			
			head.next=prev;
			
			prev=head;
			
			head=head.next;
			
		}
		
		return head;
	}
	
	public static void main(String args)
	{
		
	}
	
	
}
