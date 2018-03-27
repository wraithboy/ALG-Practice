package DP;

public class Backpack {

    public int backPack(int m, int[] A) {
        // write your code here
        if(A==null || A.length==0 )
        {
            return 0;
        }

        int[] dp=new int[m+1];

        for(int i=0;i<=m;i++)
        {
            dp[i]=0;
        }

        int min=Integer.MAX_VALUE;
        for(int i=0;i<A.length;i++)
        {
            min=Math.min(min,A[i]);
        }

        return maxBackPack(m,A,dp,min);

    }

    public int maxBackPack(int m,int[] A,int[] dp,int min)
    {
        if(m<min)
            return 0;

        if(dp[m]!=0)
            return dp[m];

        int max=0;

        for(int i=0;i<A.length;i++)
        {
            if(m-A[i]>=0)
                max=Math.max(max,A[i]+maxBackPack(m-A[i],A,dp,min));
        }

        dp[m]=max;

        return max;
    }


    public int backpack2d(int m,int[] A)
    {

        if(A==null || A.length==0 )
        {
            return 0;
        }

        boolean[][] dp=new boolean[A.length+1][m+1];

        dp[0][0]=true;

        for(int i=1;i<=A.length;i++)
        {
            for(int j=0;j<=m;j++)
            {
                dp[i][j]= (j-A[i-1]>=0 && dp[i-1][j-A[i-1]]) || dp[i-1][j];
            }
        }

        for(int i=m;i>=0;i--)
        {
            if(dp[A.length-1][m])
            {
                return i;
            }
        }

        return 0;
    }


}
