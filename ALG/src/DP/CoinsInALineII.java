package DP;

public class CoinsInALineII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public boolean firstWillWin(int[] values) {
        // write your code here
    	
		if(values==null || values.length==0)
			return false;
		
		if(values.length<2)
			return true;
		
		int[] dp=new int[values.length+1];
		dp[values.length]=0;
		dp[values.length-1]=values[values.length-1];
		dp[values.length-2]=values[values.length-1]+values[values.length-2];
		dp[values.length-3]=values[values.length-3]+values[values.length-2];
		
		for(int i=values.length-4;i>=0;i--)
		{
			dp[i]=Math.max(values[i]+Math.min(dp[i+2], dp[i+3]),values[i]+values[i+1]+Math.min(dp[i+3], dp[i+4]));
		}
		
		int sum=0;
		
		for(int i=0;i<values.length;i++)
		{
			sum=sum+values[i];
		}
		
		if(dp[0]>(sum-dp[0]))
		{
			return true;
		}
		else
			return false;
    }
}
