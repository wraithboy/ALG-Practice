package datastructure;

import java.util.ArrayDeque;
import java.util.Deque;

public class SlidingWindowMaximum {

    public int[] maxSlidingWindow(int[] nums, int k) {

        int[] result=new int[nums.length-k+1];

        if(nums==null || nums.length==0)
        {
            return new int[0];
        }


        Deque<Integer> deque = new ArrayDeque<>();

        for(int i=0;i<k-1;i++)
        {
            inQueue(deque,nums[i]);
        }


        for(int i=k-1;i<nums.length;i++)
        {
            inQueue(deque,nums[i]);
            result[i-k+1]=deque.peekFirst();
            deQueue(deque,nums[i-k+1]);
        }

        return result;
    }

    public void inQueue(Deque<Integer> deque,int i)
    {
        while(!deque.isEmpty()&&deque.peekLast()<i)
        {
            deque.pollLast();
        }

        deque.offerLast(i);
    }

    public void deQueue(Deque<Integer> deque, int i)
    {
        if(deque.peekFirst()==i)
        {
            deque.pollFirst();
        }
    }

}

