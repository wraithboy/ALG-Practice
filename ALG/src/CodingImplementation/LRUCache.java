package CodingImplementation;

import java.util.Hashtable;

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

    private int capacity;

    private Hashtable<Integer,DlinkedListNode> cache;

    private DlinkedList dlist;

    public LRUCache(int capacity) {
        this.capacity=capacity;

        cache=new Hashtable<Integer,DlinkedListNode>(capacity);

        dlist=new DlinkedList();

    }

    public int get(int key) {

        int n;

        DlinkedListNode rlt=cache.get(key);

        if(rlt!=null)
        {
            n=rlt.getValue();
            dlist.remove(rlt);
            dlist.addToTail(rlt);
        }else
        {
            return -1;
        }

        return n;
    }

    public void put(int key, int value) {

        DlinkedListNode n=new DlinkedListNode(value);

        if(dlist.size<capacity)
        {
            cache.put(key,n);
            dlist.addToTail(n);
        }
        else
        {
            DlinkedListNode m=dlist.head;
            cache.remove(m);
            dlist.remove(m);
            cache.put(key,n);
            dlist.addToTail(n);
        }
    }
}

class DlinkedList {

    DlinkedListNode head=null;
    DlinkedListNode tail=null;

    public int size=0;

    public void addToTail(DlinkedListNode n)
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
            tail.prev=null;
        }

        size++;
    }

    public void remove(DlinkedListNode k)
    {
          if(size<=0)
          {
              return;
          }
          else{

              if(k.prev==null)
              {
                  tail=k.next;
                  k.next=null;
              }else if(k.next==null)
              {
                  head=k.prev;
                  k.prev=null;
              }
              else {
                  k.prev.next = k.next;
                  k.prev = null;
                  k.next = null;
              }
          }
        size--;
    }


}

class DlinkedListNode {

    DlinkedListNode prev=null;

    public DlinkedListNode(int value) {
        this.value = value;
    }

    DlinkedListNode next=null;
    int value;

    public DlinkedListNode getNext() {
        return next;
    }

    public void setNext(DlinkedListNode next) {
        this.next = next;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

}