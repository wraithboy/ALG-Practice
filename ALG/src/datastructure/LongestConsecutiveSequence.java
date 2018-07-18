package datastructure;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {
	
    public int longestConsecutive(int[] num) {
        // write your code here
        HashMap<Integer,Integer> map=new HashMap<>();
    	Set<Integer> set=new HashSet<>();
    	
    	for(int i=0;i<num.length;i++)
    	{
    		map.put(num[i], i);
    	}
    	int max=Integer.MIN_VALUE;
    	for(int i=0;i<num.length;i++)
    	{
    		if(set.contains(i))
    		{
    			continue;
    		}
    		else
    		{
    			set.add(i);
    			int j=num[i];
    			int len=1;
    			while(map.containsKey(j+1))
    			{
    				set.add(map.get(j+1));
    				j=j+1;
    				len++;
    			}
    			
    			j=num[i];
    			while(map.containsKey(j-1))
    			{
    				set.add(map.get(j-1));
    				j=j-1;
    				len++;
    			}    			
    			
    			max=Math.max(max, len);
    			
    		}
    	}
    	
    	return max;
    }
	
}
