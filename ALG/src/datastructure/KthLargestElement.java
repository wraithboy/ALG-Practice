package datastructure;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KthLargestElement {

    public int kthLargestElement(int k, int[] nums) {
        // write your code here

        if(nums==null || nums.length==0 || k<=0 || k>nums.length )
            return 0;

        int start=0,end=nums.length-1;
        while(true)
        {
            int index=partition(nums,start,end);

            if(index==k-1)
            {
                return nums[index];
            }
            else if (index>k-1)
            {
                end=index-1;
            }
            else
            {
                start=index+1;
            }
        }

    }

    private int partition(int[] nums,int start,int end)
    {

        int pivot = end;

        while(start<end)
        {
            while(nums[start]>pivot) start++;
            while(nums[end]<pivot) end--;

            if(start<end)
            {
                swap(nums,start,end);
            }
        }

        return start;
    }

    private void swap(int[] nums,int i, int j)
    {
        int tmp=nums[i];
        nums[i]=nums[j];
        nums[j]=tmp;

    }

    // Use maxheap
    public int KthLargestElement2(int[] nums,int k)
    {
        PriorityQueue<Integer> maxHeap=new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });

        for(int i=0;i<nums.length;i++)
        {
            maxHeap.offer(nums[i]);
        }

        for(int i=0;i<k-1;)
        {
            maxHeap.poll();
        }

        return maxHeap.peek();

    }
}
