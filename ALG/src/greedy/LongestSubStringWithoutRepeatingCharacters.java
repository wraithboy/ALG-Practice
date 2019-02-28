package greedy;

import java.util.Arrays;

public class LongestSubStringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {

        if(s==null || s.isEmpty() )
            return 0;

        int[] last = new int[256];

        Arrays.fill(last,-1);

        char[] str= s.toCharArray();

        int start=0;
        int end=0;

        int maxLen=0;

        while(end<str.length)
        {
            if(last[str[end]]>=start)
            {
                maxLen=Math.max(maxLen,end-start);
                start=last[str[end]]+1;
            }

            last[str[end]]=end;

            end++;
        }

        return Math.max(maxLen,end-start);
    }
}
