package CodingImplementation;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedList;

/**
 * Created by h.dong on 4/6/2017.
 *
 * Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and put.

 get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
 put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.

 Follow up:
 Could you do both operations in O(1) time complexity?

 Example:

 LRUCache cache = new LRUCache( 2 )
**/

//        cache.put(1, 1);
//        cache.put(2, 2);
//        cache.get(1);       \// returns 1
//        cache.put(3, 3);    \// evicts key 2
//       cache.get(2);      \// returns -1 (not found)
//        cache.put(4, 4);   \// evicts key 1
//        cache.get(1);      \// returns -1 (not found)
//        cache.get(3);      \// returns 3
//        cache.get(4);      \ // returns 4



public class LRUCache {

    HashMap<Integer,DLinkedNode> cache;
    int capacity=0;
    DLinkedNode head;
    DLinkedNode tail;

    public LRUCache(int capacity){
        this.capacity=capacity;
        cache=new HashMap<>(capacity);
        head= new DLinkedNode();
        tail= new DLinkedNode();

        tail.next=head;
        head.prev=tail;
    }

    private void addNode(DLinkedNode n)
    {
        n.prev=tail;
        n.next=tail.next;

        tail.next.prev=n;
        tail.next=n;
    }

    private void removeNode(DLinkedNode node)
    {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void moveToTail(DLinkedNode n)
    {
        removeNode(n);
        addNode(n);
    }

    private DLinkedNode popHead()
    {
        DLinkedNode n = head.prev;
        removeNode(n);
        return n;
    }



    class DLinkedNode {
        int key;
        int value;
        DLinkedNode prev;
        DLinkedNode next;
    }

    public int get(int key) {

        if(cache.containsKey(key))
        {
            moveToTail(cache.get(key));
            return cache.get(key).value;
        }
        else
        {
            return -1;
        }

    }

    public void put(int key, int value) {

        if(cache.containsKey(key))
        {
            DLinkedNode node= cache.get(key);
            node.value=value;
            moveToTail(node);
        }
        else
        {
            DLinkedNode newNode = new DLinkedNode();
            newNode.key=key;
            newNode.value=value;
            if(cache.size()==capacity) {
                DLinkedNode victim = popHead();
                cache.remove(victim.key);
                removeNode(victim);
            }

            cache.put(key,newNode);
            addNode(newNode);
        }
    }

}