package CodingImplementation;

public class AddTwoNumbers {	
	
		public static void main(String args[])
		{
			
			
			
		}
		
	    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

	        int carry=0;
	        ListNode head=new ListNode(0);
	        ListNode ptr=head;
	        int val1;
	        int val2;
	        
	        while(l1!=null || l2!=null)
	        {
	            if(l1==null)
	            {
	                 val1=0;
	                 val2=l2.val;
	                 l2=l2.next;
	            }      
	            else if(l2==null)
	            {
	                  val1=l1.val;
	                  val2=0;
	                  l1=l1.next;
	            }       
	            else
	            {
	                val1=l1.val;
	                val2=l2.val;
	                l1=l1.next;
	                l2=l2.next;
	            }
	            
	            int sum=(val1+val2+carry)%10;
	            ptr.next=new ListNode(sum);
	            carry=(val1+val2+carry)/10;
	            ptr=ptr.next;
	        }
	        
	        if(carry==1)
	        {
	            ptr.next=new ListNode(carry);
	        }
	        
	        return head.next;
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
