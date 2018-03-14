package DP;

public class LongestPalindromicSubstring {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		
	}
	
    public String longestPalindrome(String s) {
        // write your code here
    	if(s==null || s.length()==0)
    		return null;
    	
    	if(s.length()==1)
    		return s;
    	
    	boolean[][] dp = new boolean[s.length()][s.length()];
    	
    	int left=0,right=0;
    	
    	for(int j=1;j<s.length();j++)
    	{
    		for(int i=0;i<j;i++)
    		{
    				dp[i][j]= s.charAt(i)==s.charAt(j) && (j-i<=2 || dp[i+1][j-1]);	
    				
    				if(dp[i][j])
    				{
    					if(j-i>right-left)
    					{
    						left=i;
    						right=j;
    					}
    				}
    				
    		}
    	}
		return s.substring(left, right+1);
    }
    
    public String longestPalindrome2(String s) {
    	
    	if(s==null || s.length()==0)
    		return null;
    	
    	if(s.length()==1)
    		return s;
    	
    	int start=0;
    	int maxlen=0;
    	
    	for(int i=1;i<s.length();i++)
    	{
    		
    		int l=i-1;
    		int r=i;
    		
    		while(l>=0 && r<s.length() && s.charAt(l)==s.charAt(r))
    		{

				l--;
				r++;
    		}
    		
	    	if(r-l-1>maxlen)
	    	{
	    		start=l+1;
	    		maxlen=r-l-1;
	    	}
    		
    		l=i-1;
    		r=i+1;
    		
    		while(l>=0 && r<s.length() && s.charAt(l)==s.charAt(r))
    		{

				l--;
				r++;
    		}
    		
	    	if(r-l-1>maxlen)
	    	{
	    		start=l+1;
	    		maxlen=r-l-1;
	    	}
    		
    	}
    	
    	
    	return s.substring(start, start+maxlen);
    }
}
