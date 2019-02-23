package permutationandcombination;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinations {

    public List<String> letterCombinations(String digits) {

        if(digits==null)
        {
            return null;
        }

        if(digits.length()==0)
        {
            return new ArrayList<String>();
        }

        List<String> result = new ArrayList<>();

        String[] mapping = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

        DFS("",mapping,0,digits,result);

        return result;
    }


    public void DFS(String curr,String[] mapping,int start,String digits,List<String> result)
    {
        if(curr.length()==digits.length())
        {
            result.add(new String(curr));
        }

        for(int i=start;i<digits.length();i++)
        {
            for( char c : mapping[digits.charAt(i)-'0'].toCharArray())
            {
                curr=curr+c;
                DFS(curr,mapping,i+1,digits,result);
                curr=curr.substring(0,curr.length()-1);
            }

        }

    }

}
