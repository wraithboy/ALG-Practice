package datastructure;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KthLargestElement {

    public int kthLargestElement(int k, int[] nums) {
        // write your code here

        if(nums==null || nums.length==0 || k<=0 || k>nums.length )
            return 0;

        int pivot;
        int start=0;
        int end=nums.length-1;

        while(true)
        {
            pivot=partition(nums,start,end);

            if(pivot+1==k)
            {
                break;
            }
            else if(pivot+1<k)
            {
                start=pivot+1;
            }
            else
            {
                end=pivot-1;
            }

        }

        return nums[pivot];

    }

    private int partition(int[] nums,int start,int end)
    {

        int pivot=start;

        while(start<=end)
        {
            while(start<=end && nums[start]>=nums[pivot])
            {
                start++;
            }

            while(start<=end && nums[end]<nums[pivot])
            {
                end--;
            }

            if(start>end)
                break;

            swap(nums,start,end);

        }

        swap(nums,end,pivot);

        return end;
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
