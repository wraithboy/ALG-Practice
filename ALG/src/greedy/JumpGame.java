package greedy;

public class JumpGame {


    // dynamic programming
    public boolean canJump(int[] nums) {

        if(nums==null || nums.length==0)
            return false;

        int[] dp = new int[nums.length];

        for(int i=1;i<nums.length;i++)
        {
            dp[i]=Math.max(dp[i-1],nums[i-1])-1;

            if(dp[i]<0)
                return false;
        }

        return true;

    }

    // greedy
    public boolean canJump1(int[] nums)
    {
        int maxReach=0;

        for(int i=0;i<nums.length;i++)
        {
            if(i>maxReach)
                return false;

            maxReach=Math.max(maxReach,i+nums[i]);
        }

        return true;
    }

}
