package dfs;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak {

    public boolean wordBreak(String s, List<String> wordDict) {

        Set<String> dict = new HashSet<>(wordDict);

        HashMap<String,Boolean> mem=new HashMap<>();

        return wordBreakHelper(s,dict,mem);
    }

    private boolean wordBreakHelper(String curr,Set<String> dict,HashMap<String,Boolean> mem)
    {
        if(mem.containsKey(curr))
        {
            return mem.get(curr);
        }

        if(dict.contains(curr))
        {
            mem.put(curr,true);
            return true;
        }

        for(int i=0;i<curr.length();i++)
        {
            if(wordBreakHelper(curr.substring(0,i),dict,mem) && dict.contains(curr.substring(i)))
            {
                mem.put(curr.substring(0,i),true);
                return true;
            }
        }

        mem.put(curr,false);

        return false;
    }
}
