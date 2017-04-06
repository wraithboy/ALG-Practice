package Coding;

public class AddTwoNumbers {	
	
		public static void main(String args[])
		{
			
			
			
		}
		
	    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
	        ListNode head=null;
	        ListNode curr=null;
	        int count=1;
	        int value=0;
	        while(l1!=null||l2!=null)
	        {
	            if(l1!=null && l2!=null)
	            value=value+l1.val*count+l2.val*count;
	            else if(l1==null)
	            {
	                value=value+l2.val*count;
	            }
	            else
	            {
	                value=value+l1.val*count;
	            }
	            if(l1!=null)
	            l1=l1.next;
	            if(l2!=null)
	            l2=l2.next;
	            count=count*10;
	        }
	        
	        while(count!=1)
	        {
	            int number= value/count;
	            ListNode node=new ListNode(number);
	            if(head==null)
	            {
	                head=node;
	                curr=head;
	            }
	            else
	            {
	                curr.next=node;
	                curr=curr.next;
	            }
	            
	            count=count/10;
	        }
	        
	        return head;
	    }

	
	  private static class ListNode {
	       int val;
	       ListNode next;
	       ListNode(int x) {
	          val = x;
	          next = null;
	      }
	  }
}
