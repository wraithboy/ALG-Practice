package implementation;

import java.util.ArrayList;
import java.util.List;

public class PermutationUnique {
	
	public static void main(String args[])
	{
		
		
		
	}
	
	public static List<List<Integer>> PermuateUnique(int[] nums)
	{
		List<List<Integer>> list=new ArrayList<List<Integer>>();
		helper(nums,0,list);
		return list;
	}
	
	public static void helper(int[] nums,int start,List<List<Integer>> list)
	{
		
		if(start==nums.length-1)
		{
			List<Integer> tmp=new ArrayList<Integer>();
			
			for(int i: nums)
			{
				tmp.add(i);
			}
			
			list.add(tmp);
			
		}else
		{
			for(int j=start;j<nums.length;j++)
			{
				int tmp=nums[j];
				nums[j]=nums[start];
				nums[start]=tmp;
			}
		}
		
		
	}
	
}
