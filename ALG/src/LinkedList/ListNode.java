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
			
			head=next;
		}
		
		return prev;
	}
	
	public static ListNode reverse1(ListNode head)
	{
		ListNode prev=null;
		
		while(head.next!=null)
		{
			ListNode tmp=head.next;
			
			head.next=prev;
			
			prev=head;
			
			head=tmp;
		}
		
		return prev;
	}
	
	public static ListNode findMid(ListNode head)
	{
		if(head==null)
			return head;
		
		ListNode fast=head;
		ListNode slow=head;
		
		while(fast!=null && fast.next!=null)
		{
			fast=fast.next.next;
			slow=slow.next;
		}
		
		return slow;
	}
	
	public static ListNode findNth(int n,ListNode head)
	{
		int i=1;
		
		while(head!=null && i<n)
		{
			i++;
			head=head.next;
		}
		
		if(i==n)
		return head;
		else
		return null;
	}
	
	public static void print (ListNode head)
	{
		ListNode cur=head;
		StringBuilder sb=new StringBuilder();
		while(cur!=null)
		{
			System.out.println(cur.value);
			sb.append(cur.value);
			cur=cur.next;
		}
		
		System.out.println("Hello"+sb.toString());
	}
	
	
	public static void main(String args[])
	{
		ListNode a=new ListNode();
		ListNode b=new ListNode();
		ListNode c=new ListNode();
		ListNode aa=new ListNode();
		ListNode bb=new ListNode();
		ListNode cc=new ListNode();
		a.value =0;
		a.next=b;
		b.value=3;
		b.next=c;
		c.value=4;
		c.next=null;
		aa.value =1;
		aa.next=bb;
		bb.value=2;
		bb.next=cc;
		cc.value=5;
		cc.next=null;
		
//		System.out.println(ListNode.findNth(2, a).value);
		
//		ListNode.printList(aa);
		
		printList(mergeSort(aa));
	}
	
	//merge two sorted LinkedList 
	public static ListNode mergeTwoLists(ListNode l1,ListNode l2)
	{
		
		ListNode head=new ListNode();
		ListNode cur=head;
		while(l1!=null&&l2!=null)
		{
			if(l1.value<l2.value)
			{
				cur.next=l1;
				l1=l1.next;
			}else
			{
				cur.next=l2;
				l2=l2.next;
			}
			
			cur=cur.next;
		}
		
		if(l1!=null)
		{
			cur.next=l1;
		}
		if(l2!=null)
		{
			cur.next=l2;
		}
		
		return head.next;
	}
	
	public static void printList(ListNode node){
		
		ListNode ptr = node;
		
		while(ptr!=null)
		{
			System.out.print(ptr.value);
			ptr=ptr.next;
		}
	}
	
	public static ListNode mergeSort(ListNode node)
	{
		if(node.next==null)
			return node;
		ListNode mid=findMid(node);
		
		ListNode h=mid.next;
				
		mid.next=null;
		
		ListNode left=mergeSort(node);
		ListNode right=mergeSort(h);
		
		return mergeTwoLists(left,right);
	}
	
	
    public ListNode mergeKLists(ListNode[] lists) {
        return mergeKLists(lists,0,lists.length-1);
    }
    
    ListNode mergeKLists(ListNode[] lists,int start,int end)
    {
        if(lists==null || lists.length==0)
        {
            return null;
        }
        
        if(lists.length==1)
        {
            return lists[0];
        }
        
    	if(start==end)
    		return lists[start];
    	int mid= start + (end - start)/2;
    	ListNode left=mergeKLists(lists,start,mid);
    	ListNode right=mergeKLists(lists,mid+1,end);
    	return merge(left,right);
    	
    }
    
    ListNode merge(ListNode left,ListNode right)
    {
    	ListNode head=new ListNode();
    	ListNode cur=head;
    	
    	while(left!=null && right !=null)
    	{
    		if(left.value<right.value)
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
