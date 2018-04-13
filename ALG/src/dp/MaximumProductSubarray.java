package dp;

public class MaximumProductSubarray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

		
	}
	
	
    int maxProduct(int[] nums) {
        // write your code here
        if(nums==null || nums.length==0)
    	{
    		return 0;
    	}
    		    	
    	int max=Integer.MIN_VALUE;
    	
    	int cur=1;
    	
    	for(int i=0;i<nums.length;i++)
    	{
    		cur=cur*nums[i];
    		if(cur>max)
    			max=cur;
    		else
    			cur=nums[i];
    	}
    	
    	if(cur>max)
    	max=cur;
    	
    	return max;
    		    	

    	
    }
}
