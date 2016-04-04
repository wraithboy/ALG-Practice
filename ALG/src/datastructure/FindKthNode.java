package datastructure;

public class FindKthNode {
	
	
	public static void main(String args[])
	{
		ListNode a = new ListNode("Angel Food");
				ListNode		b =new  ListNode("Bundt");
						ListNode		c =new  ListNode("Cheese");
								ListNode		d =new  ListNode("Devil's Food");
										ListNode		e =new ListNode("Eccles");
										a.next=b;
										b.next=c;
										c.next=d;
										d.next=e;
										e.next=null;
										
										
				System.out.println(findKthToLastNode(0,a).value);
	}
	
	
	
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
