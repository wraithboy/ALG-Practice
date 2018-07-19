package twopointer;

import java.util.HashMap;

public class LongestSubstringWithoutRepeating {
	
	
	public static void main(String args[])
	{
		
		LongestSubstringWithoutRepeating lsw=new LongestSubstringWithoutRepeating();
		
		lsw.lengthOfLongestSubstring("abcabcbb");
		
		
	}
	
    public int lengthOfLongestSubstring(String s) {
        
		    	if(s==null || s.length()==0)
			return 0;
		
		HashMap<Character,Integer> map=new HashMap<>(); 
		
		
		int left=0;
		int right=0;
		
		int max=0;
		
		for(;left<s.length();left++)
		{			
			while( right<s.length() && !map.containsKey(s.charAt(right)))
			{
				map.put(s.charAt(right), 1);
				right++;
			}
						
			max=Math.max(max, right-left);
			
			map.remove(s.charAt(left));
			
		}
		
		
		return max;
    }
	
}
