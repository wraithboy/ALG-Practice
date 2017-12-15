package array;

import java.util.ArrayList;
import java.util.Hashtable;

public class IntersectionOfTwoArrays {
	
	
    public int[] intersection(int[] nums1, int[] nums2) {
        // write your code here
        
        if(nums1==null || nums1.length==0 || nums2==null || nums2.length==0)
        {
            int[] a={};
            return a;
        }

        
    	Hashtable<Integer, Integer> map=new Hashtable<Integer, Integer>();
    	Hashtable<Integer,Integer> intersectMap=new Hashtable<Integer,Integer>();
    	ArrayList<Integer> list=new ArrayList<Integer>();
    	
    	for(int i=0;i<nums1.length;i++)
    	{
    		map.put(nums1[i], 1);
    	}
    	
    	for(int i=0;i<nums2.length;i++)
    	{
    		if(map.containsKey(nums2[i]))
    		{
    			intersectMap.put(nums2[i], 1);
    		}
    	}
    	
    	int[] result = new int[intersectMap.size()];
    	
    	
    	int i=0;
    	for (int e : intersectMap.keySet())
    	{
    		result[i]=e;
    		i++;
    	}
    	
    	return result;
    	
    }
    
}
