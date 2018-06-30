package datastructure;

import java.util.Comparator;
import java.util.PriorityQueue;

public class FindDataStreamMedian {

    PriorityQueue<Integer> max;
    PriorityQueue<Integer> min;

    /** initialize your data structure here. */
    public FindDataStreamMedian() {
        min=new PriorityQueue<>();
        max=new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
    }

    public void addNum(int num) {

        if(max.isEmpty() || max.peek() > num)
        {
            max.offer(num);
        }
        else
        {
            min.offer(num);
        }


        if(max.size()-min.size()>1)
        {
            min.offer(max.poll());
        }

        if (min.size()-max.size()>1)
        {
            max.offer(min.poll());
        }

    }

    public double findMedian() {
        if(max.size()==min.size())
        {
            return (max.peek()+min.peek())/2.0;
        }
        else if(max.size()>min.size())
        {
            return max.peek();
        }
        else
        {
            return min.peek();
        }
    }
}
