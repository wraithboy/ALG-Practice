package tree;

public class PopulatingNextRightPointersInEachNodeII {
	
    public void connect(TreeLinkNode root) {
        
    	TreeLinkNode ptr=root;
    	TreeLinkNode prev=null;
    	TreeLinkNode head=null;
    	
    	while(ptr!=null)
    	{
    		while(ptr!=null)
    		{
    			
    			if(ptr.left!=null)
    			{
    				if(prev==null)
    				{
    					head=ptr.left;
    					prev=ptr.left;
    				}
    				else
    				{
    					prev.next=ptr;
    					prev=ptr;
    				}
    			}
    			
    			if(ptr.right!=null)
    			{
    				if(prev==null)
    				{
    					head=ptr.right;
    					prev=ptr.right;
    				}
    				else
    				{
    					prev.next=ptr;
    					prev=ptr;
    				}
    			}
    			
    			ptr=ptr.next;
    		}
    		
    		ptr=head;
    		head=null;
    	}
    
    }
    
	 public void connect2(TreeLinkNode root) {
		 
	    	TreeLinkNode ptr=root;
	    	TreeLinkNode dummyhead=new TreeLinkNode(0);
	    	TreeLinkNode prev=dummyhead;
	    	
	    	while(ptr!=null)
	    	{
	    		if(ptr.left!=null)
	    		{
	    			prev.next=ptr.left;
	    			prev=ptr.left;
	    		}
	    		
	    		if(ptr.right!=null)
	    		{
	    			prev.next=ptr.right;
	    			prev=ptr.right;
	    		}
	    		
	    		if(ptr.next!=null)
	    		{
	    			ptr=ptr.next;
	    		}
	    		else
	    		{
	    			ptr=dummyhead.next;
	    			dummyhead.next=null;
	    			prev=dummyhead;
	    		}
	    	}
		 
	 }
}
