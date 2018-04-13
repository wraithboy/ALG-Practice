package highfrequency;

import java.util.Arrays;

public class TwoSumCloset {
	
	public	int	twoSumCloset(int[]	nums,	int	target)	{
		
		if(nums==null || nums.length<2 )
			return -1;
		
		Arrays.sort(nums);
		
		int i=0;
		int j=nums.length-1;
		int min=target-nums[i]-nums[j];
		while(i<j)
		{
			if(nums[i]+nums[j]>target)
			{
				j--;
			}
			else
			{
				i++;
			}
		}
		
		return target - nums[i-1]+nums[j];
	}
	
}
