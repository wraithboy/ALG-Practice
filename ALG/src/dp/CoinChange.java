package dp;

import java.util.Arrays;

public class CoinChange {

    int steps=0;

    public int coinChange(int[] coins, int amount) {
        // define dp[i] = the minimum coin change needed to have amount i

        int[] dp=new int[amount+1];

        Arrays.fill(dp,amount+1);

        dp[0]=0;

        for(int i=1;i<=amount;i++)
        {
            for(int j=0;j<coins.length;j++)
            {
                if(coins[j]<=i)
                {
                    dp[i]=Math.min(dp[i],dp[i-coins[j]]+1);
                }
            }
        }

        return dp[amount]>amount?-1:dp[amount];
    }

}
