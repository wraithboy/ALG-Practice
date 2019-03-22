package binarysearch;

public class FindPeakElement {

    public int findPeakElement(int[] nums) {

        if(nums==null || nums.length==0)
        {
            return 0;
        }

        return findPeak(nums,0,nums.length-1);
    }


    private int findPeak(int[] nums,int start,int end)
    {
        if(start==end)
            return start;

        int mid = start+(end-start)/2;

        if(nums[mid]>nums[mid+1])
        {
            return findPeak(nums,start,mid);
        }
        else
        {
            return findPeak(nums,mid+1,end);
        }
    }
}
