package LeetCodeQuestions;

import java.util.ArrayList;
import java.util.List;

//Given a collection of numbers, return all possible permutations.

//For example,
//[1,2,3] have the following permutations:
//[1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1].

public class Permutation {

		public static void main(String args[])
		{
			int[] testArray={1,2,3};
			
			List<List<Integer>> list=new ArrayList<List<Integer>>();
			
			permute2(testArray,0,list);
			
			for(List<Integer> s: list)
			{
				for(int i: s)
				{
					System.out.print(i);
				}
				
				System.out.print("|");
				
			}
			
			System.out.println(" "+list.size());
		}
		
		
		public static void permute2(int[] nums,int start,List<List<Integer>> list)
		{
			
			List<Integer> alist;
						
			for(int i=0;i<nums.length;i++)
			{
				
				int a=nums[i];
				
				if(i==0)
				{
					alist=new ArrayList<Integer>();
					alist.add(a);
					list.add(alist);
				}
				else
				{
						List<List<Integer>> copyList=new ArrayList<List<Integer>>();
						
						
						for(List<Integer> l: list)
						{
							copyList.add(l);
						}
						
						list.clear();
						
						for(List<Integer> l : copyList)
						{
							for(int j=0;j<=l.size();j++)
							{
								alist=new ArrayList<Integer>();
								
								alist.addAll(l);
								
								if(j==l.size())
								{
									alist.add(a);
									list.add(alist);
								}
								else
								{
									alist.add(j,a);
									
									list.add(alist);
									
								}
		
							}
						}
		
					}
			}
			
		}
		
		
	    public static void permute(int[] nums, int start,List<List<Integer>> list) {
	        
	    	if(start==nums.length-1)
	    	{
	    		ArrayList<Integer> alist=new ArrayList<Integer>();
	    		for(int i=0;i<nums.length;i++)
	    		{
	    			alist.add(nums[i]);
	    		}
	    		
	    		list.add(alist);
	    		
	    	}
	    	else
	    	{
		    	for(int i=start;i<nums.length;i++)
		    	{
		    		int[] array1=nums.clone();
		    		
		    		int tmp=array1[start];
		    		
		    		array1[start]=array1[i];

		    		array1[i]=tmp;
		    		
		    		permute(array1,start+1,list);
		    	}
	    	} 	
	    	
	    }
	
}
