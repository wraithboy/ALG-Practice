package array;

public class LongestContinuousIncreasingSubsequence {

    public int findLengthOfLCIS(int[] nums) {

        if(nums==null || nums.length==0)
            return 0;

        if(nums.length==1)
            return 1;

        int maxLen=0;
        int curLen=0;
        for(int i=0;i<nums.length-1;i++)
        {
            if(nums[i]<nums[i+1])
            {
                curLen++;
                continue;
            }
            maxLen=Math.max(maxLen,curLen);
            curLen=1;
        }

        maxLen=Math.max(maxLen,curLen);

        return maxLen;

    }
}
