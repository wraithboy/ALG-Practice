package twopointer;

import java.util.Arrays;

/*Question
Given an array of integers, find how many pairs in the array such that their sum is
bigger than a specific target number. Please return the number of pairs.
Example
Given numbers = [2, 7, 11, 15] , target = 24. Return 1. (11 + 15 is the only
pair)*/

public class TwoSumUnSorted {
	public int twoSum2(int[] nums, int target) {
		
		if(nums==null || nums.length==0)
			return 0;
		
		Arrays.sort(nums);
		
		int left=0;
		int right=nums.length-1;
		int count=0;
		
		while(left<right)
		{
			if(nums[left]+nums[right]>target)
			{
				count=count+right-left;
				right--;
			}
			else
			{
				left++;
			}
			
		}
		
		return count;
		
	}
}
