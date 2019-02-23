package DFS;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {

    public List<List<String>> partition(String s)
    {

        ArrayList<List<String>> result = new ArrayList<>();

        if(s==null || s.length()==0)
        {
            return result;
        }

        DFS(new ArrayList<String>(),0,s,result);

        return result;
    }

    public void DFS(ArrayList<String> curr,int start,String s,List<List<String>> result)
    {
        if(curr.size()==s.length())
        {
            result.add(new ArrayList<String>(curr));
            return;
        }

        for(int i=start;i<s.length();i++)
        {
            if(isPalindrome(s,i,s.length()))
            {
                curr.add(s.substring(start,i+1));
                DFS(curr,i,s,result);
                curr.remove(curr.size()-1);
            }
        }
    }


    public boolean isPalindrome(String s,int l,int r)
    {
        char[] chs=s.toCharArray();

        while(l<r)
        {
            if(s.charAt(l)==s.charAt(r))
            {
                l++;
                r--;
            }
        }

        return l>=r;
    }

}
