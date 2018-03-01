package array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SubArraySum {
	public static void main(String args[])
	{
		
	}
	
	
	
	
	public static List<Integer> subarraySum(int[] nums){
		
        if(nums==null || nums.length==0) {
            return null;
        }
		
		List<Integer> list=new ArrayList<Integer>();
		
		int[] sumArray=new int[nums.length+1];
		
		sumArray[0]=0;
		
		for(int i=0;i<nums.length;i++)
		{
			sumArray[i+1]=nums[i]+sumArray[i];
		}
		
		HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
		
		for(int i=0;i<sumArray.length;i++)
		{
			if(map.containsKey(sumArray[i])){
				int start=map.get(sumArray[i]);
				int last=i;
				list.add(start);
				list.add(last-1);
				return list;
			}
			else
			{
				map.put(sumArray[i],i);
			}
				
		}
		
		return list;
		
	}
}
