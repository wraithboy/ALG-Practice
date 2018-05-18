package datastructure;

import java.util.HashMap;

/*
 * Description
Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and set.

get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
set(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.
 * 
 */

public class LRUCache {
	
	int capacity;
	Node head=null;
	Node tail=null;
	HashMap<Integer,Node> cache;
	
	class Node {
		
		Node prev;
		Node next;
		
		int key;
		int value;
		
		public Node (int key, int value)
		{
			this.key=key;
			this.value=value;
		}
	}
	
	
    /*
    * @param capacity: An integer
    */public LRUCache(int capacity) {
        // do intialization if necessary
    	this.capacity=capacity;
    	cache=new HashMap(capacity);
    }

    /*
     * @param key: An integer
     * @return: An integer
     */
    public int get(int key) {
        // write your code here
    	if(!cache.containsKey(key))
    	{
    		return -1;
    	}
    	
    	Node n=cache.get(key);
    	
    	if(n.prev!=null)
    	{
    		tail=n.prev;
        	tail.next=n.next;
        	n.prev=null;
    	}
    	
    	
    	moveToTail(n);
    	
    	return n.value;
    }

    /*
     * @param key: An integer
     * @param value: An integer
     * @return: nothing
     */
    public void set(int key, int value) {
    	// write your code here
    	
    	if(get(key)!=-1)
    	{
    		Node t=cache.get(key);
    		t.value=value;
    		return;
    	}
    	else
    	{
    		if(cache.size()==capacity)
    		{
    			cache.remove(key);
    			
    			if(head!=null)
    			{
        			head.prev.next=null;
        			head=head.prev;
    			}
    		}
    	}

    	Node n=new Node(key,value);
    	cache.put(key, n);
    	moveToTail(n);
    }
    
    public void moveToTail(Node n)
    {
    	if(head==null && tail==null)
    	{
    		head=n;
    		tail=n;
    	}
    	else
    	{
        	n.next=tail;
        	tail.prev=n;
        	tail=n;
    	}
    }
}
