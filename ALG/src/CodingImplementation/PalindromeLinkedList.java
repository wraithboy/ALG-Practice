package CodingImplementation;

class ListNode{
	
	public int val;

	public int getval() {
		return val;
	}

	public void setval(int val) {
		this.val = val;
	}

	public ListNode next=null;
			
	public ListNode(int val)
	{
		this.val=val;
	}
}

public class PalindromeLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ListNode head=new ListNode(5);
		
		ListNode A=new ListNode(6);
		
		ListNode B=new ListNode(7);
		
		ListNode C=new ListNode(8);
		
		head.next=A;
		A.next=B;
		B.next=C;
		ListNode it=head;
		while(it!=null)
		{
			System.out.print(it.getval());
			it=it.next;
		}
		
		System.out.println();
		
		PalindromeLinkedList pl=new PalindromeLinkedList();
		
		
		
		
		System.out.println(pl.isPalindrome(head));
		
	}
	
	 public boolean isPalindrome(ListNode head) {
	        
	        if(head==null)
	        return false;
	        
	        if(head.next==null)
	        return true;
	        
	        ListNode fast=head;
	        ListNode slow=head;

	        while(fast.next!=null && fast.next.next!=null)
	        {
	            fast=fast.next;
	            fast=fast.next;
	            slow=slow.next;
	        }
	        
	        ListNode head2=reverseLinkedList(slow.next);
	        ListNode it=head2;
			while(it!=null)
			{
				System.out.print(it.getval());
				it=it.next;
			}
	        
	        boolean result=true;
	        
	        while(head2!=null)
	        {
	            
	            if(head.val!=head2.val)
	            {
	                result=false;
	                break;
	            }
	            else
	            {
	                head=head.next;
	                head2=head2.next;
	            }
	        }
	        
	        return result;
	        
	    }
	
	public ListNode reverseLinkedList(ListNode head)
	{
		ListNode prev=null;
		
		while(head.next!=null)
		{
			ListNode next=head.next;
			
			head.next=prev;
			
			prev=head;
			
			head=next;
		}
		
		head.next=prev;
		
		return head;
	}
	
}
