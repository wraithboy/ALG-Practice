package datastructure;

public class Rehashing {
	
	
    public ListNode[] rehashing(ListNode[] hashTable) {
		
        // write your code here
    	
    	if(hashTable==null && hashTable.length==0)
    		return null;
    	
    	int newSize=hashTable.length*2;
    	
    	ListNode[] table = new ListNode[newSize];
    	
    	for(int i=0;i<hashTable.length;i++)
    	{
    		if(hashTable[i]!=null)
    		{
    			ListNode n=hashTable[i];
    			
    			while(n!=null)
    			{
	    			int hash=(n.val%newSize + newSize)%newSize;
	    			
	    			if(table[hash]==null)
	    			{
	    				table[hash]=new ListNode(n.val);
	    			}
	    			else
	    			{
	    				ListNode node=table[hash];
	    				
	    				while(node.next!=null)
	    				{
	    					node=node.next;
	    				}
	    				
	    				node.next=new ListNode(n.val);	    				
	    			}
	    			
	    			n=n.next;
    			}
    			
    		}
    		
    	}
    	
    	return table;
    }
	
}
