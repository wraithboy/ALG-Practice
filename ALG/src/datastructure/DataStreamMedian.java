package datastructure;

import java.util.Collections;
import java.util.PriorityQueue;

public class DataStreamMedian {

    PriorityQueue<Integer> minHeap;
    PriorityQueue<Integer> maxHeap;
    /** initialize your data structure here. */
    public DataStreamMedian() {
        minHeap=new PriorityQueue<Integer>();
        maxHeap=new PriorityQueue<Integer>(Collections.reverseOrder());
    }

    public void addNum(int num) {

        if(maxHeap.size()==0 || maxHeap.peek()> num)
        {
            maxHeap.add(num);
        }
        else
        {
            minHeap.add(num);
        }

        if(maxHeap.size()-minHeap.size()>1)
        {
            minHeap.add(maxHeap.poll());
        }

        if(minHeap.size()-maxHeap.size()>1)
        {
            maxHeap.add(minHeap.poll());
        }

    }

    public double findMedian() {
        if(maxHeap.size()==minHeap.size())
        {
            return (maxHeap.peek()+minHeap.peek())/2.0d;
        }
        else
        {
            return maxHeap.size()>minHeap.size()?maxHeap.peek():minHeap.peek();
        }
    }

}
