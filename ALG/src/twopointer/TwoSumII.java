package twopointer;

public class TwoSumII {

    public int[] twoSum(int[] nums, int target) {
        // write your code here
    	if(nums==null || nums.length==0)
    		return null;
    	
    	int[] result = new int[2];
    	
    	
    	int start=0;
    	int end=nums.length-1;
    	
    	while(start<end)
    	{
    		if(nums[start]+nums[end]>target)
    		{
    			end--;
    		}
    		else if(nums[start]+nums[end]<target)
    		{
    			start++;
    		}
    		else
    		{
    			result[0]=start;
    			result[1]=end;
    			break;
    		}
    	}
    	
    	return result;
    }
	
}
