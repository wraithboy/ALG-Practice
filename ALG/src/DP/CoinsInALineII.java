package DP;

public class CoinsInALineII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public boolean firstWillWin(int[] values) {
        // write your code here
    	
    	if(values==null || values.length==0)
    		return false;
    	
    	int[] dp=new int[values.length];
    	
    	
    	dp[values.length-1]=values[values.length-1];
    	dp[values.length-2]=values[values.length-1]+values[values.length-2];
    	dp[values.length-3]=values[values.length-1]+values[values.length-2];
    	for(int i=values.length-3;i>=0;i--)
    	{
    		dp[i]=Math.max(values[i]+Math.max(dp[i+1], dp[i+2]),values[i]+values[i+1]);
    		
    	}
    	
    	
    }
	
}
