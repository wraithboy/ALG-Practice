package twopointer;

import java.util.HashMap;
import java.util.HashSet;

public class LongestSubstringwithAtMostKDistinct {
	
	public static void main(String args[])
	{
		
		LongestSubstringwithAtMostKDistinct a = new LongestSubstringwithAtMostKDistinct();
		
		System.out.println(a.lengthOfLongestSubstringKDistinct("eqgkcwGFvjjmxutystqdfhuMblWbylgjxsxgnoh", 16));
	}
	
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        // write your code here
    	
        if (s == null || s.length() == 0 || k == 0) {
            return 0;
        }
    	
    	HashMap<Character,Integer> set= new HashMap<>();
    	
    	int left=0;
    	int right=0;
    	
    	int max=0;

    	for(;right<s.length();right++)
    	{    		
    		
			if(!set.containsKey(s.charAt(right)))
			{
				set.put(s.charAt(right),1);
			}
			else
			{
				int cnt=set.get(s.charAt(right));
				set.put(s.charAt(right),cnt+1);
			}

			if(set.size()>k){
			
	    		max=Math.max(max, right-left);
	    		System.out.println(left+" "+right);
	    		
	    		while(set.size()>k){
	    			System.out.println(s.charAt(left));
	    			if(set.get(s.charAt(left))==1)
	    			{
	    				set.remove(s.charAt(left));
	    			}
	    			else
	    			{
	    				int cnt=set.get(s.charAt(left));
	    				set.put(s.charAt(left), cnt-1);
	    			}
	    			left++;
	    		}
    		}
    	}

    	return max;
    }
}
