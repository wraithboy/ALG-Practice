package implementation;

public class AddTwoNumbers {

	class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  	}

  	public static void main(String args[])
	{

	}


		public ListNode addTwoNumbers(ListNode l1,ListNode l2) {

			ListNode head=new ListNode(0);
			ListNode curr=head;
			int carry=0;
			int multiplier=1;
			while(l1!=null || l2!=null)
			{
				int sum=0;
				sum=sum+carry;

				if(l1!=null)
				{
					sum=sum+l1.val;
					l1=l1.next;
				}

				if(l2!=null)
				{
					sum=sum+l2.val;
					l2=l2.next;
				}

				carry=sum/10;

				int number=sum%10;

				ListNode n=new ListNode(number);
				curr.next=n;
				curr=n;
			}

			if(carry!=0)
			{
				ListNode n=new ListNode(carry);
				curr.next=n;
			}

			return head;
		}
}
