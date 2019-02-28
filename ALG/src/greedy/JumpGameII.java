package greedy;

public class JumpGameII {

    public int jump(int[] nums) {

        if(nums==null || nums.length<=1)
            return 0;

        int curMax=nums[0];
        int nextMax=curMax;
        int i=1;
        int step=1;

        while(i<=curMax)
        {
            while(i<=curMax)
            {
                nextMax=Math.max(curMax,i+nums[i]);
            }

            curMax=nextMax;
            step++;

            if(nextMax>=nums.length-1)
                return step;
        }

        return step;
    }


}
