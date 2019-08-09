package dp;

public class LongestPalindromicSubstring {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}


	
    public String longestPalindrome(String s) {
        // write your code here
    	if(s==null || s.length()==0)
    		return null;

    	//dp[i][j] i to j is an palindrome

    	boolean[][] dp = new boolean[s.length()][s.length()];

		return null;
    }
    
    public String longestPalindrome2(String s) {
    	
    	if(s==null || s.length()==0)
    		return null;

		if(s.length()<2)
			return s;

		int maxLen=1;
		int low=0;

		for(int i=0;i<s.length()-1;i++)
		{
			int left=i,right=i;

			while(right+1<s.length() && s.charAt(right)==s.charAt(right+1))
			{
				right=right+1;
			}

			while(left-1>=0&&right+1<s.length() && s.charAt(left-1)==s.charAt(right+1))
			{
				left--;
				right++;
			}

			if(maxLen<=(right-left+1))
			{
				maxLen=Math.max(right-left+1,maxLen);
				low=left;
			}
		}

		return s.substring(low,low+maxLen);

    }

}
