package string;

public class VliadPalindromeII {

    public boolean validPalindrome(String s) {
        if(s==null || s.length()==0 || s.length()==1)
            return true;

        int i=0,j=s.length()-1;

        while(i<j)
        {
            if(s.charAt(i)==s.charAt(j))
            {
                i++;
                j--;
            }
            else
            {
                return isPalindrome(s,i+1,j) || isPalindrome(s,i,j-1);
            }
        }

        return true;
    }

    private boolean isPalindrome(String s,int start, int end)
    {
        while(start<end)
        {
            if(s.charAt(start)==s.charAt(end))
            {
                start++;
                end--;
            }
            else
            {
                return false;
            }
        }

        return true;
    }

}
