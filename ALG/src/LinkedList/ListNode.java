package linkedlist;

public class ListNode {
	int val;
	ListNode next;
	
	public ListNode()
	{
		this.val=0;
	}
	
	public ListNode(int i)
	{
		this.val=i;
	}
	
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
			System.out.println(cur.val);
			sb.append(cur.val);
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
		a.val =0;
		a.next=b;
		b.val=3;
		b.next=c;
		c.val=4;
		c.next=null;
		aa.val =1;
		aa.next=bb;
		bb.val=2;
		bb.next=cc;
		cc.val=5;
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
			if(l1.val<l2.val)
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
			System.out.print(ptr.val);
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
	
    public ListNode detectCycle(ListNode head) {
    	
    	if(head==null || head.next==null)
    		return null;
    	
    	ListNode slow=head;
    	ListNode fast=head;
    	
    	while(fast!=null && fast.next!=null)
    	{

    		slow=slow.next;
    		fast=fast.next.next;
    		
    		if(slow==fast)
    			break;
    	}
    	
    	if(fast==null || fast.next==null)
    		return null;
    	
    	int len=0;
    	
    	while(fast.next!=null)
    	{
    		slow=slow.next;
    		fast=fast.next.next;
    		len=len+2;
    		if(slow==fast)
    			break;
    	}
    	
    	fast=head;
    	slow=head;
    	
    	for(int i=0;i<len;i++)
    	{
    		fast=fast.next;
    	}
    	
    	while(fast!=slow)
    	{
    		fast=fast.next;
    		slow=slow.next;
    	}
    	
    	return slow;
    }
    
    public ListNode detectCycle2(ListNode head)
    {
    	if(head==null || head.next==null)
    		return null;
    	
    	ListNode slow=head;
    	ListNode fast=head;
    	
    	while(fast!=null && fast.next!=null)
    	{
    		slow=slow.next;
    		fast=fast.next.next;
            
            if(slow==fast)
    			break;
    	}
    	
    	if(fast==null || fast.next==null)
    		return null;
    	
        ListNode slow2=head;
        
        while(slow2!=slow)
        {
            slow=slow.next;
            slow2=slow2.next;
        }
        
        return slow;
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
        
 }
