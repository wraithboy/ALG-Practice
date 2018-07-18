package twopointer;

import java.util.HashMap;

public class MinimumWindowSubstring {
    
	
	public static void main(String[] args)
	{
		
		MinimumWindowSubstring mws=new MinimumWindowSubstring();
		
		System.out.println(mws.minWindow("ADOBECODEBANC", "ABC"));
	}
	
	public String minWindow(String s, String t) {
		
		if(s==null || t==null || s.length()==0 || t.length()==0 || s.length()<t.length() )
			return "";
		
		int[] tmap = new int[256];
		int[] smap = new int[256];
				
		for(int i=0;i<t.length();i++)
		{
			char c=t.charAt(i);
			tmap[c]++;
		}
				
		int left=0;
		int right=0;
		int count=0;
		int resLeft=-1;
		int resRight=s.length();
		
		for(;right<s.length();right++)
		{
			char r=s.charAt(right);
			
			if(tmap[r]==0)
				continue;
			
			if(smap[r]<tmap[r])
			{
				count++;
			}
			
			smap[r]++;

			if(count!=t.length())
				continue;
						
			for(;left<right;left++)
			{
				char l=s.charAt(left);
				
				if(tmap[l]==0)
					continue;
				
				if(smap[l]>tmap[l])
				{
					smap[l]--;
				}
				else
				{
					break;
				}
			}
			
			if(right-left<resRight-resLeft)
			{
				resRight=right;
				resLeft=left;
			}
			
		}
				
		return resLeft==-1?"":s.substring(resLeft, resRight+1);
		
    }
}
