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
    	cache=new HashMap();
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

 		remove(n);

 		moveToTail(n);

    	return n.value;
    }

    public void remove (Node n)
	{
		if(n.prev==null)
		{
			head=n.next;
		}else
		{
			n.prev.next=n.next;
		}

		if(n.next==null)
		{
			tail=n.prev;
		}
		else
		{
			n.next.prev=n.prev;
		}

	}

    /*
     * @param key: An integer
     * @param value: An integer
     * @return: nothing
     */
    public void set(int key, int value) {
    	// write your code here
    	
 		if(cache.containsKey(key))
		{
			Node n = cache.get(key);
			n.value=value;
			remove(n);
			moveToTail(n);
		}else
		{
			Node n  =new Node(key,value);

			if(cache.size()==capacity)
			{
				cache.remove(head.key);
				remove(head);
				moveToTail(n);
			}
			else
			{
				moveToTail(n);
			}
			cache.put(key,n);
		}

    }
    
    public void moveToTail(Node n)
    {
		n.prev=tail;
		n.next=null;

		if(tail!=null)
		{
			tail.next=n;
		}

		tail=n;

		if(head==null)
		{
			head=tail;
		}
    }
}
