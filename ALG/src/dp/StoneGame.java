package dp;

public class StoneGame {

    public int stoneGame(int[] A) {

        int max=0;

        int[][] dp=new int[A.length][A.length];
        int[][] visited=new int[A.length][A.length];
        int[][] sum=new int[A.length][A.length];

        if(A==null || A.length==0)
            return 0;

        for(int i=0;i<A.length;i++)
        {
            dp[i][i]=0;
        }

        for(int i=0;i<A.length;i++)
        {
            sum[i][i]=A[i];
            for(int j=i+1;j<A.length;j++)
            {
                sum[i][j]=sum[i][j-1]+A[j];
            }
        }

        return search(A,0,A.length-1,dp,visited,sum);

    }

    public int search(int[] A,int start,int end,int[][] dp,int[][] visited, int[][] sum)
    {
        if(visited[start][end]==1)
            return dp[start][end];

        if(start==end)
        {
            visited[start][end]=1;
            return dp[start][end];
        }

        dp[start][end]=Integer.MAX_VALUE;

        for(int i=start;i<end;i++)
        {
            dp[start][end]=Math.min(dp[start][end],search(A,start,i,dp,visited,sum)+search(A,i+1,end,dp,visited,sum)+sum[start][end]);
        }

        visited[start][end]=1;
        return dp[start][end];
    }

}
