package DP;

public class HouseRobber {
	
	public static void main(String args[])
	{
		
	}
	
	   public long houseRobber(int[] A) {
		   
		   if(A==null || A.length==0)
			   return 0;
		   
		   long[] dp = new long[A.length];
		   
	        if(A.length==1)
	            return A[0];
	            else if(A.length==2)
	            return Math.max(A[0],A[1]);
		   
		   dp[0]=A[0];
		   dp[1]=Math.max(A[0], A[1]);
		   
		   for(int i=2;i<A.length;i++)
		   {
			   dp[i]= Math.max(A[i]+dp[i-2], dp[i-1]);
		   }
		   
		   return dp[A.length-1];
		   
	   }
	   
	   
	   public int houseRobber2(int[] nums) {
		   
		   if(nums==null || nums.length==0)
			   return 0;
		   		   
	        if(nums.length==1)
	            return nums[0];
	            else if(nums.length==2)
	            return Math.max(nums[0],nums[1]);
		   
			int[] dp = new int[nums.length];
			int[] dp2 = new int[nums.length];
			
			
			dp[0]=nums[0];
			dp[1]=nums[0];
			
			dp2[0]=0;
			dp2[1]=nums[1];	
			
			for(int i=2;i<nums.length;i++)
			{
				   dp[i]= Math.max(nums[i]+dp[i-2], dp[i-1]);
				   dp2[i]= Math.max(nums[i]+dp2[i-2], dp2[i-1]);
			}
			
			return Math.max(dp[nums.length-2], dp2[nums.length-1]);
	   }
	
	
}
