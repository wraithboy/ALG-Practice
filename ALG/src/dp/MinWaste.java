package dp;

import java.util.Arrays;

public class MinWaste {

    public static void main(String args[])
    {

        int[] a={3,5};

        System.out.println(minWaste(a,7));

    }

    public static int minWaste(int[] nums,int amount)
    {
        int[] dp = new int[amount+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0]=0;
        for(int i=1;i<=amount;i++)
        {
            for(int j=0;j<nums.length;j++)
            {
                int minWaste=Integer.MAX_VALUE;
                if(nums[j]>i)
                    dp[i]=Math.min(dp[i],Math.abs(i-nums[j]));
                else
                    dp[i]=Math.min(dp[i],dp[i-nums[j]]);
            }
        }


        return dp[amount];

    }
}
