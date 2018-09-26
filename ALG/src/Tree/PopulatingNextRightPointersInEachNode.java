package Tree;

class TreeLinkNode {
     int val;
     TreeLinkNode left, right, next;
     TreeLinkNode(int x) { val = x; }
}

public class PopulatingNextRightPointersInEachNode {
    public void connect(TreeLinkNode root) {
        TreeLinkNode ptr=root;
        
		while(ptr!=null)
		{
		    
		    TreeLinkNode left=ptr;
		    
		    while(ptr!=null)
		    {
		                        if(ptr.left!=null)
		        {
		            ptr.left.next=ptr.right;
		        }
		
		        if(ptr.right!=null && ptr.next!=null)
		        {
		            ptr.right.next = ptr.next.left;
		        }
		
		
		        ptr=ptr.next;
		
		    }
		
		    ptr=left.left;
		}
}
}
