package datastructure;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;

public class TopKLargestNumbersII {
	int k;
	PriorityQueue<Integer> minHeap;
    /*
    * @param k: An integer
    */public TopKLargestNumbersII(int k) {
        // do intialization if necessary
    	this.k=k;
    	minHeap=new PriorityQueue();
    }

    /*
     * @param num: Number to be added
     * @return: nothing
     */
    public void add(int num) {
        // write your code here
    	if(minHeap.size()==k)
    	{
    		if(num>minHeap.peek())
    		{
    			minHeap.poll();
    			minHeap.offer(num);
    		}
    	}
    	else
		{
			minHeap.offer(num);
		}
    }

    /*
     * @return: Top k element
     */
    public List<Integer> topk() {
    	
    	ArrayList<Integer> rlt=new ArrayList();
    	
    	Iterator it=minHeap.iterator();
    	
    	while(it.hasNext())
    	{
    		int next=(int)it.next();
    		
    		rlt.add(next);
    	}
    	
    	Collections.sort(rlt, Collections.reverseOrder());
    	
    	return rlt;
        // write your code here
    }
	
}
