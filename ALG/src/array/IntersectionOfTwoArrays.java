package array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;

public class IntersectionOfTwoArrays {
	
	
    public int[] intersection(int[] nums1, int[] nums2) {
        // write your code here

		HashSet<Integer> result = new HashSet<>();

        if(nums1==null || nums1.length==0 || nums2==null || nums2.length==0)
        {
            return new int[]{};
        }

        HashSet<Integer> set = new HashSet<>();

        for(int i: nums1)
        {
            set.add(i);
        }

        for(int i: nums2)
        {
            if(set.contains(i))
            {
                result.add(i);
            }
        }

        int[] rlt = new int[result.size()];

        int i=0;

        for(int num : result)
        {
            rlt[i]=num;
            i++;
        }

    	return rlt;
    	
    }
    
}
