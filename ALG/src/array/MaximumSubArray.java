package array;

public class MaximumSubArray {

    /*
        Given an array of integers, find a contiguous subarray which has the largest
        sum.
        Example
        Given the array [−2,2,−3,4,−1,2,1,−5,3], the contiguous subarray [4,−1,2,1]
        has the largest sum =
     */

    public static void main(String args[])
    {



    }


    public int maxSubArray(int[] nums) {

        if(nums==null) {
            return -1;
        }

        if(nums.length==0)
        {
            return 0;
        }

        int max=Integer.MIN_VALUE;
        int maxPrev=nums[0];

        for(int i=0;i<nums.length;i++)
        {

            if(maxPrev>=0) {
                maxPrev = maxPrev + nums[i];
            }
            else
            {
                maxPrev=nums[i];
            }

            if(max<maxPrev)
            {
                max=maxPrev;
            }

        }

        return max;

    }

    public int maxSubArrayDP(int nums[]){

        if(nums==null) {
            return -1;
        }

        if(nums.length==0)
        {
            return 0;
        }

        int[] dp=new int[nums.length];
        int max=Integer.MIN_VALUE;

        dp[0]=nums[0];

        for(int i=0;i<nums.length;i++)
        {
            dp[i]=Math.max(dp[i]+nums[i],nums[i]);
            max=Math.max(dp[i],max);
        }

        return max;
    }

}
